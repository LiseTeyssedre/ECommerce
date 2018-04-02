package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;


import fr.adaming.model.Categorie;


@Local
public interface ICategorieDao {
	
	public List<Categorie> getListCategorie ();
	
	public Categorie addCategorie (Categorie cat);
	
	public Categorie searchCategorie (Categorie cat);
	
	public int updateCategorie (Categorie cat);
	
	public int deleteCategorie (Categorie cat);
	
	public List<Categorie> rechercheMotClef (Categorie cat);

}
