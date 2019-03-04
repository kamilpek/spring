package weather.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class IMGW {
	
	@Id
	private String id_stacji;
	private String stacja;
	private String data;
	private String godzina;
	private float temperatura;
	private float predkosc_wiatru;
	private float kierunek_wiatru;
	private float wilgotnosc_wzgledna;
	private float suma_opadu;
	private float cisnienie;
	
	public IMGW() {
		super();
	}

	public IMGW(String id_stacji, String stacja, String data, String godzina, float temperatura, float predkosc_wiatru,
			float kierunek_wiatru, float wilgotnosc_wzgledna, float suma_opadu, float cisnienie) {
		super();
		this.id_stacji = id_stacji;
		this.stacja = stacja;
		this.data = data;
		this.godzina = godzina;
		this.temperatura = temperatura;
		this.predkosc_wiatru = predkosc_wiatru;
		this.kierunek_wiatru = kierunek_wiatru;
		this.wilgotnosc_wzgledna = wilgotnosc_wzgledna;
		this.suma_opadu = suma_opadu;
		this.cisnienie = cisnienie;
	}

	public String getId_stacji() {
		return id_stacji;
	}

	public void setId_stacji(String id_stacji) {
		this.id_stacji = id_stacji;
	}

	public String getStacja() {
		return stacja;
	}

	public void setStacja(String stacja) {
		this.stacja = stacja;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getGodzina() {
		return godzina;
	}

	public void setGodzina(String godzina) {
		this.godzina = godzina;
	}

	public float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}

	public float getPredkosc_wiatru() {
		return predkosc_wiatru;
	}

	public void setPredkosc_wiatru(float predkosc_wiatru) {
		this.predkosc_wiatru = predkosc_wiatru;
	}

	public float getKierunek_wiatru() {
		return kierunek_wiatru;
	}

	public void setKierunek_wiatru(float kierunek_wiatru) {
		this.kierunek_wiatru = kierunek_wiatru;
	}

	public float getWilgotnosc_wzgledna() {
		return wilgotnosc_wzgledna;
	}

	public void setWilgotnosc_wzgledna(float wilgotnosc_wzgledna) {
		this.wilgotnosc_wzgledna = wilgotnosc_wzgledna;
	}

	public float getSuma_opadu() {
		return suma_opadu;
	}

	public void setSuma_opadu(float suma_opadu) {
		this.suma_opadu = suma_opadu;
	}

	public float getCisnienie() {
		return cisnienie;
	}

	public void setCisnienie(float cisnienie) {
		this.cisnienie = cisnienie;
	}
	
}
