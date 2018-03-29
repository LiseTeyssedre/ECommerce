package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Administrateur;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;

public interface IProduitDao {
	
	
	public List<Produit> getAllProduit();
	public int deleteProduit(Administrateur a);
	public List<Produit> getBySelection(Client cl);
	public int addProduitPanier(Client cl);
	public int deleteProduitPanier(Client cl);
	
	
}
