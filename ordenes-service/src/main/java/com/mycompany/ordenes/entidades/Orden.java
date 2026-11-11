package com.mycompany.ordenes.entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

/**
 * Orden de compra guardada en la base de datos
 */
@Entity
public class Orden extends PanacheEntity {

    public Long productId;
    public String productName;

    public Orden() {
    }
}
