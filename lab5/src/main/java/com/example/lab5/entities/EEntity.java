package com.example.lab5.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "entitys")
public class EEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String img;
    private int price;

    public EEntity(int id, String name, String img, int price) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
    }

    public EEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", price=" + price +
                '}';
    }
}
