package tn.rnu.isi.service;

import java.util.List;
import tn.rnu.isi.model.Client;

public interface ClientService {

	public Long save (Client client) throws Exception ;
	
	List<Client> getAll();
 
	Client getByIdClient(Long idClient) throws Exception;
	
	int updateId (Long idClient);
	
	int updateClient (String loginClient, String motPasseClient,String nomClient,String prenomClient,String civiliteClient,String dateNaissanceClient,String rueAdrClient,String communeAdrClient,String villeAdrClient,String cpAdrClient,String telClient, String faxClient,String gsmClient,String emailClient, Long idClient);
	
  	void deleteClient(Long idClient);
  	
   
}
