package fr.adaming.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Client;

@Stateless
public class ClientDaoImpl implements IClientDao {

	//injection de l'EM
	@PersistenceContext(unitName="PU")
	private EntityManager em;
	
	
	@Override
	public Client isExist(Client cl) {
		//La requete JPQL
		String req="SELECT cl FROM Client as cl WHERE cl.email=:pMail AND cl.mdp=:pMdp";
		
		//Creer un objet de type Query pour envoyer la requete
		Query query=em.createQuery(req);
		
		//Passage des param�tres
		query.setParameter("pMail", cl.getEmail());
		query.setParameter("pMdp", cl.getMdp());
		
		//Envoyer la requete et r�cup�rer le client
		return (Client) query.getSingleResult();
	}

}
