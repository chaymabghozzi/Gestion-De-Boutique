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

	import tn.rnu.isi.model.Client;
import tn.rnu.isi.model.Commande;
import tn.rnu.isi.service.ClientService;
	
@Controller("clientController")
public class ClientController {

		
		private final Logger logger = LoggerFactory.getLogger(ClientController.class);

	 
		@Autowired
		ClientService clientService;
	 

	@RequestMapping(value = "/client/listAll", method = RequestMethod.GET)

		protected ModelAndView showAllClients() throws Exception {
			/*
			 * Lancement du Service et recupeation donnees en base
			 */
			List<Client> listeClients = clientService.getAll();

			/*
			 * Envoi Vue + Modele MVC pour Affichage donnees vue
			 */
			return new ModelAndView("/client/showAllClients", "clients", listeClients);
		}

		 	@RequestMapping(value = "/client/list", method = RequestMethod.GET)
		    public String list(Model model) throws Exception {
		        model.addAttribute("clients", clientService.getAll());
		        return "/client/showAllClients"; // Afficher la page showAllCommandes.html qui se trouve sous /commande
		        
		    }

		    @RequestMapping(value = "/client/get/{id}" , method = RequestMethod.GET)
		    public String get(@PathVariable Long id, Model model) throws Exception {
		        model.addAttribute("clientToShow", clientService.getByIdClient(id));
		        return "/client/showClient"; // Afficher la page showCommande.html qui se trouve sous /commande
		    }
		    
		    
		    @RequestMapping(value = "/client/save", method = RequestMethod.POST)
		    public String saveOrUpdate(@ModelAttribute("clientForm") Client client, Model model, final RedirectAttributes redirectAttributes) throws Exception {
		    	try {
					
				
				Long idClient = clientService.save(client);

		    	
		    	if(  client.getIdClient()!=null){
					redirectAttributes.addFlashAttribute("typeAlert", "info");
			    	redirectAttributes.addFlashAttribute("msgAlert", "Client dont ID : "+client.getIdClient()+" a été mise à jour.");

				}else{
					redirectAttributes.addFlashAttribute("typeAlert", "success");
			    	redirectAttributes.addFlashAttribute("msgAlert", "Nouveau Client a été enregsitrée avec ID : "+idClient);
				}
		    	
		    	} catch (Exception e) {
					e.printStackTrace();
				}
		        return "redirect:/client/listAll";
		    }
		    

	 
		    @RequestMapping("/client/update/{id}")
		    public String update(@PathVariable Long id, Model model, final RedirectAttributes redirectAttributes) throws Exception {
		        Client client = clientService.getByIdClient(id);
		        model.addAttribute("clientForm", client);
		        return "/client/addUpdateClient";
		    }
		    
		    @RequestMapping(value = "/client/delete/{id}")
		    public String delete(@PathVariable Long id) throws Exception {
		        clientService.deleteClient(id);
		        return "redirect:/client/listAll";
		    }
		    
		    @RequestMapping(value = "/client/clear")
		    public String deleteAll() throws Exception {
		    	List<Client> listeClients = clientService.getAll();
		    	for (Client client : listeClients) {
			    	clientService.deleteClient(client.getIdClient());	
				}
		    	
		        return "redirect:/client/listAll";
		    }
	 
	}

