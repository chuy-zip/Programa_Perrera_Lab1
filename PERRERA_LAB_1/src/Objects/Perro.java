// Clase "Perro" Creada por Ricardo Andrés Chuy Morales 221007
// Carnet: 221007 Programación Orientada a Objetos 2022
// Clase Perro: Un objeto que representa a un perro dentro de una perra. El cual tiene cierto ánimo y 
// reacciona de cierta formaa en función de dicho ánimo

package Objects;

import java.util.Random;

public class Perro {
	//Declaración de variable para el animo y el umbral negatvo para que muerda el perro
	private double animo;
	private double umbral;	
	
	//Construcor de objeto perro, cada vez que se instancia sus valores cambian de manera aleatoria
	public Perro() {
		Random rand = new Random();
		float animoPerro = rand.nextFloat() * 10 - 5;
		float umbralPerro = rand.nextFloat() * 20 - 20;
		setAnimo(animoPerro);
		setUmbral(umbralPerro);
			
	}

	// Getters y setters de todas las variables para poder modificar los datos del objeto
	public double getAnimo() {
		return animo;
	}

	public void setAnimo(double animo) {
		this.animo = animo;
	}

	public double getUmbral() {
		return umbral;
	}

	public void setUmbral(double umbral) {
		this.umbral = umbral;
	}
	
	

}
