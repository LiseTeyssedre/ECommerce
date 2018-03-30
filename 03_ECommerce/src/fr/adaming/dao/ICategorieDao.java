package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Administrateur;
import fr.adaming.model.Categorie;
import fr.adaming.model.Client;

@Local
public interface ICategorieDao {
	
	public List<Categorie> getListCategorie ();
	
	public Categorie addCategorie (Categorie cat);
	
	public Categorie searchCategorie (Categorie cat);
	
	public int updateCategorie (Categorie cat);
	
	public int deleteCategorie (Categorie cat);
}
