package tn.rnu.isi.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tn.rnu.isi.model.Commande;
import tn.rnu.isi.model.Produit;
import tn.rnu.isi.service.CommandeService;


 
@Controller("commandeController")
public class CommandeController {
	
	private final Logger logger = LoggerFactory.getLogger(CommandeController.class);

 
	@Autowired
	CommandeService commandeService;
 

@RequestMapping(value = "/commande/listAll", method = RequestMethod.GET)

	protected ModelAndView showAllCommandes() throws Exception {
		/*
		 * Lancement du Service et recupeation donnees en base
		 */
		List<Commande> listeCommandes = commandeService.getAll();

		/*
		 * Envoi Vue + Modele MVC pour Affichage donnees vue
		 */
		return new ModelAndView("/commande/showAllCommandes", "commandes", listeCommandes);
	}

	 	@RequestMapping(value = "/commande/list", method = RequestMethod.GET)
	    public String list(Model model) throws Exception {
	        model.addAttribute("commandes", commandeService.getAll());
	        return "/commande/showAllCommandes"; // Afficher la page showAllCommandes.html qui se trouve sous /commande
	        
	    }

	 	 @RequestMapping(value = "/commande/get/{id}" , method = RequestMethod.GET)
		    public String get(@PathVariable Long id, Model model) throws Exception {
		        model.addAttribute("commandeToShow", commandeService.getByIdCommande(id));
		        return "/commande/showCommande"; // Afficher la page showProduit.html qui se trouve sous /produit
		    }
	    
	    
	    @RequestMapping(value = "/commande/save", method = RequestMethod.POST)
	    public String saveOrUpdate(@ModelAttribute("commandeForm") Commande commande, Model model, final RedirectAttributes redirectAttributes) throws Exception {
	    	try {
				
			
			Long idCommande = commandeService.save(commande);

	    	
	    	if(  commande.getIdCommande()!=null){
				redirectAttributes.addFlashAttribute("typeAlert", "info");
		    	redirectAttributes.addFlashAttribute("msgAlert", "Commande dont ID : "+commande.getIdCommande()+" a été mise à jour.");

			}else{
				redirectAttributes.addFlashAttribute("typeAlert", "success");
		    	redirectAttributes.addFlashAttribute("msgAlert", "Nouvelle Commande a été enregsitrée avec ID : "+idCommande);
			}
	    	
	    	} catch (Exception e) {
				e.printStackTrace();
			}
	        return "redirect:/commande/listAll";
	    }
	    

 
	    @RequestMapping("/commande/update/{id}")
	    public String update(@PathVariable Long id, Model model, final RedirectAttributes redirectAttributes) throws Exception {
	        Commande commande = commandeService.getByIdCommande(id);
	        model.addAttribute("commandeForm", commande);
	        return "/commande/addUpdateCommande";
	    }
	    
	    @RequestMapping(value = "/commande/delete/{id}")
	    public String delete(@PathVariable Long id) throws Exception {
	        commandeService.deleteCommande(id);
	        return "redirect:/commande/listAll";
	    }
	    
	    @RequestMapping(value = "/commande/clear")
	    public String deleteAll() throws Exception {
	    	List<Commande> listeCommandes = commandeService.getAll();
	    	for (Commande commande : listeCommandes) {
		    	commandeService.deleteCommande(commande.getIdCommande());	
			}
	    	
	        return "redirect:/commande/listAll";
	    }
 
}
