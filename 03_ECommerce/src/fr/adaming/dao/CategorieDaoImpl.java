package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Administrateur;
import fr.adaming.model.Categorie;
import fr.adaming.model.Client;

@Stateless
public class CategorieDaoImpl implements ICategorieDao {

	@PersistenceContext(unitName = "PU") // pour injecter l'EM
	private EntityManager em;

	@Override
	public List<Categorie> getListCategorie() {
		// la requete jpql
		String req = "SELECT cat FROM Categorie as cat";

		// creation d'un query pour envoyer la requete
		Query query = em.createQuery(req);

		// envoyer la requete et récupérer le résultat
		return query.getResultList();

	}

	@Override
	public Categorie addCategorie(Categorie cat) {
		em.persist(cat);
		return cat;
	}

	@Override
	public Categorie searchCategorie(Categorie cat) {

		return null;
	}

	@Override
	public int updateCategorie(Categorie cat) {
		String req2 = "UPDATE Categorie cat SET cat.nomCategorie=:pNom, cat.photo=:pPhoto, cat.description=:pDescription";

		Query query = em.createQuery(req2);

		// passage des paramètres
		query.setParameter("pNom", cat.getNomCategorie());
		query.setParameter("pPhoto", cat.getPhoto());
		query.setParameter("pDescription", cat.getDescription());

		// envoyer la requete
		return query.executeUpdate();
	}

	@Override
	public int deleteCategorie(Categorie cat) {
		String req3="DELETE FROM Categorie cat";
		
		// CréationduQuery
		Query query2=em.createQuery(req3);
	
		//envoi de la requet
		return query2.executeUpdate();

	}

}