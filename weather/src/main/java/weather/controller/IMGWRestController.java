package weather.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import weather.domain.IMGW;
import weather.domain.repository.IMGWRepository;

@RestController
@RequestMapping("/api/imgws")
public class IMGWRestController {
	
	@Autowired
	IMGWRepository imgwrepository;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<IMGW>> listAllImgws(){
		ArrayList<IMGW> imgws = imgwrepository.getAllImgws();		
		if(imgws.isEmpty()) {
			return new ResponseEntity<ArrayList<IMGW>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ArrayList<IMGW>>(imgws, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/station/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IMGW> getImgw(@PathVariable("id") String id){
		IMGW imgw = imgwrepository.getMeasurWhereId(id);
		if(imgw == null) {
			return new ResponseEntity<IMGW>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<IMGW>(imgw, HttpStatus.OK);		
	}

}
