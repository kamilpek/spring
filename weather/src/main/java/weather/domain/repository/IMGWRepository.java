package weather.domain.repository;

import java.util.ArrayList;

import weather.domain.IMGW;

public interface IMGWRepository {
	
	ArrayList<IMGW> getDataFromWeb();

	IMGW getMeasurWhereId(String numer_stacji);
}
