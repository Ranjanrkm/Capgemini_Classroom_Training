package com.example.demo.quickrelief;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SupplyController {

    private final SupplyService supplyService;

    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    // 1. POST /api/supplies - Add new items or restock existing supply levels
    @PostMapping("/supplies")
    public ResponseEntity<?> addOrRestockSupply(@RequestBody Supply supply) {
        try {
            Supply saved = supplyService.addOrRestockSupply(supply);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    // 2. GET /api/supplies - View all available inventory
    @GetMapping("/supplies")
    public ResponseEntity<List<Supply>> getAllSupplies() {
        return ResponseEntity.ok(supplyService.getAllSupplies());
    }

    // 3. POST /api/requests - Claim or allocate an item with transactional validation
    @PostMapping("/requests")
    public ResponseEntity<?> createSupplyRequest(@RequestBody SupplyRequest request) {
        try {
            SupplyRequest processed = supplyService.allocateSupply(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(processed);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}