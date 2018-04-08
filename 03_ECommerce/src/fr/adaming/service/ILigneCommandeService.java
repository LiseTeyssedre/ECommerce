package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;

@Local
public interface ILigneCommandeService {

	public List<LigneCommande> getAllLc(); // = le panier

	public LigneCommande addProdToLc(Produit pr, int quantit�);

	public int deleteProdToLc(int id);

}
