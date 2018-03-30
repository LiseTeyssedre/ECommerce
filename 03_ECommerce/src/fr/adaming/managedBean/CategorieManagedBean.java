package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.jboss.resteasy.plugins.delegates.NewCookieHeaderDelegate;

import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.service.ICategorieService;

@ManagedBean(name = "catMB")
@RequestScoped
public class CategorieManagedBean implements Serializable {

	// transformation de l'association UML en Java
	@EJB
	private ICategorieService categorieService;

	// attributs
	private Categorie categorie;
	private List<Categorie> listeCategorie;


	// constructeur
	public CategorieManagedBean() {
		this.categorie = new Categorie();
	}

	@PostConstruct
	public void init() {
	
	}

	// getters et setters
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Categorie> getListeCategorie() {
		return listeCategorie;
	}

	public void setListeCategorie(List<Categorie> listeCategorie) {
		this.listeCategorie = listeCategorie;
	}

	// méthodes métier
	public String afficheCategorie() {
		this.listeCategorie = categorieService.getListCategorie();
		for (Categorie c : listeCategorie) {
			System.out.println(c);
		}
		return "categorie.xhtml";
	}


	public String ajouteCategorie() {
		Categorie cat = categorieService.addCategorie(this.categorie);

		if (cat.getIdCategorie() != 0) {
			// récupérer la nouvelle liste
			List<Categorie> listeCategorie = categorieService.getListCategorie();

			return "categorie.xhtml";
		} else {

			// le message en cas d'echec
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ajout impossible"));
			return "ajout.xhtml";
		}

	}

}
