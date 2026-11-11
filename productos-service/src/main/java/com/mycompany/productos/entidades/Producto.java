package com.mycompany.productos.entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;


 //guardado en la base de datos, el id lo genera la BD
 @Entity
public class Producto extends PanacheEntity {

    public String name;
    public double price;

    public Producto() {
    }
// ops aqui el producto
    public Producto(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
