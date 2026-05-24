package com.projekt.gesStock;

import jakarta.persistence.*;

@Entity
@Table(name= "Artikle")
public class Artikle {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)

    private Long id;
    private String name;
    private double preis;
    private double menge;

    public Artikle() {}
    public Artikle(Long id, String name, double preis, double menge){
        this.id=id;
        this.name=name;
        this.preis=preis;
        this.menge=menge;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public double getPreis() {
        return preis;
    }
    public double getMenge() {
        return menge;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }
    public void setMenge(double menge) {
        this.menge = menge;
    }

}
