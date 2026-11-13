package com.logistock.logistock_backend.entity;
import jakarta.persistence.*;
@Entity @Table(name="CATEGORIE")
public class Categorie {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_categorie") private Integer id;
    @Column(name="nom_categorie") private String nom;
    private String description;
    public Integer getId(){return id;} public void setId(Integer id){this.id=id;}
    public String getNom(){return nom;} public void setNom(String n){this.nom=n;}
    public String getDescription(){return description;} public void setDescription(String d){this.description=d;}
}
