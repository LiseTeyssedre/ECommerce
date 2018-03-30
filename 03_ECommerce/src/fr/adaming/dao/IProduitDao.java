package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Administrateur;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;

public interface IProduitDao {
	
	public Produit addProduit(Produit produit); // OK
	public int deleteProduit(Produit produit); // OK
	public int updateProduit(Produit produit); // OK
	public List<Produit> getAllProduit(); // OK 
	public List<Produit> getBySelection(Client cl);
	public int addProduitPanier(Client cl);
	public int deleteProduitPanier(Client cl);
	
	
}
