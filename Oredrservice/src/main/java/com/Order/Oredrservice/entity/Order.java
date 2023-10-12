package com.Order.Oredrservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order")
public class Order {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "Oid")
    private int Oid;

   @Column(name = "Name")
    private String Name;

    public int getOid() {
        return Oid;
    }

    public void setOid(int oid) {
        Oid = oid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
