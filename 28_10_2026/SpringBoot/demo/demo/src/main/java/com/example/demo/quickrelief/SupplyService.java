package com.example.demo.quickrelief;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SupplyService {

    private final SupplyRepository supplyRepository;

    public SupplyService(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }

    public List<Supply> getAllSupplies() {
        return supplyRepository.findAll();
    }

    @Transactional
    public Supply addOrRestockSupply(Supply incoming) {
        if (incoming.getItemName() == null || incoming.getItemName().isBlank()) {
            throw new IllegalArgumentException("Item name is required.");
        }
        if (incoming.getQuantity() == null || incoming.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0.");
        }

        Optional<Supply> existing = supplyRepository.findByItemName(incoming.getItemName());
        if (existing.isPresent()) {
            int updatedQty = existing.get().getQuantity() + incoming.getQuantity();
            supplyRepository.updateQuantity(incoming.getItemName(), updatedQty);
        } else {
            supplyRepository.insertSupply(incoming.getItemName(), incoming.getQuantity());
        }

        return supplyRepository.findByItemName(incoming.getItemName()).orElseThrow();
    }

    @Transactional
    public SupplyRequest allocateSupply(SupplyRequest request) {
        if (request.getQuantity() == null || request.getQuantity() <= 0) {
            throw new IllegalArgumentException("Requested quantity must be greater than 0.");
        }

        Supply currentSupply = supplyRepository.findByItemName(request.getItemName())
                .orElseThrow(() -> new IllegalStateException("Item not found in inventory: " + request.getItemName()));

        if (currentSupply.getQuantity() < request.getQuantity()) {
            throw new IllegalStateException(
                    "Insufficient stock for " + request.getItemName() +
                            ". Available: " + currentSupply.getQuantity() +
                            ", Requested: " + request.getQuantity()
            );
        }

        // Deduct remaining quantity and save request inside @Transactional
        int remaining = currentSupply.getQuantity() - request.getQuantity();
        supplyRepository.updateQuantity(currentSupply.getItemName(), remaining);

        request.setStatus("APPROVED");
        supplyRepository.insertRequest(request);

        return request;
    }
}