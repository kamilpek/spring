package weather.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
    String getView(Model model) {
		model.addAttribute("greeting", "Pogodynka");		
		model.addAttribute("tagline", "Przejdż dalej za pomocą poniższych przycisków");
        return "home";
    }

}
