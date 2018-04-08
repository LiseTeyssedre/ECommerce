package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.UploadedFile;
import org.primefaces.model.UploadedFileWrapper;

import fr.adaming.model.Administrateur;
import fr.adaming.model.Categorie;
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
	HttpSession maSession;
	private Administrateur admin;
	private UploadedFile uf;

	// constructeur
	public CategorieManagedBean() {
		this.categorie = new Categorie();
		this.uf = new UploadedFileWrapper();
	}

	@PostConstruct
	public void init() {
		this.listeCategorie = categorieService.getListCategorie();
		// recupérer la session
		this.maSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		// récupérer l'admin stocké dans la session
		this.admin = (Administrateur) this.maSession.getAttribute("adminSession");

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

	public UploadedFile getUf() {
		return uf;
	}

	public void setUf(UploadedFile uf) {
		this.uf = uf;
	}

	// méthodes métier

	// AFFICHER LISTE CATEGORIE
	public String afficheCategorie() {
		this.listeCategorie = categorieService.getListCategorie();
		// récupérer la nouvelle liste
		List<Categorie> listeCategorie = categorieService.getListCategorie();
		// mettre a jour la liste dans la session
		maSession.setAttribute("categorieListe", listeCategorie);

		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("catListeSession",
				this.listeCategorie);
		return "categorie";
	}

	// AJOUTER UNE CATEGORIE
	public String ajouteCategorie() {

		this.categorie.setPhoto(this.uf.getContents());
		
		Categorie catAjout = categorieService.addCategorie(this.categorie);
		
		
		if (catAjout.getIdCategorie() != 0) {
			
			// récupérer la nouvelle liste
			List<Categorie> listeCate = categorieService.getListCategorie();
			
			this.listeCategorie = listeCate;

			return "accueilAdmin";
		} else {

			// le message en cas d'echec
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ajout impossible"));
			return "categorie";
		}

	}

	// MODIFIER UNE CATEGORIE
	public String modifCategorie() {
		int verif = categorieService.updateCategorie(this.categorie);

		if (verif != 0) {
			// récupérer la nouvelle liste
			List<Categorie> listeCategorie = categorieService.getListCategorie();
			// mettre a jour la liste dans la session
			maSession.setAttribute("categorieListe", listeCategorie);

			return "ok";

		} else {

			return "stop";
		}

	}

	// SUPPRIMER UNE CATEGORIE
	public String supprimCategorie() {
		int verif = categorieService.deleteCategorie(this.categorie);

		if (verif != 0) {
			// récupérer la nouvelle liste
			List<Categorie> listeCategorie = categorieService.getListCategorie();
			// mettre a jour la liste dans la session
			maSession.setAttribute("categorieListe", listeCategorie);

			return "accueilAdmin";
		} else {
			return "deleteCat";
		}

	}

	// RECHERCHER UNE CATEGORIE
	public String chercheCategorie() {

		Categorie catRec = categorieService.searchCategorie(this.categorie);

		if (catRec != null) {
			this.categorie = catRec;
			return "searchCat";
		} else {
			return "accueilAdmin";
		}

	}

	// RECHERCHER PAR MOTS CLEF
	public String chercheMotClef() {

		List<Categorie> listeRech = categorieService.rechercheMotClef(this.categorie);

		return "motClef";
	}


}
