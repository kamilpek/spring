package weather.domain.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;

import org.json.simple.JSONObject;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import weather.domain.IMGW;

public class IMGWjson {

	public IMGWjson() {
		super();	
	}
	
	public ArrayList<IMGW> download(){
		ArrayList<IMGW> imgw_data = new ArrayList<IMGW>();
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
					
					imgw_data.add(imgw);
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

		return imgw_data;
	}

}
