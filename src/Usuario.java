import java.util.regex.*;

public class Usuario {
	
	//ATRIBUTOS
	private String nombre;
	private int edad;
	private String DNI;
	
	
	//CONSTRUCTOR 
	public Usuario() {
		this.nombre = "";
		this.edad = 0;
		this.DNI = "";
	}
	
	//MÉTODOS
		
		//getters and setters
		
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public int getEdad() {
			return edad;
		};
		public void setEdad(int edad) {
			this.edad = edad;
		};
		public String getDni() {
			return DNI;
		};
		
		
		public boolean setDni(String DNI) {
			//Creamos el patrón para el formato del DNI
			Pattern pattern = Pattern.compile("^[0-9]{8}[-]?[A-Z]{1}$");
			Matcher matcher = pattern.matcher(DNI);
			/*si el DNI introducido es correcto devolverá true y continuaremos con el programa, 
			si por el contrario es false volverá a pedir los datos*/
			if (matcher.matches()) {
				this.DNI= DNI;
				return true;
			}else {
				return false;
			}			
		}
			
						
		
		//Función toString para imprimir por devolver los datos del usuario creado
		@Override
		public String toString() {
			return "Nombre: " + nombre + "\n" +
				   "Edad: " + edad + "\n" +
				   "DNI: " + DNI;
		
		
	}
	
	

}
