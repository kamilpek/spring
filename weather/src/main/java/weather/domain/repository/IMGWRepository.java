package weather.domain.repository;

import java.util.ArrayList;

import weather.domain.IMGW;

public interface IMGWRepository {
	
	ArrayList<IMGW> getAllImgws();

	IMGW getMeasurWhereId(String numer_stacji);
}
