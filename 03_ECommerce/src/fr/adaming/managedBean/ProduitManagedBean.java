package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.Table;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Administrateur;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@ManagedBean
@Table(name="produits")
public class ProduitManagedBean implements Serializable {

	// Transformation de l'association UML en Java
	@EJB
	private IProduitService prodService;
	@EJB
	private ICategorieService catService;
	

	// D�claration des attributs envoy�s � la page 
	
	private Produit produit;
	private Administrateur admin;
	HttpSession maSession;
	
	//R�cup�ration de la session existante 
	@PostConstruct // Pour que la m�thode s'ex�cute juste apr�s l'instanciation du managed bean 
	public void init(){
		//R�cup�rer la session
		this.maSession=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		//R�cup�rer l'admin stock� dans la session 
		this.admin=(Administrateur) this.maSession.getAttribute("adminSession");
		
	}
	
	
	public ProduitManagedBean() {
		super();
	}


	public ProduitManagedBean(Produit produit, Administrateur admin) {
		super();
		this.produit = produit;
		this.admin = admin;
	}

	//D�claration des getters et des setters 

	public Produit getProduit() {
		return produit;
	}


	public void setProduit(Produit produit) {
		this.produit = produit;
	}


	public Administrateur getAdmin() {
		return admin;
	}


	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}
	
	
	public IProduitService getProdService() {
		return prodService;
	}


	public void setProdService(IProduitService prodService) {
		this.prodService = prodService;
	}


	public ICategorieService getCatService() {
		return catService;
	}


	public void setCatService(ICategorieService catService) {
		this.catService = catService;
	}


	public HttpSession getMaSession() {
		return maSession;
	}


	public void setMaSession(HttpSession maSession) {
		this.maSession = maSession;
	}


	// D�veloppement de la m�thode Ajouter un Produit 
	public String ajouterProduit(){
		Produit prodAjout=prodService.addProduit(this.produit, this.admin);
		if(prodAjout.getIdProduit()!=0){
			// R�cup�rer la nouvelle liste de produits 
			List<Produit> liste=prodService.getAllProduit();
			// Mettre � jour la liste dans la session
			maSession.setAttribute("produitsListe", liste);
			return "accueil";
		} else {
			return "accueil";
		}
	}
	
	
	
	//D�veloppement de la m�thode Supprimer un Produit 
	public String deleteProduit(){
		int verif=prodService.deleteProduit(this.produit, this.admin);
		
		if (verif!=0) {
			// R�cup�rer la nouvelle liste 
			List<Produit> liste1=prodService.getAllProduit();
			// Mettre � jour la liste dans la session
			maSession.setAttribute("produitsListe",liste1);
			return "accueil";
		} else {
			return "accueil";
		}
	
	}
	
	// D�veloppement de la m�thode Modifier un Produit 
	public String updateProduit(){
		int verif=prodService.updateProduit(this.produit, this.admin);
		if(verif!=0){
			// R�cup�rer la nouvelle liste 
			List<Produit> liste2=prodService.getAllProduit();
			// Mettre � jour la liste dans la session
			maSession.setAttribute("produitsListe", liste2);
			return "accueil";
		} else {
			return "modif";
		}
		// 
	}
	
}
