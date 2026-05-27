package com.projekt.gesStock;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name= "Artikle")
public class Artikle {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)

    private Long id;
    @NotBlank(message = "Der Name darf nicht leer sein")
    private String name;
    @Min(value=0, message= "Der Preis darf nicht negativ sein")
    private double preis;
    @NotNull(message = "Die eingetragene Menge darf nicht null sein")
    @Min(value=1, message = "Die Mindestmenge muss 1 sein")
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
