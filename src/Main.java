/**
 * Universidad del Valle de Guatemala
 * Hoja de trabajo 1
 * File: Main
 * @author Juan Miguel González-Campo 21077
 * @author Aarón Beltran 21092
 * @author Juan Lorthiois 18771
 */

 
 /*Imports */
import java.util.Scanner;

public class Main {

static Modelo modelo = new Modelo();
	
	
/**
 * Este metodo es el menu inicial cuando si inicial la aplicación.
 * 
 */	
static void prompt() {
		
		Scanner in = new Scanner(System.in);
		
		modelo.nextStation(modelo.getFrequency());
		
		
		System.out.print(""" 
				
				--------------------------RADIO G5-------------------------
				
					1. PARA ENCENDER LA RADIO 
					2. PARA SALIR

				-----------------------------------------------------------
				
				TU SELECCION -> """);
		
		int seleccion; 
		

		
		try {
			
			seleccion = in.nextInt();
			
			if (seleccion < 1 || seleccion > 2 ) { 
				
				System.out.println("LA SELECCION INGRESADA ES INVALIDA - VOLVIENDO AL MENU PRINCIPAL");
				prompt();
			}
			
			if (seleccion == 1) {
				
				modelo.turnOnOff();
				estadoRadio();
				opciones();
				
				
				
			}
			
			if (seleccion == 2) {
				
				System.out.println("---------FIN DE LA TRANSMISI�N----------");
				
			}
			
			
			} catch (java.util.InputMismatchException e) {
			
			System.out.println(" ");
			System.out.println("LA SELECCION INGRESADA ES INVALIDA - VOLVIENDO AL MENU PRINCIPAL");
			
			prompt();
			
		}
		
		
	}

/**
 * Este metodo indica que esta sucediendo en la radio, si esta encendida, en que frecuenca y estación se encuentra.
 * 
 */
static void estadoRadio() {
	
	String banda; 
	String estado;
	
	if (modelo.isOn() == true) { // convirtiendo de boolean a String para presentacion de datos al usuario
		
		estado = "ON";
		
	}else {
		
		estado = "OFF";
		
	}
	
	
	
	
	if (modelo.getFrequency() == true ) {
		
		banda = "AM";
		
	} else {
		
		banda = "FM";
	}
	
	
	
	System.out.println(" ");
	System.out.println("-----------------------RADIO G5 -----------------------");
	System.out.print("Estado: " + estado ); 
	System.out.println("			Banda: "+ banda);
	System.out.println("				Frecuencia: "+ modelo.getStation());
	System.out.println("-------------------------------------------------------");
}


/**
 * Menu secundario de la consola, donde se puede interactuar con la radio.
 * 
 */	
static void opciones() {
	
	Scanner in = new Scanner(System.in);
	
	modelo.nextStation(modelo.getFrequency());
	
	
	System.out.print(""" 
			
			--------------------------OPCIONES-------------------------
			
				1. PARA PASAR A LA FRECUENCIA SIGUIENTE 
				2. PARA REGRESAR A LA FRECUENCIA ANTERIOR
				3. PARA CAMBIAR DE BANDA (AM/FM)
				4. PARA GUARDAR UNA FRECUENCIA
				5. PARA VER FRECUENCIAS GUARDADAS.
				6. PARA APAGAR EL RADIO

			-----------------------------------------------------------
			
			TU SELECCION -> """);
	
	int seleccion; 
	

	
	try {
		
		seleccion = in.nextInt();
		
		if (seleccion < 1 || seleccion > 5 ) { 
			
			System.out.println("LA SELECCION INGRESADA ES INVALIDA - VOLVIENDO AL MENU PRINCIPAL");
			prompt();
		}
		
		if (seleccion == 1) {
			
			modelo.nextStation(modelo.getFrequency());
			estadoRadio();
			opciones();
			
			
			
		}
		
		if (seleccion == 2) {
			
			modelo.prevStation(modelo.getFrequency());
			estadoRadio();
			opciones();
			
		}
		
		if (seleccion == 3) {
			
			modelo.switchAMFM();
			estadoRadio();
			opciones();
			
		}
		
		if (seleccion == 4) { // pediente implementar posibilidad de guardar favoritos
			int a = 0;
			int op = 0;
			
			while (a != 100){
				try {
					System.out.println("Indique en que favorito quiere guardarlo, seleccione de 1 a 12");
					op = in.nextInt();
				} catch (Exception e) {
					System.err.println("Ingrese solo un numero de 1 a 12");
					continue;
				}
				if (op > 0 || op <13){
					a = 100;
					break;
				} else{
					System.err.println("Ingrese solo un numero de 1 a 12");
					continue;
				}
			}
			int pos = op-1;
			Double s = modelo.getStation();
			modelo.saveStation(pos, s);
			opciones();
		}
		if (seleccion == 5){
			int a = 0;
			int op = 0;
			while (a != 100){
				try {
					System.out.println("Indique que favorito quiere usar, seleccione de 1 a 12");
					op = in.nextInt();
				} catch (Exception e) {
					System.err.println("Ingrese solo un numero de 1 a 12");
					continue;
				}
				if (op > 0 || op <13){
					a = 100;
					break;
				} else{
					System.err.println("Ingrese solo un numero de 1 a 12");
					continue;
				}
			}
			int s = op-1;
			System.out.println("Estación seleccionada: "+modelo.getSavedStation(s));
			opciones();
			

		}
		if (seleccion == 6) {
			
			System.out.println(" ");
			System.out.println("---------FIN DE LA TRANSMISI�N----------");
			
		}
		
		
		} catch (java.util.InputMismatchException e) {
		
		System.out.println(" ");
		System.out.println("LA SELECCION INGRESADA ES INVALIDA - VOLVIENDO AL MENU PRINCIPAL");
		
		prompt();
		
	}
	
	
}
	
	
	
	
/**
 * Este metodo es el driver del programa, llama al metodo prompt, que lo inicia. 
 * 
 */	
public static void main(String args[]) {
		
		prompt();
	}
	
}
