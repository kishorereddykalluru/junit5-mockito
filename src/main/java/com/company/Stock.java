package com.company;

public class Stock {

    private String stockId;
    private String name;
    private int quantity;

    public Stock(String stockId, String name, int quantity){
        this.stockId = stockId;
        this.name = name;
        this.quantity = quantity;
    }

    public void setStockId(String stockId){
        this.stockId = stockId;
    }

    public String getStockId(){
        return stockId;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getQuantity(){
        return quantity;
    }

}
