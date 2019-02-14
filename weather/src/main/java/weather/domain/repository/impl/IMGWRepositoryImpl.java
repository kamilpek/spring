package weather.domain.repository.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import weather.domain.IMGW;
import weather.domain.json.IMGWjson;
import weather.domain.repository.IMGWRepository;

@Repository
public class IMGWRepositoryImpl implements IMGWRepository {
	
	private IMGWjson imgwjson = new IMGWjson();

	public ArrayList<IMGW> getDataFromWeb() {
		return imgwjson.download();
	}

}
