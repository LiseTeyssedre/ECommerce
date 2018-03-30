package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Administrateur;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;

public class ProduitDaoImpl implements IProduitDao {

	// Pour injecter l'entity manager
	@PersistenceContext(unitName = "PU")
	private EntityManager em;

	// ==============================================================================
	// ==============================================================================
	// ==============================================================================

	@Override
	public List<Produit> getAllProduit() {
		// La requ�te JPQL
		String req = "SELECT p FROM Produit as p";

		// Cr�ation du query
		Query query = em.createQuery(req);

		return query.getResultList();
	}

	// ==============================================================================
	// ==============================================================================
	// ==============================================================================

	// Red�finition de la m�thode deleteProduit
	@Override
	public int deleteProduit(Produit produit) {
		// Cr�ation de la requ�te
		String req = "DELETE pr FROM Produit as pr WHERE pr.idProduit=:pIdProd AND pr.admin.idAdm=:pIdAdm";

		// Cr�ation du Query
		Query query = em.createQuery(req);

		// Passage des param�tres
		query.setParameter("pIdProd", produit.getIdProduit());
		query.setParameter("pIdAdm", produit.getAdmin().getIdAdm());

		// Envoi de la requ�te et r�cup�ration du r�sultat
		int verif = query.executeUpdate();
		return verif;

	}

	// ==============================================================================
	// ==============================================================================
	// ==============================================================================

	@Override
	public List<Produit> getBySelection(Client cl) {
		// TODO Auto-generated method stub
		return null;
	}

	// ==============================================================================
	// ==============================================================================
	// ==============================================================================

	@Override
	public int addProduitPanier(Client cl) {
		// TODO Auto-generated method stub
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
		// Cr�ation de la requ�te
		em.persist(produit);
		return produit;

	}

	// ==============================================================================
	// ==============================================================================
	// ==============================================================================

	@Override
	public int updateProduit(Produit produit) {
		// Cr�ation de la requ�te
		String req = "UPDATE Produit pr WHERE pr.idProduit=:pIdProd, pr.designation=:pDesign,"
				+ " pr.description=:pDescr, pr.prix=:pPrix, pr.quantite=:pQuant,"
				+ " pr.photo=:pPhoto AND pr.admin.idAdm=:pIdAdm";
		
		// Cr�ation du Query
		Query query=em.createQuery(req);
		
		// Passage des param�tres 
		query.setParameter("pIdProd", produit.getIdProduit());
		query.setParameter("pDesign", produit.getDesignation());
		query.setParameter("pDescr", produit.getDescription());
		query.setParameter("pPrix", produit.getPrix());
		query.setParameter("pQuant", produit.getQuantite());
		query.setParameter("pPhoto", produit.getPhoto());
		query.setParameter("pIdAdm", produit.getAdmin().getIdAdm());
		
		
		// Envoi de la requ�te et r�cup�ration du r�sultat 
		return query.executeUpdate();

	}

	// ==============================================================================
	// ==============================================================================
	// ==============================================================================

}
