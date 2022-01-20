/**
 * Universidad del Valle de Guatemala
 * Hoja de trabajo 1
 * File: Modelo
 * @author Juan Miguel González-Campo 21077
 * @author Aarón Beltran 21092
 * @author Juan Lorthiois 18771
 */

public class Modelo implements Radio {

	//Métodos y propiedades 
	
	/**
     * on es la variable que indica si la radio se encuentra encendida
     */
	private boolean on;
	/**
     * Station es la variable que indica la estación en la que se encuentra, por ejemplo 88.8
     */
	private double station;
	/**
     * Frecuencia indica si esta en AM o FM, sindo true y false respectivamente.
     */
	private boolean frequency; 
	/**
     * Favoritos es un Array que guarda las 12 estaciones favoritas.
     */
	private double[] favoritos  = new double[12];
	
	/**
     * Este es el que indica si la radio esta encendida o no.
     * 
     */
	@Override
	public boolean isOn() {
		return on;
	}

	/**
     * turnOnOff funciona para prender o apagar la radio.
     * 
     */
	@Override
	public void turnOnOff() {
		if (on == true) {
			on = false;
		}
		else {
			on = true;
		}
	}

	/**
     * Este metodo cambia de estación en un incremento, 0.2 para FM y 20 para AM.
     * 
     * @param frequency es un boolean que indica en si se encuentra en am o fm
     */
	@Override
	public void nextStation(boolean frequency) {
		if (frequency == false) {
			
			station = station +0.2; //  los incrementos en el espectro fm se hacen de 0.2 MHz en 0.2 MHz, entre 88 y 108
			if (station > 108) {
				station = 88.0;
			}
		}
		
		if (frequency == true) {
			
			station = station +20; //  los incrementos en el espectro am se hacen de 20 kHz en 20 kHz, entre 540 y 1700
			if (station > 1700) {
				station = 540 ;
			}
		}
	}

	/**
     * Este metodo cambia de estación hacia abajo, 0.2 para FM y 20 para AM.
     * 
     * @param frequency es un boolean que indica en si se encuentra en am o fm
     */
	@Override
	public void prevStation(boolean frequency) {
		if (getFrequency() == false) {
			
			station = getStation() - 0.20; //  los incrementos en el espectro fm se hacen de 0.2 MHz en 0.2 MHz, entre 88 y 108
			if (station < 88) {
				station = 108;
			}
		}
		
		if (getFrequency()==true) {
			
			station = station - 20; //  los incrementos en el espectro am se hacen de 20 kHz en 20 kHz, entre 540 y 1700
			if (station < 540) {
				station = 1700;
			}
		}
		
	}

	/**
     * Este metodo regresa station
     * 
     * @return station 
     */
	@Override
	public double getStation() {
		
		return station;
	}

	/**
     * Este metodo guarda una estación en los favoritos
     * 
     * @param position es un int que indica en que espacio de los favoritos se debe guardar de 1 a 12
	 * @param station indica la estación que desea guardar el usuario.
	 * 
     */
	@Override
	public void saveStation(int position, double station) {
		favoritos[position]=station;
	}

	/**
     * Este metodo cambia a una de las estaciones guardadas y regresa la misma estación
     * 
     * @param position int que indica la posicion de la estacion que se quiere escuchar
     */
	@Override
	public double getSavedStation(int position) {
		station = favoritos[position];
		return favoritos[position];
	}

	/**
     * Getter de frequency
     * 
     * @return frequency
     */
	@Override
	public boolean getFrequency() {
		
		return frequency;
	}
	/**
     * Este metodo cambia cambia entre AM y FM segun la variable frequency
     * 
     */
	@Override
	public void switchAMFM() {
		
		if (frequency == true) {
			frequency = false;
			station = 88.0;
		} else {
			frequency = true;
			station = 540;
		}
		
	}

	/**
     * Este es el constructor de la clase
     *
     */
	public Modelo() {
		super();
		this.on = false;
		this.station = 88.0;
		this.frequency = false;
	}

}
