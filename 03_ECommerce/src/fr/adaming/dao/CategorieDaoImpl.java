package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.codec.binary.Base64;

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
		String req = "SELECT cat FROM Categorie cat";

		// creation d'un query pour envoyer la requete
		Query query = em.createQuery(req);
		List<Categorie> listeCat=query.getResultList();
		
		for(Categorie cat : listeCat ) {
			cat.setImage("data:image/png;base64,"+Base64.encodeBase64String(cat.getPhoto()));
		}
		
		// envoyer la requete et récupérer le résultat
		return listeCat;
		
	

	}

	@Override
	public Categorie addCategorie(Categorie cat) {
		
		em.persist(cat);
		return cat;
	}

	@Override
	public Categorie searchCategorie(Categorie cat) {
	
		return em.find(Categorie.class, cat.getIdCategorie());
	}

	
	@Override
	public int updateCategorie(Categorie cat) {
		String req2 = "UPDATE Categorie cat SET cat.nomCategorie=:pNom, cat.photo=:pPhoto, cat.description=:pDescription WHERE cat.idCategorie=:pId";

		Query query = em.createQuery(req2);

		// passage des paramètres
		query.setParameter("pNom", cat.getNomCategorie());
		query.setParameter("pPhoto", cat.getPhoto());
		query.setParameter("pDescription", cat.getDescription());
		query.setParameter("pId", cat.getIdCategorie());

		// envoyer la requete
		return query.executeUpdate();
	}

	@Override
	public int deleteCategorie(Categorie cat) {
		String req3="DELETE FROM Categorie cat WHERE cat.idCategorie=:pId";
		
		// CréationduQuery
		Query query2=em.createQuery(req3);
	
		//passage des paramètres
		query2.setParameter("pId", cat.getIdCategorie());
		
		//envoi de la requet
		return query2.executeUpdate();

	}

	
	@Override
	public List<Categorie> rechercheMotClef(Categorie cat) {
		String req4="SELECT SUBSTRING(description,7,50) FROM Categorie as cat WHERE cat.description=:pDescription";
		
		//creation du query
		Query query3=em.createQuery(req4);
		
		//passage des paramètres 
		query3.setParameter("pDescription", cat.getDescription());
		
		//envoi de la requete
		return query3.getResultList();
	}



}