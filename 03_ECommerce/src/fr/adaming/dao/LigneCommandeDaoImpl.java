package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;

@Stateless
public class LigneCommandeDaoImpl implements ILigneCommande{

	@PersistenceContext(unitName = "PU") // pour injecter l'EM
	private EntityManager em;

	@Override
	public List<LigneCommande> getAllLc() {
		
		//la requete SQL
		String req="SELECT lc FROM LigneCommande lc";
		
		//creation d'un query pour envoyer la requete
		Query query = em.createQuery(req);
		List<LigneCommande> listLignCom=query.getResultList();
		
		//envoyer la requete et récupérer la liste
		
		return listLignCom;
	}

	@Override
	public LigneCommande addProdToLc(Produit pr, int quantité) {
		
		LigneCommande ligneComm= new LigneCommande();
		em.persist(ligneComm);
		
		
		return ligneComm;
	}

	@Override
	public int deleteProdToLc(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
