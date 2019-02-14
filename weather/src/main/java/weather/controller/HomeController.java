package weather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import weather.domain.json.IMGWjson;
import weather.domain.repository.IMGWRepository;

@Controller
public class HomeController {
	
	IMGWRepository imgwrepository;
	IMGWjson imgwjson = new IMGWjson();

	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Pogodynka");
		model.addAttribute("tagline", "Przejd� dalej za pomoc� poni�szych przycisk�w");
		
		return "welcome";
	}
	
}