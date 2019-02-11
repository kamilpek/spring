package org.kamil.invoice.controller;

import org.kamil.invoice.domain.Seller;
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
@RequestMapping("/sellers")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@RequestMapping({"/all", "/"})
	public ModelAndView allSellers() {
		ModelAndView modelAndView = new ModelAndView();		
		modelAndView.addObject("sellers", sellerService.getAllSellers());
		modelAndView.setViewName("sellers");
		return modelAndView;
	}
	
	@RequestMapping("/seller")
	public String getSellerById(@RequestParam("id") String sellerId, Model model) {
		model.addAttribute("seller", sellerService.getSellerById(sellerId));
		return "seller";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewSellerForm(@ModelAttribute("newSeller") Seller newSeller) {
	   return "addSeller";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewSellerForm(@ModelAttribute("newSeller") Seller sellerToBeAdded, ModelMap map, BindingResult result) {
		String[] suppressedFields = result.getSuppressedFields();
		
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Próba wi¹zania niedozwolonych pól: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		
		sellerService.addSeller(sellerToBeAdded);
		return "redirect:/sellers/all";
	}
	
}
