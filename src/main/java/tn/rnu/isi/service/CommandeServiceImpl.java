package tn.rnu.isi.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.rnu.isi.model.Commande;
import tn.rnu.isi.model.Produit;

@Service
@Transactional
public class CommandeServiceImpl implements CommandeService{

	@Autowired
	private CommandeRepository commandeRepository;

  
	
	 
	@Override
	public  Commande getByIdCommande(Long idCommande) throws Exception {
        return  (Commande) commandeRepository.findByIdCommande(idCommande);

	}

 
	@Override
	public Long save(Commande commande) throws Exception {
		
		commande = commandeRepository.save(commande);
		return commande.getIdCommande();
	}

 

	@Override
	public int updateId(Long idCommande) {
		return commandeRepository.updateIdCommande(idCommande);
	}


	@Override
	public int updateDesigCommande(Date dateCommande, Long qteCommande, Long idCommande) {
		return commandeRepository.updateDesigCommande(dateCommande, qteCommande, idCommande);

	}




	@Override
	public List<Commande> getAll() {
 		return (List<Commande>) commandeRepository.findAll() ;
	}


	@Override
	public void deleteCommandeByIdProduit(Long produit){
		commandeRepository.deleteCommandeByIdProduit(produit);
		
	}
	
	@Override
	public void deleteCommande(Long idCommande) {
		commandeRepository.deleteById(idCommande);
		
	}

	 

   
}
