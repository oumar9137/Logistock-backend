package com.logistock.logistock_backend.entity;
import jakarta.persistence.*;
@Entity @Table(name="ROLE")
public class Role {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_role") private Integer id;
    @Column(name="libelle_role") private String libelle;
    private String description;
    public Integer getId(){return id;} public void setId(Integer id){this.id=id;}
    public String getLibelle(){return libelle;} public void setLibelle(String l){this.libelle=l;}
    public String getDescription(){return description;} public void setDescription(String d){this.description=d;}
}
