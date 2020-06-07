package com.telenor.boutique.dto;

import java.util.List;

public class Data {
    private List<Product> data;

    public Data() {
    }

    public Data(List<Product> data) {
        this.data = data;
    }

    public List<Product> getData() {
        return data;
    }

    public void setData(List<Product> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Data{" +
                "productList=" + data +
                '}';
    }
}
