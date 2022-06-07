package tn.rnu.isi.service;
 

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import tn.rnu.isi.model.Commande;
import tn.rnu.isi.model.Produit;



 

 
 
public interface CommandeRepository extends CrudRepository <Commande, Long>{
	
 
	Commande findByIdCommande(Long idCommande);
	
	 
	List<Commande> findAll();
	
	Commande save (Commande commande);
	 
	@Modifying
	@Query("update Commande u set u.idCommande = ?1")
	int updateIdCommande(Long idCommande);
	
	@Modifying
	@Query("update Commande u set u.dateCommande = ?1, u.qteCommande = ?2  where u.idCommande = ?3")
	int updateDesigCommande(Date dateCommande, Long qteCommande, Long idCommande);

 	@Modifying
	@Query("delete from Commande u where u.produit.idProduit = :produitId")
	void deleteCommandeByIdProduit(@Param("produitId") Long produit);
 	
  
 	
 	

}