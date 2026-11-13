package com.logistock.logistock_backend.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity @Table(name="vente")
public class Vente {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_vente") private Integer id;
    @Column(name="numero_vente") private String numero;
    @ManyToOne @JoinColumn(name="id_client") private Client client;
    @ManyToOne @JoinColumn(name="id_utilisateur") private Utilisateur utilisateur;
    @ManyToOne @JoinColumn(name="id_produit") private Produit produit;
    @Column(name="quantite") private Integer quantite;
    @Column(name="montant_total") private BigDecimal montantTotal;
    @Column(name="date_vente") private LocalDateTime dateVente;

    public Integer getId(){return id;} public void setId(Integer id){this.id=id;}
    public String getNumero(){return numero;} public void setNumero(String n){this.numero=n;}
    public Client getClient(){return client;} public void setClient(Client c){this.client=c;}
    public Utilisateur getUtilisateur(){return utilisateur;} public void setUtilisateur(Utilisateur u){this.utilisateur=u;}
    public Produit getProduit(){return produit;} public void setProduit(Produit p){this.produit=p;}
    public Integer getQuantite(){return quantite;} public void setQuantite(Integer q){this.quantite=q;}
    public BigDecimal getMontantTotal(){return montantTotal;} public void setMontantTotal(BigDecimal m){this.montantTotal=m;}
    public LocalDateTime getDateVente(){return dateVente;} public void setDateVente(LocalDateTime d){this.dateVente=d;}
}