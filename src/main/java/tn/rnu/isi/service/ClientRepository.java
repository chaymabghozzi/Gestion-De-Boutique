package tn.rnu.isi.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import tn.rnu.isi.model.Client;

public interface ClientRepository extends CrudRepository <Client, Long>{
		
	 
		Client findByIdClient(Long idClient);
		
		 
		List<Client> findAll();
		
		Client save (Client client);
		 
		@Modifying
		@Query("update Client u set u.idClient = ?1")
		int updateIdClient(Long idClient);
		
		@Modifying
		@Query("update Client u set u.loginClient = ?1, u.motPasseClient = ?2, u.nomClient = ?3, u.prenomClient = ?4, u.civiliteClient = ?5, u.dateNaissanceClient = ?6, u.rueAdrClient = ?7, u.communeAdrClient = ?8, u.villeAdrClient = ?9, u.cpAdrClient = ?10, u.telClient = ?11, u.faxClient = ?12, u.gsmClient = ?13, u.emailClient = ?14  where u.idClient = ?15")
		int updateClient(String loginClient, String motPasseClient,String nomClient,String prenomClient,String civiliteClient,String dateNaissanceClient,String rueAdrClient,String communeAdrClient,String villeAdrClient,String cpAdrClient,String telClient, String faxClient,String gsmClient,String emailClient, Long idClient);

	 	@Transactional
	 	@Modifying
		@Query("delete from Client u where u.idClient = ?1")
		void delete(Long idClient);
	  
	 	

	}

