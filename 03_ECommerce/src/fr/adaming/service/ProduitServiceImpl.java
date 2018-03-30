package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.ICategorieDao;
import fr.adaming.dao.IProduitDao;
import fr.adaming.model.Administrateur;
import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;

@Stateful
public class ProduitServiceImpl implements IProduitService{

	
	// Transformation de l'association UML en JAVA
	@EJB // Injecter le produit Dao
	private IProduitDao prodDao;
	
	@EJB
	ICategorieDao catDao;
	
	
	@Override
	public List<Produit> getAllProduit() {
		
		return prodDao.getAllProduit();
	}
	
	
	
	//==============================================================================
	//==============================================================================
	//==============================================================================
	
	@Override
	public int deleteProduit(Produit produit) {

		return prodDao.updateProduit(produit);
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
	

	@Override
	public Produit addProduit(Produit produit, Administrateur a) {
		System.out.println("--------------------- service");
		// recuperer la cat de la bd 
		Categorie caOut=catDao.searchCategorie(produit.getCategorie());
		
		produit.setAdmin(a);
		produit.setCategorie(caOut);
		return prodDao.addProduit(produit);
	}
	//==============================================================================
	//==============================================================================
	//==============================================================================
	


	@Override
	public int updateProduit(Produit produit, Administrateur a) {
		produit.setAdmin(a);
		return prodDao.updateProduit(produit);
	}

}
