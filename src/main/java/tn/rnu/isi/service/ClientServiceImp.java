package tn.rnu.isi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.rnu.isi.model.Client;


@Service
@Transactional
public class ClientServiceImp implements ClientService{


		@Autowired
		private ClientRepository clientRepository;

	  
		
		 
		@Override
		public  Client getByIdClient(Long idClient) throws Exception {
	        return  (Client) clientRepository.findByIdClient(idClient);

		}

	 
		@Override
		public Long save(Client client) throws Exception {
			
			client = clientRepository.save(client);
			return client.getIdClient();
		}




		 


		@Override
		public int updateId(Long idClient) {
			return clientRepository.updateIdClient(idClient);
		}


		@Override
		public int updateClient(String loginClient, String motPasseClient,String nomClient,String prenomClient,String civiliteClient,String dateNaissanceClient,String rueAdrClient,String communeAdrClient,String villeAdrClient,String cpAdrClient,String telClient, String faxClient,String gsmClient,String emailClient, Long idClient) {
			return clientRepository.updateClient(loginClient,motPasseClient,nomClient,prenomClient,civiliteClient,dateNaissanceClient,rueAdrClient,communeAdrClient,villeAdrClient,cpAdrClient,telClient,faxClient,gsmClient,emailClient,idClient) ;

		}




		@Override
		public List<Client> getAll() {
	 		return (List<Client>) clientRepository.findAll() ;
		}


		@Override
		public void deleteClient(Long idClient) {
			clientRepository.delete(idClient) ;
			
		}   
	}



