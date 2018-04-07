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

import fr.adaming.model.Administrateur;
import fr.adaming.model.Categorie;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;
import fr.adaming.service.ILigneCommandeService;

@ManagedBean(name = "panMB")
@RequestScoped
public class PanierManageBean implements Serializable {

	// Transformation de l'association UML en java
	@EJB
	private ILigneCommandeService ligneCommService;

	// attributs
	private Produit produit;
	private LigneCommande lc;
	private List<LigneCommande> listLigneComm;
	private HttpSession maSession;
	private Administrateur admin;
	private int qt;

	// constructeur

	public PanierManageBean() {
		this.produit = new Produit();

	}

	@PostConstruct
	public void init() {
		this.listLigneComm = ligneCommService.getAllLc();
		// recupérer la session
		this.maSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		// récupérer l'admin stocké dans la session
		this.admin = (Administrateur) this.maSession.getAttribute("adminSession");
	}

	// getters et setters
	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public LigneCommande getLc() {
		return lc;
	}

	public void setLc(LigneCommande lc) {
		this.lc = lc;
	}

	public List<LigneCommande> getListLigneComm() {
		return listLigneComm;
	}

	public void setListLigneComm(List<LigneCommande> listLigneComm) {
		this.listLigneComm = listLigneComm;
	}
	
	public int getQt() {
		return qt;
	}

	public void setQt(int qt) {
		this.qt = qt;
	}
	
	
	// methodes métiers
	// AFFICHER LE PANIER = Liste des lignes de commande

	public String affichePanier() {
		listLigneComm = ligneCommService.getAllLc();
		// récupérer la nouvelle liste
		List<LigneCommande> listeLignComm = ligneCommService.getAllLc();
		// mettre a jour la liste dans la session
		maSession.setAttribute("lignCommList", listeLignComm);

		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("lcListeSession",
				this.listLigneComm);

		return "panier";
	}

	// AJOUTER UNE LIGNE DE COMMANDE AU PANIER = AJOUTER UN PRODUIT AU PANIER
	public String ajoutLc() {

	//	LigneCommande lignOut = ligneCommService.addProdToLc(produit, qt);

		LigneCommande lignComm = new LigneCommande();
		lignComm.getProduit();
		lignComm.setQuantite(qt);
		
		
		if (lignComm.getId() != 0) {

			// récupérer la nouvelle liste
			List<LigneCommande> listeLignComm = ligneCommService.getAllLc();
			// mettre a jour la liste dans la session
			maSession.setAttribute("lignCommList", listeLignComm);

			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("lcListeSession",
					this.listLigneComm);

			return "panier";
		} else {

			// le message en cas d'echec
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ajout impossible"));
			return "categorie";
		}

	}

}
