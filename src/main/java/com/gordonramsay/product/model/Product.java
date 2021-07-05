package com.gordonramsay.product.model;

import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Product {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID barcode;

    private String name;

    private Double mobileSalesPrice;
    private Double salesPrice;

    public Product() {

    }

    public Product(String name, Double mobileSalesPrice, Double salesPrice) {
        this.name = name;
        this.mobileSalesPrice = mobileSalesPrice;
        this.salesPrice = salesPrice;
    }

    public Product(String name, Double salesPrice) {
        this(name, salesPrice, salesPrice);
    }

    public UUID getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMobileSalesPrice() {
        return mobileSalesPrice;
    }

    public void setMobileSalesPrice(Double mobileSalesPrice) {
        this.mobileSalesPrice = mobileSalesPrice;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Double salesPrice) {
        this.salesPrice = salesPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "barcode=" + barcode +
                ", name='" + name + '\'' +
                ", mobileSalesPrice=" + mobileSalesPrice +
                ", salesPrice=" + salesPrice +
                '}';
    }
}
