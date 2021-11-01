package com.k19.models;

import java.text.NumberFormat;

public class lineItemJPA {
    private productJPA product;
    private int qty;

    public lineItemJPA() {
    }

    public productJPA getProduct() {
        return product;
    }

    public void setProduct(productJPA product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotal() {
        return product.getPrice() * qty;
    }

    public String getpriceFormatTotal() {
        NumberFormat cformat = NumberFormat.getCurrencyInstance();
        return cformat.format(this.getTotal());
    }

}
