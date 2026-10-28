package com.example.demo.quickrelief;

public class SupplyRequest {
    private Integer id;
    private String itemName;
    private Integer quantity;
    private String status;
    private String requestedBy;

    public SupplyRequest() {
    }

    public SupplyRequest(Integer id, String itemName, Integer quantity, String status, String requestedBy) {
        this.id = id;
        this.itemName = itemName;
        this.quantity = quantity;
        this.status = status;
        this.requestedBy = requestedBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }
}