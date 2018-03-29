package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;

import fr.adaming.model.Administrateur;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;

public class ProduitServiceImpl implements IProduitService{

	
	// Transformation de l'association UML en JAVA
	@EJB // Injecter le produit Dao
	private IProduitService prodService;
	
	
	@Override
	public List<Produit> getAllProduit() {
		return prodService.getAllProduit();
	}
	
	
	
	//==============================================================================
	//==============================================================================
	//==============================================================================
	
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

}
