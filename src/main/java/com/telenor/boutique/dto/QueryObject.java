package com.telenor.boutique.dto;

import java.util.Optional;

public class QueryObject {
    private Optional<String> type;
    private Optional<Integer> minPrice;
    private Optional<Integer> maxPrice;
    private Optional<String> city;
    private Optional<String> propertyName;
    private Optional<String> propertyColor;
    private Optional<Integer> propertyLimitMin;
    private Optional<Integer> propertyLimitMax;

    public QueryObject() {
    }

    public QueryObject(Optional<String> type, Optional<Integer> minPrice, Optional<Integer> maxPrice, Optional<String> city, Optional<String> propertyName, Optional<String> propertyColor, Optional<Integer> propertyLimitMin, Optional<Integer> propertyLimitMax) {
        this.type = type;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.city = city;
        this.propertyName = propertyName;
        this.propertyColor = propertyColor;
        this.propertyLimitMin = propertyLimitMin;
        this.propertyLimitMax = propertyLimitMax;
    }

    public Optional<String> getType() {
        return type;
    }

    public void setType(Optional<String> type) {
        this.type = type;
    }

    public Optional<Integer> getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Optional<Integer> minPrice) {
        this.minPrice = minPrice;
    }

    public Optional<Integer> getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Optional<Integer> maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Optional<String> getCity() {
        return city;
    }

    public void setCity(Optional<String> city) {
        this.city = city;
    }

    public Optional<String> getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(Optional<String> propertyName) {
        this.propertyName = propertyName;
    }

    public Optional<String> getPropertyColor() {
        return propertyColor;
    }

    public void setPropertyColor(Optional<String> propertyColor) {
        this.propertyColor = propertyColor;
    }

    public Optional<Integer> getPropertyLimitMin() {
        return propertyLimitMin;
    }

    public void setPropertyLimitMin(Optional<Integer> propertyLimitMin) {
        this.propertyLimitMin = propertyLimitMin;
    }

    public Optional<Integer> getPropertyLimitMax() {
        return propertyLimitMax;
    }

    public void setPropertyLimitMax(Optional<Integer> propertyLimitMax) {
        this.propertyLimitMax = propertyLimitMax;
    }

    @Override
    public String toString() {
        return "QueryObject{" +
                "type=" + type +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", city=" + city +
                ", propertyName=" + propertyName +
                ", propertyColor=" + propertyColor +
                ", propertyLimitMin=" + propertyLimitMin +
                ", propertyLimitMax=" + propertyLimitMax +
                '}';
    }
}
