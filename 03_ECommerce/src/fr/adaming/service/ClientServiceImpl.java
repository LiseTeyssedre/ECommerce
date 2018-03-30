package fr.adaming.service;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@Stateful
public class ClientServiceImpl implements IClientService {

	//transformation de l'association UML en java
	@EJB
	private IClientDao clientDao;
	
	@Override
	public Client isExist(Client cl) {
		
		return clientDao.isExist(cl);
	}

}
