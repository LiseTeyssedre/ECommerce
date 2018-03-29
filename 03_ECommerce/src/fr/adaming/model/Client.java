package fr.adaming.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {
	
	
	// Déclaration des attributs 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cl")
	private Long idClient;
	private String nomClient;
	private String adresse;
	private String email;
	private String tel;
	
	//Transformation de l'association UML en Java
	@OneToMany(mappedBy="client", cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	private List<Commande> listeCommande;
	
	
	// Déclaration des constructeurs 
	
	public Client() {
		super();
	}
	public Client(String nomClient, String adresse, String email, String tel) {
		super();
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}
	public Client(Long idClient, String nomClient, String adresse, String email, String tel) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}
	
	//Déclaration des getters et des setters 
	
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long id) {
		this.idClient = idClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public List<Commande> getListeCommande() {
		return listeCommande;
	}
	public void setListeCommande(List<Commande> listeCommande) {
		this.listeCommande = listeCommande;
	}
	
	
	

}
