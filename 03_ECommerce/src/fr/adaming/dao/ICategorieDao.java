package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Administrateur;
import fr.adaming.model.Categorie;
import fr.adaming.model.Client;

public interface ICategorieDao {
	
	public List<Categorie> getListCategorie (Administrateur a);
	
	public Categorie addCategorie (Administrateur a);
	
	public Categorie searchCategorie ();
	
	public int updateCategorie ();
	
	
	
	public int deleteClient ();
}
