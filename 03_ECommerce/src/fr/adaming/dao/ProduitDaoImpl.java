package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Administrateur;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;

public class ProduitDaoImpl implements IProduitDao{

	
	// Pour injecter l'entity manager
	@PersistenceContext(unitName = "PU")
	private EntityManager em;
	
	
	//==============================================================================
	//==============================================================================
	//==============================================================================
	
	
	@Override
	public List<Produit> getAllProduit() {
		//La requête JPQL 
		String req="SELECT p FROM Produit as p";
		
		//Création du query
		Query query=em.createQuery(req);

		return query.getResultList();
	}
	
	//==============================================================================
	//==============================================================================
	//==============================================================================
	
	// Redéfinition de la méthode deleteProduit
	@Override
	public int deleteProduit(Administrateur a) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//==============================================================================
	//==============================================================================
	//==============================================================================
	
	@Override
	public List<Produit> getBySelection(Client cl) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//==============================================================================
	//==============================================================================
	//==============================================================================
	
	@Override
	public int addProduitPanier(Client cl) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//==============================================================================
	//==============================================================================
	//==============================================================================
	
	@Override
	public int deleteProduitPanier(Client cl) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	//==============================================================================
	//==============================================================================
	//==============================================================================
	
	
	

}
