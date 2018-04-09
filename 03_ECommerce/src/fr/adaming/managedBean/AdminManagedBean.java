package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.Administrateur;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.IAdminService;
import fr.adaming.service.IProduitService;

@ManagedBean(name="aMB")
@RequestScoped
public class AdminManagedBean implements Serializable {

	
	// Transformation de l'association UML en Java
	@EJB
	private IAdminService adminService;
	@EJB
	private IProduitService prodService;

	// attributs
	private Administrateur admin;
	private List<Produit> listeProduits;
	private List<Categorie> listeCategories;

	// constructeur vide
	public AdminManagedBean() {
		this.admin = new Administrateur();
	}

	// getter et setter
	public IAdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

	public IProduitService getProdService() {
		return prodService;
	}

	public void setProdService(IProduitService prodService) {
		this.prodService = prodService;
	}

	public List<Produit> getListeProduits() {
		return listeProduits;
	}

	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}

	public List<Categorie> getListeCategories() {
		return listeCategories;
	}

	public void setListeCategories(List<Categorie> listeCategories) {
		this.listeCategories = listeCategories;
	}

	public Administrateur getAdmin() {
		return admin;
	}

	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}

	// methode métier
	public String seConnecter() {
		Administrateur aOut = adminService.isExist(this.admin);

		if (aOut != null) {
			// définir l'administrateur comme attribut de la session
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("adminSession", aOut);

			// avoir la liste des categories dans la session
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("categorieList",
					this.listeCategories);

			// avoir la liste des produits dans la session
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("produitList",
					this.listeProduits);
			
			return "succes";
			
			
		
		} else {
			return "echec";
		}
	}

}
