package com.logistock.logistock_backend.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity @Table(name="PRODUIT")
public class Produit {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_produit") private Integer id;
    private String reference;
    private String designation;
    @Column(name="prix_unitaire") private BigDecimal prix;
    @Column(name="quantite_stock") private Integer stock;
    @Column(name="seuil_alerte") private Integer seuil;
    @ManyToOne @JoinColumn(name="id_categorie") private Categorie categorie;
    public Integer getId(){return id;} public void setId(Integer id){this.id=id;}
    public String getReference(){return reference;} public void setReference(String r){this.reference=r;}
    public String getDesignation(){return designation;} public void setDesignation(String d){this.designation=d;}
    public BigDecimal getPrix(){return prix;} public void setPrix(BigDecimal p){this.prix=p;}
    public Integer getStock(){return stock;} public void setStock(Integer s){this.stock=s;}
    public Integer getSeuil(){return seuil;} public void setSeuil(Integer s){this.seuil=s;}
    public Categorie getCategorie(){return categorie;} public void setCategorie(Categorie c){this.categorie=c;}
}
