package com.telenor.boutique.entity;


import javax.persistence.*;

@Entity
@Table(name = "phones")
@SequenceGenerator(name="seq_phones", initialValue=1, allocationSize=1)
public class Phones extends AbstractProduct {

    @Id
    @Column(name ="phone_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_phones")
    private Integer phoneId;

    @Column(name = "property_string")
    private String propertyString;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private Integer price;

    @Column(name = "address")
    private String address;

    public Phones() {
    }

    public Phones(String propertyString, String color, Integer price, String address) {
        this.propertyString = propertyString;
        this.color = color;
        this.price = price;
        this.address = address;
    }

    public String getPropertyString() {
        return propertyString;
    }

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public void setPropertyString(String propertyString) {
        this.propertyString = propertyString;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        return "Phones{" +
                "propertyString='" + propertyString + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", address='" + address + '\'' +
                '}';
    }
}
