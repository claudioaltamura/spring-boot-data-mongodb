package de.claudioaltamura.spring.boot.data.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "product_materials")
public class ProductMaterial {

    @Id
    private String id;

    private String materialNumber;

    private String name;

    private String description;

    private BigDecimal price;

    public ProductMaterial() {
    }

    public ProductMaterial(String materialNumber, String name, String description, BigDecimal price) {
        this.materialNumber = materialNumber;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getMaterialNumber() {
        return materialNumber;
    }

    public void setMaterialNumber(String materialNumber) {
        this.materialNumber = materialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductMaterial{" +
                "id='" + id + '\'' +
                ", materialNumber='" + materialNumber + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}