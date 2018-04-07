package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;

@Local
public interface ILigneCommande {
	
	
	public List<LigneCommande> getAllLc(); // = le panier 
	
	public LigneCommande addProdToLc(Produit pr, int quantité);
	
	public int deleteProdToLc(int id);
	
}
