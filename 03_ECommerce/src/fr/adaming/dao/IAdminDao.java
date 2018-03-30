package fr.adaming.dao;

import javax.ejb.Local;

import fr.adaming.model.Administrateur;

@Local
public interface IAdminDao {

	public Administrateur isExist(Administrateur a);
}
