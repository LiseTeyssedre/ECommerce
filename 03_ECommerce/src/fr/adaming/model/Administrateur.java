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
import javax.persistence.Table;

@Entity
@Table(name = "administrateurs")
public class Administrateur {

	// déclaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ad")
	private Long idAdm;
	private String mail;
	private String mdp;

	// association UML en Java
	@OneToMany(mappedBy = "admin", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<Produit> listeProduit;
	@OneToMany(mappedBy = "admin", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<Categorie> listeCategorie;

	// constructeurs
	public Administrateur() {
		super();
	}

	public Administrateur(String mail, String mdp) {
		super();
		this.mail = mail;
		this.mdp = mdp;
	}

	public Administrateur(Long idAdm, String mail, String mdp) {
		super();
		this.idAdm = idAdm;
		this.mail = mail;
		this.mdp = mdp;
	}

	// les getters et les setters
	public Long getIdAdm() {
		return idAdm;
	}

	public void setIdAdm(Long idAdm) {
		this.idAdm = idAdm;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public List<Produit> getListeProduit() {
		return listeProduit;
	}

	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}

	public List<Categorie> getListeCategorie() {
		return listeCategorie;
	}

	public void setListeCategorie(List<Categorie> listeCategorie) {
		this.listeCategorie = listeCategorie;
	}

	// to string
	@Override
	public String toString() {
		return "Administrateur [idAdm=" + idAdm + ", mail=" + mail + ", mdp=" + mdp + "]";
	}

}
