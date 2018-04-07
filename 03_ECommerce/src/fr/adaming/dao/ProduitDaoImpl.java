package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;

@Stateless
public class ProduitDaoImpl implements IProduitDao {

	// Pour injecter l'entity manager
	@PersistenceContext(unitName = "PU")
	private EntityManager em;

	// ==============================================================================
	// ==============================================================================
	// ==============================================================================

	@Override
	public List<Produit> getAllProduit() {
		// La requête JPQL
		String req = "SELECT p FROM Produit as p";

		// Création du query
		Query query = em.createQuery(req);

		return query.getResultList();
	}

	// ==============================================================================
	// ==============================================================================
	// ==============================================================================

	// Redéfinition de la méthode deleteProduit
	@Override
	public int deleteProduit(Produit produit) {
		
		// Création de la requête
		String req = "DELETE FROM Produit as pr WHERE pr.idProduit=:pIdProd";

		// Création du Query
		Query query = em.createQuery(req);

		// Passage des paramètres
		query.setParameter("pIdProd", produit.getIdProduit());
	
		// Envoi de la requête et récupération du résultat
		
		return query.executeUpdate();

	}

	// ==============================================================================
	// ==============================================================================
	// ==============================================================================

	@Override
	public List<Produit> getBySelection(Client cl) {
		String req2 = "SELECT pr from Produit as pr where p.selected=true";
		Query query2= em.createQuery(req2);
		return query2.getResultList();
		
	}

	// ==============================================================================
	// ==============================================================================
	// ==============================================================================

	@Override
	public int addProduitPanier(Client cl) {
		
		return 0;
	}

	// ==============================================================================
	// ==============================================================================
	// ==============================================================================

	@Override
	public int deleteProduitPanier(Client cl) {
		// TODO Auto-generated method stub
		return 0;
	}

	// ==============================================================================
	// ==============================================================================
	// ==============================================================================

	@Override
	public Produit addProduit(Produit produit) {
		System.out.println("--------------------- dao");
		// Création de la requête
		em.persist(produit);
		return produit;

	}

	// ==============================================================================
	// ==============================================================================
	// ==============================================================================

	@Override
	public int updateProduit(Produit produit) {
		// Création de la requête
		String req = "UPDATE Produit pr SET pr.idProduit=:pIdProd1, pr.designation=:pDesign, pr.description=:pDescr, pr.prix=:pPrix, pr.quantite=:pQuant,pr.photo=:pPhoto WHERE pr.idProduit=:pIdProd";
		
		// Création du Query
		Query query=em.createQuery(req);
		
		// Passage des paramètres 
		query.setParameter("pIdProd1", produit.getIdProduit());
		query.setParameter("pDesign", produit.getDesignation());
		query.setParameter("pDescr", produit.getDescription());
		query.setParameter("pPrix", produit.getPrix());
		query.setParameter("pQuant", produit.getQuantite());
		query.setParameter("pPhoto", produit.getPhoto());
		query.setParameter("pIdProd", produit.getIdProduit());
	
		
		
		// Envoi de la requête et récupération du résultat 
		return query.executeUpdate();

	}

	// ==============================================================================
		// ==============================================================================
		// ==============================================================================

	// Redéfinition de la méthode getProduitById
	@Override
	public List<Produit> getProduitByIdCategorie(Categorie cat) {;
		//Création de la requête 
		String req="SELECT * FROM Produit as pr WHERE pr.categorie.idCategorie=:pIdCat";
		//Création du query
		Query query=em.createQuery(req);
		//Passage des paramètres 
		query.setParameter("pIdCat", cat.getIdCategorie());		
		// Envoi de la requête et récupération du résultat
		return query.getResultList();
	}

	@Override
	public List<Produit> motClef(String mc) {
		
		String req="SELECT pr FROM Produit pr WHERE pr.designation LIKE :x OR pr.description LIKE :x";
		Query query= em.createQuery(req);
		query.setParameter("x", "%"+mc+"%");
		return query.getResultList();
		
	}

	@Override
	public Produit getProduitById(Produit pr) {
		
		return em.find(Produit.class, pr.getIdProduit());
	}

	// ==============================================================================
	// ==============================================================================
	// ==============================================================================

}
