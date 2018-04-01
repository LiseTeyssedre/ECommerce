package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;

@Local
public interface IProduitDao {
	
	public Produit addProduit(Produit produit); // OK
	public int deleteProduit(Produit produit); // OK
	public int updateProduit(Produit produit); // OK
	public List<Produit> getAllProduit(); // OK 
	public List<Produit> getProduitByIdCategorie(Categorie cat);
	public List<Produit> getBySelection(Client cl);
	public int addProduitPanier(Client cl);
	public int deleteProduitPanier(Client cl);
	
	
}
