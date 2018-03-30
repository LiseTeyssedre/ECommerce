package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Administrateur;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;

@Local
public interface IProduitService {
	
	public int updateProduit(Produit produit, Administrateur a);
	public Produit addProduit(Produit produit,Administrateur a);
	public List<Produit> getAllProduit();
	public int deleteProduit(Produit produit, Administrateur a);
	public List<Produit> getBySelection(Client cl);
	public int addProduitPanier(Client cl);
	public int deleteProduitPanier(Client cl);
}
