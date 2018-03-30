package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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
	public CategorieManagedBean(Categorie categorie) {
		super();
		this.categorie = categorie;
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

	// m�thodes m�tier
	public String afficheCategorie() {
		this.listeCategorie = categorieService.getListCategorie();

		return "categorie.xhtml";

	}

	public String ajouteCategorie() {
		Categorie cat = categorieService.addCategorie(this.categorie);

		if (cat.getIdCategorie() != 0) {
			// r�cup�rer la nouvelle liste
			List<Categorie> listeCategorie = categorieService.getListCategorie();

			return "categorie.xhtml";
		} else {

			// le message en cas d'echec
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ajout impossible"));
			return "ajout.xhtml";
		}

	}

}