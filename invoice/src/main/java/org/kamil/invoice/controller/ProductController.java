package org.kamil.invoice.controller;

import java.util.Map;

import org.kamil.invoice.domain.Document;
import org.kamil.invoice.domain.Product;
import org.kamil.invoice.service.DocumentService;
import org.kamil.invoice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private DocumentService documentService;
	
	@RequestMapping({"/all", "/"})
	public ModelAndView allProducts() {
		ModelAndView modelAndView = new ModelAndView();		
		modelAndView.addObject("products", productService.getAllProducts());
		modelAndView.setViewName("products");
		return modelAndView;
	}
	
	@RequestMapping("invoice/{invoice}")
	public String getProductsByCategory(@PathVariable("invoice") String productInvoice, Model model) {
		model.addAttribute("products", productService.getProductsByInvoice(productInvoice));
		return "products";
	}
	
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId, Model model) {
		Product product = productService.getProductById(productId);
		Document document = documentService.getDocumentById(product.getDocumentId());
		
		model.addAttribute("product", product);
		model.addAttribute("document", document);
		return "product";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView getAddNewProductForm() {
		ModelAndView mav = new ModelAndView("newProduct");
		Map<String, String> documents = documentService.getDocumentsMap();
		
		mav.addObject("documentsMap", documents);
		mav.addObject("newProduct", new Product());
		mav.setViewName("addProduct");
		
		return mav;
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product productToBeAdded, ModelMap map, BindingResult result) {
		String[] suppressedFields = result.getSuppressedFields();
		
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Próba wi¹zania niedozwolonych pól: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		
	   	productService.addProduct(productToBeAdded);
		return "redirect:/products/all";
	}
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("productId", "name", "quantity", "netto", "brutto", "tax", "sumNetto", "sumBrutto", "sumTax", "documentId");
	}
	
}
