package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.ILigneCommande;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;

@Stateful
public class LigneCommandeServiceImpl implements ILigneCommandeService{
	
	//transformation de l'assocation UML en java
	@EJB
	private ILigneCommande ligneDao;

	@Override
	public List<LigneCommande> getAllLc() {
		
		return ligneDao.getAllLc();
	}

	@Override
	public LigneCommande addProdToLc(Produit pr, int quantité) {
		
		return ligneDao.addProdToLc(pr, quantité);
	}

	@Override
	public int deleteProdToLc(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
