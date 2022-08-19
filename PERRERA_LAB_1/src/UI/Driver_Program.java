// Driver Program Creado por Ricardo Andrés Chuy Morales 221007
// Programación orientad a objetos 2022
// Este codigo es el encargado de llevar a cabo los procesos e interacciones entre las clases Perro y Persona

package UI;
import java.util.Scanner;

import Objects.Perro;
import Objects.Persona;
import java.util.Random;

public class Driver_Program {
	
	public static void main(String[] args) {	
		//Declaración de objetos y variables útiles para el programa
		Perro chucho;
		Persona voluntario;
		Scanner escaner = new Scanner(System.in);
		String opcion = "";
		
		//Se crean inicialmente los 2 objetos en caso que el usuario no genere un nuevo perro o persona.
		chucho = NuevoPerro();
		voluntario = NuevaPersona();
		
		//El menú está en un loop, que termina luego de ingresar el numero que corresponde a la opción 5
		while(!opcion.equals("5")) {
			
			//El menu se muestra despues de cada vez que se elige una acción.
			MostrarMenu();
			opcion = "" + escaner.nextInt();
			
			// Opción para crear y cambiar un nuevo perro
			if (opcion.equals("1")){
				chucho = NuevoPerro();
				System.out.println("Perro animo: " + chucho.getAnimo());
				System.out.println("Perro umbral: " + chucho.getUmbral());
				System.out.println("\n");
			// Opción para crear y cambiar un nuevo perro
			} else if (opcion.equals("2")) {
				voluntario = NuevaPersona();
				System.out.println("Persona confiabilidad: " + voluntario.getConfiabilidad());
				System.out.println("La persona tiene una Galleta: " + voluntario.isTieneGalleta());
				System.out.println("\n");
			// Opción para tomar una galleta y cambiar a true el valor de tieneGalleta
			} else if (opcion.equals("3")) {
				voluntario.setTieneGalleta(sacarGalleta(voluntario));
				System.out.println("La persona tiene Galleta: " + voluntario.isTieneGalleta());
				System.out.println("\n");
			// Interacción con el perro
			} else if (opcion.equals("4")) {
				System.out.println("\n");
				animoPerro(voluntario, chucho);
				// Luego de calcular el nuevo ánimo es que se muestra la reacción del perro.
				System.out.println(reaccionPerro(chucho.getAnimo(), chucho.getUmbral()));
				System.out.println("\n");
			// Terminar el programa	
			} else if (opcion.equals("5")) {
				System.out.println("Gracias por usar el programa");
				System.out.println("\n");
				System.exit(0);
			}
			
			
		}
	}
	//Metodo para mostrar el menu de opciones
	public static void MostrarMenu(){
		System.out.println("Gracias por usar el programa para voluntarios de la perrera");
		System.out.println("Por favor elige cual de las siguientes acciones desesas realizar");
		System.out.println("1.Crear un nuevo perro");
		System.out.println("2.Crear un nuevo voluntario");
		System.out.println("3.Tomar una galleta");
		System.out.println("4.Interactuar con el perro");
		System.out.println("5.Terminar el programa");
		System.out.println("\n");
	}
	//Metodo para instanciar a la clase perro
	public static Perro NuevoPerro(){
		Perro perro;
		perro = new Perro();
		return perro;
	}
	//Metodo para instanciar a la clase perro
	public static Persona NuevaPersona(){
		Persona voluntario;
		voluntario = new Persona();
		return voluntario;
	}
	//Metodo para que el valor de galleta del voluntario cambie a true, si este es false
	public static boolean sacarGalleta(Persona voluntario){
		if(voluntario.isTieneGalleta()) {
			System.out.println("Ya se tiene una galleta");
			return voluntario.isTieneGalleta();
			
		}
		else {
			System.out.println("Se acaba de tomar una galleta");
			return true;
		}
	}
	// Método que determina el animo del perro mediante una formula que involucra el animo del perro y la confiabilidad de
	// la persona
	private static void animoPerro(Persona p, Perro chucho) {
		double animo = chucho.getAnimo();
		Random rand2 = new Random();

		animo = (1.0 / p.getConfiabilidad() ) * (rand2.nextFloat() - 0.5) * 10 + animo;
		if (p.isTieneGalleta()){	
			p.darGalleta();
			animo += (1.0 /p.getConfiabilidad()) * (rand2.nextInt(2));
		}	
		
		chucho.setAnimo(animo);
		System.out.println("Mi nuevo animo es: " + chucho.getAnimo());		
		System.out.println("El perro se enojará mucho si este valor es menor que " + chucho.getUmbral());
		System.out.println("\n");
	}
	
	// Metodo que regresa la acción del perro en función de su animo y umbral de enojo.
	public static String reaccionPerro(Double animo, Double umbral) {
		String reaccion = "";
		
		if (animo >= 0) 
			reaccion = "El perro ha movido la cola y parece feliz";
		
		else if (animo < 0 && animo > umbral)
			reaccion = "El perro ha ladrado, parece estar un poco molesto";
			
		else if (animo < umbral)
			reaccion = "El perro te ha mordido y está muy molesto";
		
		return reaccion;
	}
}
