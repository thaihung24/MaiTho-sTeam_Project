package com.k19.models;

import java.util.ArrayList;

public class cartJPA {
    private ArrayList<lineItemJPA> items;

    public cartJPA() {
        items = new ArrayList<lineItemJPA>();
    }

    public ArrayList<lineItemJPA> getItems() {
        return items;
    }

    public int getCount() {
        return items.size();
    }

    public void addItem(lineItemJPA item) {
        String code = item.getProduct().getCode();
        int qty = item.getQty();
        for (int i = 0; i < items.size(); i++) {
            lineItemJPA lineItem = items.get(i);
            if (lineItem.getProduct().getCode().equals(code)) {
                lineItem.setQty(qty);
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(lineItemJPA item) {
        String code = item.getProduct().getCode();
        for (int i = 0; i < items.size(); i++) {
            lineItemJPA lineItem = items.get(i);
            if (lineItem.getProduct().getCode().equals(code)) {
                items.remove(i);
                return;
            }
        }
    }
}
