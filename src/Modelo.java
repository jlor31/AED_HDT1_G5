
import java.util.Scanner;

public class Modelo implements Radio {

	// Datos y variables
	
	private boolean on;
	private double station;
	private boolean frequency; // true = AM; false = FM
	private double[] favoritos  = new double[12];
	
	
	@Override
	public boolean isOn() {
		return on;
	}

	@Override
	public void turnOnOff() {
		if (on == true) {
			on = false;
		}
		else {
			on = true;
		}
	}

	@Override
	public void nextStation(boolean frequency) {
		if (frequency == false) {
			station = station +0.2; //  los incrementos en el espectro fm se hacen de 0.2 MHz en 0.2 MHz, entre 88 y 108
			if (station >= 108) {
				station = 88.0;
			}
		}
		if (frequency == true) {
			
			station = station +20; //  los incrementos en el espectro am se hacen de  MHz en 0.2 MHz, entre 88 y 108
			if (station >= 1700) {
				station = 540 ;
			}
		}
	}

	@Override
	public void prevStation(boolean frequency) {
		if (frequency == false) {
			station = station - 0.2; //  los incrementos en el espectro fm se hacen de 0.2 MHz en 0.2 MHz, entre 88 y 108
			if (station <= 88.0) {
				station = 108.0;
			}
		}
		if (frequency == true) {
			
			station = station +0.2; //  los incrementos en el espectro am se hacen de  MHz en 0.2 MHz, entre 88 y 108
			if (station >= 1700) {
				station = 540 ;
			}
		}
		
	}

	@Override
	public double getStation() {
		
		return station;
	}

	@Override
	public void saveStation(int position, double station) {
		// TODO Auto-generated method stub
		favoritos[position]=station;
	}

	@Override
	public double getSavedStation(int position) {
		
		return favoritos[position];
	}

	@Override
	public boolean getFrequency() {
		
		return frequency;
	}

	@Override
	public void switchAMFM() {
		if (frequency == true) {
			frequency = false;
		}
		if (frequency == false) {
			frequency = true;
		}
		
	}

	public Modelo() {
		super();
		this.on = false;
		this.station = 88.0;
		this.frequency = false;
	}

}
