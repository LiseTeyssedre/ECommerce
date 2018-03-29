package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import fr.adaming.model.Administrateur;
import fr.adaming.model.Produit;
import fr.adaming.service.IAdminService;
import fr.adaming.service.IProduitService;

@ManagedBean
@RequestScoped
public class AdminManagedBean implements Serializable {
	
	// Transformation de l'association UML en Java
	@EJB
	private IAdminService adminService;
	@EJB
	private IProduitService prodService;
	private Administrateur admin;
	private List<Produit> listeProduits;

	
	
	
	
	public AdminManagedBean() {
		this.setAdmin(new Administrateur());;
	}


	public AdminManagedBean(IAdminService adminService) {
		super();
		this.adminService = adminService;
	}


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


	public Administrateur getAdmin() {
		return admin;
	}


	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}
	
	
	

}
