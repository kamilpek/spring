package weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import weather.domain.json.IMGWjson;
import weather.domain.repository.IMGWRepository;

@Controller
@RequestMapping("/imgws")
public class IMGWController {
	
	@Autowired
	IMGWRepository imgwrepository;
		
	@RequestMapping({"/all", "/"})
	public ModelAndView showAll() {
		ModelAndView modelAndView = new ModelAndView();		
		modelAndView.addObject("imgws", imgwrepository.getDataFromWeb());
		modelAndView.setViewName("imgws");
		return modelAndView;
	}
	
	@RequestMapping("/download")
	public String test(Model model) {
		IMGWjson imgwjson = new IMGWjson();
		imgwjson.download();		
		return "redirect:/imgws/all";
	}

}
