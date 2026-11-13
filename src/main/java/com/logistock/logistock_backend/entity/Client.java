package com.logistock.logistock_backend.entity;
import jakarta.persistence.*;

@Entity @Table(name="client")
public class Client {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_client") private Integer id;
    @Column(name="nom_raison_sociale") private String nom;
    private String telephone;
    private String email;
    private String adresse;

    public Integer getId(){return id;} public void setId(Integer id){this.id=id;}
    public String getNom(){return nom;} public void setNom(String n){this.nom=n;}
    public String getTelephone(){return telephone;} public void setTelephone(String t){this.telephone=t;}
    public String getEmail(){return email;} public void setEmail(String e){this.email=e;}
    public String getAdresse(){return adresse;} public void setAdresse(String a){this.adresse=a;}
}