package weather.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import weather.models.IMGW;
import weather.repositories.IMGWRepository;

@RestController
@RequestMapping("/api/imgws")
public class IMGWRestController {
	
	@Autowired
	private IMGWRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<IMGW> getAll(){
		return repository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<IMGW> getById(@PathVariable("id") String id){
		return repository.findById(id);
	}
	
}
