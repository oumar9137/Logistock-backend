package com.logistock.logistock_backend.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name="UTILISATEUR")
public class Utilisateur {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_utilisateur") private Integer id;
    private String nom;
    private String email;
    @Column(name="mot_de_passe") private String motDePasse;
    @Column(name="date_creation") private LocalDateTime dateCreation;
    @ManyToOne @JoinColumn(name="id_role") private Role role;
    public Integer getId(){return id;} public void setId(Integer id){this.id=id;}
    public String getNom(){return nom;} public void setNom(String n){this.nom=n;}
    public String getEmail(){return email;} public void setEmail(String e){this.email=e;}
    public String getMotDePasse(){return motDePasse;} public void setMotDePasse(String m){this.motDePasse=m;}
    public Role getRole(){return role;} public void setRole(Role r){this.role=r;}
    public LocalDateTime getDateCreation(){return dateCreation;} public void setDateCreation(LocalDateTime d){this.dateCreation=d;}
}
