package com.telenor.boutique.entity;

import javax.persistence.*;

@Entity
@Table(name = "subscriptions")
@SequenceGenerator(name="seq_subscriptions", initialValue=1, allocationSize=1)
public class Subscriptions extends AbstractProduct {

    @Id
    @Column(name ="subscription_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_subscriptions")
    private Integer subscriptionId;

    @Column(name = "property_string")
    private String propertyString;

    @Column(name = "gb_limit")
    private Integer gbLimit;

    @Column(name = "price")
    private Integer price;

    @Column(name = "address")
    private String address;

    public Subscriptions() {
    }

    public Subscriptions(String propertyString, Integer gbLimit, Integer price, String address) {
        this.propertyString = propertyString;
        this.gbLimit = gbLimit;
        this.price = price;
        this.address = address;
    }

    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getPropertyString() {
        return propertyString;
    }

    public void setPropertyString(String propertyString) {
        this.propertyString = propertyString;
    }

    public Integer getGbLimit() {
        return gbLimit;
    }

    public void setGbLimit(Integer gbLimit) {
        this.gbLimit = gbLimit;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Subscriptions{" +
                "propertyString='" + propertyString + '\'' +
                ", gbLimit=" + gbLimit +
                ", price=" + price +
                ", address='" + address + '\'' +
                '}';
    }
}
