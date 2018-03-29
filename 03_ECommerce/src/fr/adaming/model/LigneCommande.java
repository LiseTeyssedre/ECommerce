package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ComProdAssoc")
public class LigneCommande {

	//Déclaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_lc")
	private int id;
	private int quantite;
	private double prix;
	
	//Transformation de l'association UML en Java
	@ManyToOne
	@JoinColumn(name="co_id",referencedColumnName="id_co") 
	private Commande commande;
	@ManyToOne
	@JoinColumn(name="p_id", referencedColumnName="id_p")
	private Produit produit;
	
	
	// Déclaration des constructeurs
	public LigneCommande() {
		super();
	}
	public LigneCommande(int quantite, double prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;
	}
	
	
	public LigneCommande(int quantite, double prix, Commande commande, Produit produit) {
		super();
		this.quantite = quantite;
		this.prix = prix;
		this.commande = commande;
		this.produit = produit;
	}
	public LigneCommande(int id, int quantite, double prix, Commande commande, Produit produit) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.prix = prix;
		this.commande = commande;
		this.produit = produit;
	}
	//Déclaration des getters et des setters 
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	
	
	
}
