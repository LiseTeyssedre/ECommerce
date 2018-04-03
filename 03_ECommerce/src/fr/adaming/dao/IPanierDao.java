package fr.adaming.dao;

import javax.ejb.Local;

import fr.adaming.model.Panier;
import fr.adaming.model.Produit;

@Local
public interface IPanierDao {

	public Panier addproduit(Produit pr);
	
	public Panier deleteproduit (Produit pr);
	
	
}
