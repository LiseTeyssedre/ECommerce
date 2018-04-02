package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.AssertTrue;

import fr.adaming.model.Administrateur;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@ManagedBean(name = "prMB")
@RequestScoped
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
	@AssertTrue
	private boolean selectionne;
	private List<Categorie> listeCategorie;
	private List<Produit> listeProduit;
	private boolean indice;
	private Categorie cat;

	public ProduitManagedBean() {
		this.produit = new Produit();
		this.produit.setCategorie(new Categorie());
	}

	// R�cup�ration de la session existante
	@PostConstruct // Pour que la m�thode s'ex�cute juste apr�s l'instanciation
					// du managed bean
	public void init() {
		this.listeCategorie = catService.getListCategorie();
		this.setListeProduit(prodService.getAllProduit());
		this.indice=false;
		// R�cup�rer la session
		this.maSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		// R�cup�rer l'admin stock� dans la session
		this.admin = (Administrateur) this.maSession.getAttribute("adminSession");
		
		

	}

	// D�claration des getters et des setters

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
	
	

	public boolean isSelectionne() {
		return selectionne;
	}

	public void setSelectionne(boolean selectionne) {
		this.selectionne = selectionne;
	}



	

	 


	public List<Categorie> getListeCategorie() {
		return listeCategorie;
	}

	public void setListeCategorie(List<Categorie> listeCategorie) {
		this.listeCategorie = listeCategorie;
	}

	public List<Produit> getListeProduit() {
		return listeProduit;
	}

	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}
	
	
	 // D�veloppement de la m�thode Modifier un Produit
	 public String updateProduit() {
	 int verif = prodService.updateProduit(this.produit, this.admin);
	 if (verif != 0) {
	 // R�cup�rer la nouvelle liste
	 List<Produit> liste2 = prodService.getAllProduit();
	 // Mettre � jour la liste dans la session
	 maSession.setAttribute("produitsListe", liste2);
	 return "accueil";
	 } else {
	 return "modif";
	 }
	 //
	 }
	 
	 // D�veloppement de la m�thode Supprimer un Produit
	 public String deleteProduit() {
	 int verif = prodService.deleteProduit(this.produit);
	 if (verif != 0) {
	 // R�cup�rer la nouvelle liste
	 List<Produit> liste1 = prodService.getAllProduit();
	 // Mettre � jour la liste dans la session
	 maSession.setAttribute("produitsListe", liste1);
	 return "accueil";
	 } else {
	 return "accueil";
	 }
	
	 }
	
	 
	 // D�veloppement de la m�thode GetListeProduit
	 public String getAllProduit(){
		 List<Produit> listeProduits=prodService.getAllProduit();
		 //Mettre � jour la liste dans la session
		 maSession.setAttribute("Listeproduits", listeProduits);
		 System.out.println("======================================");
		 return "accueil";
	 }
	 
	 
		// D�veloppement de la m�thode Ajouter un Produit
		public String ajouterProduit() {
			//System.out.println("--------------------- id de la cat " + this.produit.getCategorie().getIdCategorie());
			Produit prodAjout = prodService.addProduit(this.produit);
			return "accueilAdmin";
			// if (prodAjout.getIdProduit() != 0) {
			// // R�cup�rer la nouvelle liste de produits
			// List<Produit> liste = prodService.getAllProduit();
			// // Mettre � jour la liste dans la session
			// maSession.setAttribute("produitsListe", liste);
			// return "accueil";
			// } else {
			// return "accueil";
			// }
		}

		
		// Red�finition de la m�thode GetProduitById
		public String getProduitByIdCategorie(){
			try {
				List<Produit> listeProdRech=prodService.getProduitByIdCat(cat);
				this.indice=true;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("voici la liste des produits correspondant � cette cat�gorie :"+listeProdRech));
				System.out.println(produit);
				
			} catch (Exception ex) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aucun produit ne correspond � cette id"));
			}
		
			return "accueil";
//			
//			public String searchClient() throws NoResultException{
//				try{
//					this.client=clientService.searchClient(this.client, this.agent);
//			
//						this.indice=true;
//				
//					} catch(Exception ex){
//						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Mais il est o� ? PAS LA ! IL EST PAS LA "));
//						this.indice=false;
//						
//					}
//			
//					return "find";
//				}
			
			
			
			
			
			
			
		}

		public boolean isIndice() {
			return indice;
		}

		public void setIndice(boolean indice) {
			this.indice = indice;
		}

		public Categorie getCat() {
			return cat;
		}

		public void setCat(Categorie cat) {
			this.cat = cat;
		}
	 
}
