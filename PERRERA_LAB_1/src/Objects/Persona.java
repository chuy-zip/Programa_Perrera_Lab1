// Clase "Persona" Creada por Ricardo Andrés Chuy Morales 221007
// Carnet: 221007 Programación Orientada a Objetos 2022
// Clase Persona: Un objeto que representa a un voluntario en un perrera. Este voluntario interactua con un perro,
// dependiendo de su nivel de confiabilidad y si posee una galleta puede afectar positiva o negativamente.

package Objects;

import java.util.Random;

public class Persona {
	// Declaración de la variable de confiabilidad y si la persona tiene una galleta
	private double Confiabilidad;
	private boolean tieneGalleta;
	
	// Constructor, para el Objeto Persona, cada vez que se instancia el objeto sus valores se cambian por nuevos aletorios
	public Persona(){
		Random rand = new Random();
		this.Confiabilidad = rand.nextFloat() * 10;
		this.tieneGalleta = false;
		
	}
	// Método que se usa cuando "Persona" utiliza la galleta 
	public void darGalleta() {
		setTieneGalleta(false);
	}
	
	//Getters y setters para utilizar las variables de confiabilidad y si "Persona" tien una galleta
	public double getConfiabilidad() {
		return Confiabilidad;
	}

	public void setConfiabilidad(double confibilidad) {
		Confiabilidad = confibilidad;
	}

	public boolean isTieneGalleta() {
		return tieneGalleta;
	}

	public void setTieneGalleta(boolean tieneGalleta) {
		this.tieneGalleta = tieneGalleta;
	}
	

}
