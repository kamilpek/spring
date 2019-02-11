package org.kamil.invoice.controller;

import java.util.Map;

import org.kamil.invoice.domain.Document;
import org.kamil.invoice.service.ClientService;
import org.kamil.invoice.service.DocumentService;
import org.kamil.invoice.service.SellerService;
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
@RequestMapping("/documents")
public class DocumentController {
	
	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private SellerService sellerService;
	
	@RequestMapping({"/all", "/"})
	public ModelAndView allDocuments() {
		ModelAndView modelAndView = new ModelAndView();		
		modelAndView.addObject("documents", documentService.getAllDocuments());
		modelAndView.setViewName("documents");
		return modelAndView;
	}
	
	@RequestMapping("/document")
	public String getProductById(@RequestParam("id") String documentId, Model model) {
		model.addAttribute("document", documentService.getDocumentById(documentId));
		return "document";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView getAddNewDocumentForm() {
		ModelAndView mav = new ModelAndView("newDocument");
        Map<String, String> clients = clientService.getClientsMap();
        Map<String, String> sellers = sellerService.getSellersMap();
        
        mav.addObject("clientsMap", clients);
        mav.addObject("sellersMap", sellers);
        mav.addObject("newDocument", new Document());
        mav.setViewName("addDocument");
         
        return mav;
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewDocumentForm(@ModelAttribute("newDocument") Document documentToBeAdded, ModelMap map, BindingResult result) {
		String[] suppressedFields = result.getSuppressedFields();
		
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Próba wi¹zania niedozwolonych pól: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		
	   	documentService.addDocument(documentToBeAdded);
		return "redirect:/documents/all";
	}
	
}
