package fr.adaming.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import fr.adaming.model.Client;

@Stateless
public class ClientDaoImpl implements IClientDao {

	//injection de l'EM
	@PersistenceUnit(unitName="PU")
	private EntityManager em;
	
	
	@Override
	public Client isExixt(Client cl) {
		//La requete JPQL
		String req="SELECT cl FROM Client as cl WHERE cl.mail=:pMail AND cl.mdp=:pMdp";
		
		//Creer un objet de type Query pour envoyer la requete
		Query query=em.createQuery(req);
		
		//Passage des paramètres
		query.setParameter("pMail", cl.getEmail());
		query.setParameter("pMdp", cl.getMdp());
		
		//Envoyer la requete et récupérer le client
		return (Client) query.getSingleResult();
	}

}
