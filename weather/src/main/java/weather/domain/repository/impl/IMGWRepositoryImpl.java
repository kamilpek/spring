package weather.domain.repository.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import weather.domain.IMGW;
import weather.domain.json.IMGWjson;
import weather.domain.repository.IMGWRepository;

@Repository
public class IMGWRepositoryImpl implements IMGWRepository {
	
	private IMGWjson imgwjson = new IMGWjson();
	private ArrayList<IMGW> imgwlist = new ArrayList<IMGW>(); 

	public IMGWRepositoryImpl() {
		super();
		imgwlist = imgwjson.download();
	}

	public ArrayList<IMGW> getDataFromWeb() {
		return imgwlist;
	}
	
	public IMGW getMeasurWhereId(String numer_stacji) {
		IMGW measurById = null;
		
		for(IMGW measur : imgwlist) {
			if(measur != null && measur.getId_stacji() != null && measur.getId_stacji().equals(numer_stacji)){
				measurById = measur;
				break;
			}
		}

		if(measurById == null){
			throw new IllegalArgumentException("Brak stacji o wskazanym id: "+ numer_stacji);
		}

		return measurById;
	}

}
