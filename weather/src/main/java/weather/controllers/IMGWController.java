package weather.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import weather.models.IMGW;
import weather.repositories.IMGWRepository;

@Controller
@RequestMapping("/imgws")
public class IMGWController {
	
	@Autowired
	private IMGWRepository repository;

	@RequestMapping({"/all", "/"})
	public ModelAndView showAll() {
		ModelAndView model = new ModelAndView();
		model.addObject("imgws", repository.findAll());
		model.setViewName("imgws");
		return model;
	}
	
	@RequestMapping("/station")
	public String station(@RequestParam("id") String numer_stacji, Model model) {
		Optional<IMGW> imgw = repository.findById(numer_stacji);
		model.addAttribute("imgw", imgw);
		return "station";
	}
	
	@RequestMapping("/download")
	public String test(Model model) {		
		this.getDataFromWeb();
		return "redirect:/imgws/all";
	}
	
	public void getDataFromWeb() {		
		Object json = null;
		JSONParser parser = new JSONParser();
		JSONArray array = null;
		
		try {
			URL url = new URL("https://danepubliczne.imgw.pl/api/data/synop/format/json");			
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String str = br.readLine();
			try {
				json = parser.parse(str);
				array = (JSONArray)json;
				int length = array.size();
				for(int i = 0; i < length; i++){
					JSONObject measur = (JSONObject)array.get(i);
					String id_stacji = (String) measur.get("id_stacji");
					String stacja = (String) measur.get("stacja");
					String data = (String) measur.get("data_pomiaru");
					String godzina = (String) measur.get("godzina_pomiaru");
					float temperatura = Float.parseFloat((String) measur.get("temperatura"));
					float predkosc_wiatru = Float.parseFloat((String) measur.get("predkosc_wiatru"));
					float kierunek_wiatru = Float.parseFloat((String) measur.get("kierunek_wiatru"));
					float wilgotnosc_wzgledna = Float.parseFloat((String) measur.get("wilgotnosc_wzgledna"));				
					float suma_opadu = 0;
					float cisnienie = 0;
					if (measur.get("suma_opadu") != null) {
						suma_opadu = Float.parseFloat((String) measur.get("suma_opadu"));
					}
					if (measur.get("cisnienie") != null) {
						cisnienie = Float.parseFloat((String) measur.get("cisnienie"));
					}
					
					IMGW imgw = new IMGW(id_stacji, stacja, data, godzina, temperatura,
							predkosc_wiatru, kierunek_wiatru, wilgotnosc_wzgledna, suma_opadu, cisnienie);
					
					repository.save(imgw);					
				}
			} catch (ParseException e) {
				System.err.println("DOWNLOAD | parser error "+ e.getMessage() );
	            System.exit(0);
			}
		} catch (MalformedURLException e) {
			System.err.println("DOWNLOAD | bad url error "+ e.getMessage() );
            System.exit(0);
		} catch (IOException e) {
			System.err.println("DOWNLOAD | url io error "+ e.getMessage() );
            System.exit(0);
		}
	}

}
