package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Administrateur;
import fr.adaming.model.Categorie;

@Local
public interface ICategorieService {
	
public List<Categorie> getListCategorie ();
	
	public Categorie addCategorie (Categorie cat);
	
	public Categorie searchCategorie (Categorie cat);
	
	public int updateCategorie (Categorie cat);
	
	public int deleteCategorie (Categorie cat);

}
