package weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import weather.domain.IMGW;
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
		modelAndView.addObject("imgws", imgwrepository.getAllImgws());
		modelAndView.setViewName("imgws");
		return modelAndView;
	}
	
	@RequestMapping("/station")
	public String measurement(@RequestParam("id") String numer_stacji, Model model) {
		IMGW imgw = imgwrepository.getMeasurWhereId(numer_stacji);		
		model.addAttribute("imgw", imgw);		
		return "station";
	}
	
	@RequestMapping("/download")
	public String test(Model model) {
		IMGWjson imgwjson = new IMGWjson();
		imgwjson.download();		
		return "redirect:/imgws/all";
	}

}
