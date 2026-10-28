package com.example.demo.quickrelief;

public class Supply {
    private Integer id;
    private String itemName;
    private Integer quantity;

    public Supply() {
    }

    public Supply(Integer id, String itemName, Integer quantity) {
        this.id = id;
        this.itemName = itemName;
        this.quantity = quantity;
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
}