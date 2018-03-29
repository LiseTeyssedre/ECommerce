package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.CategorieDaoImpl;
import fr.adaming.dao.ICategorieDao;
import fr.adaming.model.Categorie;


@Stateful
public class CategorieServiceImpl implements ICategorieService {

	//transformation de l'association UML en java
	@EJB 
	private ICategorieDao categorieDao;
	
	@Override
	public List<Categorie> getAllCategorie() {
		
		return categorieDao.getAllCategorie();
	}

}
