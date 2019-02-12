package org.kamil.invoice.controller;

import java.util.List;
import java.util.Map;

import org.kamil.invoice.domain.Client;
import org.kamil.invoice.domain.Document;
import org.kamil.invoice.domain.Product;
import org.kamil.invoice.domain.Seller;
import org.kamil.invoice.domain.pdf.DocumentPdf;
import org.kamil.invoice.service.ClientService;
import org.kamil.invoice.service.DocumentService;
import org.kamil.invoice.service.ProductService;
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
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping({"/all", "/"})
	public ModelAndView allDocuments() {
		ModelAndView modelAndView = new ModelAndView();		
		modelAndView.addObject("documents", documentService.getAllDocuments());
		modelAndView.setViewName("documents");
		return modelAndView;
	}
	
	@RequestMapping("/document")
	public String getDocumentById(@RequestParam("id") String documentId, Model model) {
		Document document = documentService.getDocumentById(documentId);
		Client client = clientService.getClientById(document.getClientId());
		Seller seller = sellerService.getSellerById(document.getSellerId());
		List<Product> products = productService.getProductsByInvoice(documentId);
		
		model.addAttribute("document", document);
		model.addAttribute("client", client);
		model.addAttribute("seller", seller);
		model.addAttribute("products", products);
		return "document";
	}
	
	@RequestMapping("/calc")
	public String calcDocumentValue(@RequestParam("id") String documentId, Model model) {		
		float netto_sum = productService.getNettoSumByInvoice(documentId);
		float brutto_sum = productService.getBruttoSumByInvoice(documentId);
		float tax_sum = productService.getTaxSumByInvoice(documentId);
		
		documentService.updateDocument(documentId, "netto", Float.toString(netto_sum));
		documentService.updateDocument(documentId, "brutto", Float.toString(brutto_sum));
		documentService.updateDocument(documentId, "tax", Float.toString(tax_sum));
		
		return "redirect:/documents/document?id=" + documentId;
	}
	
	@RequestMapping("/pdf")
	public String generatePdf(@RequestParam("id") String documentId, Model model) {
		Document document = documentService.getDocumentById(documentId);
		Client client = clientService.getClientById(document.getClientId());
		Seller seller = sellerService.getSellerById(document.getSellerId());
		List<Product> products = productService.getProductsByInvoice(documentId);
		
		DocumentPdf pdf = new DocumentPdf();
		pdf.generatePdf(document, client, seller, products);		
		
		return "redirect:/documents/documentPdf";
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
