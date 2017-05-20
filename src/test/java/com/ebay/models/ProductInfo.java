package com.ebay.models;

public class ProductInfo {
    private String name;
    private String price;

    public ProductInfo(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String toString() {
        return "Product name:" + this.name + ". Product price: " + this.price;
    }

    @Override
    public boolean equals(Object anotherObject) {
        if (!(anotherObject instanceof ProductInfo))
            throw new ClassCastException("Should be ProductInfo object");
        ProductInfo anotherProductInfo = (ProductInfo) anotherObject;
        if (anotherObject == this)
            return true;
        if (this.getName().compareTo(anotherProductInfo.getName()) == 0 && this.getPrice().compareTo(anotherProductInfo.getPrice()) == 0)
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }
}