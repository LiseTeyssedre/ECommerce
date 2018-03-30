package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.CategorieDaoImpl;
import fr.adaming.dao.ICategorieDao;
import fr.adaming.model.Administrateur;
import fr.adaming.model.Categorie;


@Stateful
public class CategorieServiceImpl implements ICategorieService {

	//transformation de l'association UML en java
	@EJB
	private ICategorieDao categorieDao;
	
	
	@Override
	public List<Categorie> getListCategorie() {
		
		return categorieDao.getListCategorie();
	}

	@Override
	public Categorie addCategorie(Categorie cat) {
		
		return categorieDao.addCategorie(cat);
	}

	@Override
	public Categorie searchCategorie(Categorie cat) {
		
		return categorieDao.searchCategorie(cat);
	}

	@Override
	public int updateCategorie(Categorie cat) {
		
		return categorieDao.updateCategorie(cat);
	}

	@Override
	public int deleteCategorie(Categorie cat) {
		
		return categorieDao.deleteCategorie(cat);
	}



}
