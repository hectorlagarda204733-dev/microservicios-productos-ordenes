package com.mycompany.productos.entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

/**
 * Producto guardado en la base de datos, el id lo genera la BD
 */
@Entity
public class Producto extends PanacheEntity {

    public String name;
    public double price;

    public Producto() {
    }

    public Producto(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
