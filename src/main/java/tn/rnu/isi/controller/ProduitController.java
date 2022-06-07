package tn.rnu.isi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tn.rnu.isi.model.Produit;
import tn.rnu.isi.service.CommandeService;
import tn.rnu.isi.service.ProduitService;


 
@Controller("produitController")
public class ProduitController {
	
	private final Logger logger = LoggerFactory.getLogger(ProduitController.class);

 
	@Autowired
	ProduitService produitService;
	
	
	@Autowired
	CommandeService commandeService;
 
 

@RequestMapping(value = "/produit/listAll", method = RequestMethod.GET)

	protected ModelAndView showAllProduits() throws Exception {
		/*
		 * Lancement du Service et recupeation donnees en base
		 */
		List<Produit> listeProduits = produitService.getAll();

		/*
		 * Envoi Vue + Modele MVC pour Affichage donnees vue
		 */
		return new ModelAndView("/produit/showAllProduits", "produits", listeProduits);
	}

	 	@RequestMapping(value = "/produit/list", method = RequestMethod.GET)
	    public String list(Model model) throws Exception {
	        model.addAttribute("produits", produitService.getAll());
	        return "/produit/showAllProduits"; // Afficher la page showAllProduits.html qui se trouve sous /produit
	        
	    }

	    @RequestMapping(value = "/produit/get/{id}" , method = RequestMethod.GET)
	    public String get(@PathVariable Long id, Model model) throws Exception {
	        model.addAttribute("produitToShow", produitService.getByIdProduit(id));
	        return "/produit/showProduit"; // Afficher la page showProduit.html qui se trouve sous /produit
	    }
	    
	    
	    @RequestMapping(value = "/produit/save", method = RequestMethod.POST)
	    public String saveOrUpdate(@ModelAttribute("produitForm") Produit produit, Model model, final RedirectAttributes redirectAttributes) throws Exception {
	    	try {
				
	    		System.err.println(produit.getIdProduit());
			
	    		if(produit.getIdProduit() != null){
	    			
	    			 produitService.save(produit);
	    			
					redirectAttributes.addFlashAttribute("typeAlert", "update");
			    	redirectAttributes.addFlashAttribute("msgAlert", "Produit dont ID : "+produit.getIdProduit()+" a été mis à jour.");
			    	
			     
			     
				} else{
					
					Long idProduit = produitService.save(produit);
					
					redirectAttributes.addFlashAttribute("typeAlert", "new");
			    	redirectAttributes.addFlashAttribute("msgAlert", "Nouveau Produit a été enregsitrée avec ID : "+idProduit);
				}
	    		
			

 	    	
	    	
	    	
	    	} catch (Exception e) {
				e.printStackTrace();
			}
	        return "redirect:/produit/listAll";
	    }
	    
	    

 
	    @RequestMapping("/produit/update/{id}")
	    public String update(@PathVariable Long id, Model model, final RedirectAttributes redirectAttributes) throws Exception {
	        Produit produit = produitService.getByIdProduit(id);
	        model.addAttribute("produitForm", produit);
	        return "/produit/addUpdateProduit";
	    }
	    
	    @RequestMapping(value = "/produit/delete/{id}")
	 	@Transactional
	    public String delete(@PathVariable Long id, final RedirectAttributes redirectAttributes) throws Exception {
	    
	    	System.err.println(id +  "i'm in delete");
	    	
	    	commandeService.deleteCommandeByIdProduit(id);
	        produitService.deleteProduit(id);
	        
	        redirectAttributes.addFlashAttribute("typeAlert", "delete");
	    	redirectAttributes.addFlashAttribute("msgAlert", "Produit dont ID : "+id+" a été supprimé.");
	    	
	        return "redirect:/produit/listAll";
	    }
	    
	    @RequestMapping(value = "/produit/clear")
	    public String deleteAll() throws Exception {
	    	List<Produit> listeProduits = produitService.getAll();
	    	for (Produit produit : listeProduits) {
		    	commandeService.deleteCommandeByIdProduit(produit.getIdProduit());	
		    	produitService.deleteProduit(produit.getIdProduit());
			}
	    	
	        return "redirect:/produit/listAll";
	    }
 
}
