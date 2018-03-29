package fr.adaming.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Administrateur;

public class AdminDaoImpl implements IAdminDao {
	
	
	// Pour injecter l'entity manager
	@PersistenceContext(unitName="PU") // Injection d�pendance : il va stocker des valeurs dans lse attributs de la classe 
	private EntityManager em;

	@Override
	public Administrateur isExist(Administrateur a) {
		// La requ�te JPQL 
		String req="SELECT adm FROM Administrateur as adm WHERE adm.mail=:pMail AND adm.mdp=:pMdp";
		
		// Cr�er un objet de type Query pour envoyer la requ�te
		Query query=em.createQuery(req);
		
		// Passage des param�tres
		query.setParameter("pMail", a.getMail());
		query.setParameter("pMdp", a.getMdp());
		return null;
	}

}
