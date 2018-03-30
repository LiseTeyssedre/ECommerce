package fr.adaming.managedBean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@ManagedBean(name="clMB")
@RequestScoped
public class ClientManagedBean implements Serializable {
	
	//transformation de l'association UML en java
	@EJB
	private IClientService clientService;
	
	// les attributs 
	private Client client;


	//le constructeur vide
	public ClientManagedBean() {
		this.client = new Client();
	}

	//getters et setters
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	//methode metier
	public String seConnecter(){
		Client clOut =clientService.isExist(this.client);
		
		if(clOut!=null) {
			//définir le client comme attribut de la session
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clientSession", clOut);
			
			return "succes";
		}else{
			return "echec";
		}
		
	}
	

}
