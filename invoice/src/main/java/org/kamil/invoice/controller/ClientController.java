package org.kamil.invoice.controller;

import org.kamil.invoice.domain.Client;
import org.kamil.invoice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping({"/all", "/"})
	public ModelAndView allClients() {
		ModelAndView modelAndView = new ModelAndView();		
		modelAndView.addObject("clients", clientService.getAllClients());
		modelAndView.setViewName("clients");
		return modelAndView;
	}
	
	@RequestMapping("/client")
	public String getClientById(@RequestParam("id") String clientId, Model model) {
		model.addAttribute("client", clientService.getClientById(clientId));
		return "client";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewClientForm(@ModelAttribute("newClient") Client newClient) {
	   return "addClient";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewClientForm(@ModelAttribute("newClient") Client clientToBeAdded, ModelMap map, BindingResult result) {
		String[] suppressedFields = result.getSuppressedFields();
		
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Próba wi¹zania niedozwolonych pól: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		
		clientService.addClient(clientToBeAdded);
		return "redirect:/clients/all";
	}
}
