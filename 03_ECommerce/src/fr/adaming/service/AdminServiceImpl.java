package fr.adaming.service;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IAdminDao;
import fr.adaming.model.Administrateur;

@Stateful
public class AdminServiceImpl implements IAdminService{

	
	// Transformation de l'association UML en JAva 
	@EJB
	private IAdminDao adminDao;
	
	@Override
	public Administrateur isExist(Administrateur a) {
		return adminDao.isExist(a);
	}
	

}
