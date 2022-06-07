package tn.rnu.isi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.rnu.isi.model.Produit;


@Service
@Transactional
public class ProduitServiceImpl implements ProduitService{

	@Autowired
	private ProduitRepository produitRepository;

  
	
	 
	@Override
	public  Produit getByIdProduit(Long idProduit) throws Exception {
        return  (Produit) produitRepository.findByIdProduit(idProduit);

	}

 
	@Override
	public Long save(Produit produit) throws Exception {
		
		produit = produitRepository.save(produit);
		return produit.getIdProduit();
	}




	 


	@Override
	public int updateId(Long idProduit) {
		return produitRepository.updateIdProduit(idProduit);
	}


	@Override
	public int updateDesig(String desigProduit, Long qteProduit, Long idProduit) {
		return produitRepository.updateDesigProduit(desigProduit, qteProduit, idProduit) ;

	}




	@Override
	public List<Produit> getAll() {
 		return (List<Produit>) produitRepository.findAll() ;
	}


	@Override
	public void deleteProduit(Long idProduit) {
		produitRepository.delete(idProduit) ;
		
	}

	

   
}
