
public class Ingreso extends Dinero {
	
	//Constructor que hereda los parametros de la clase Dinero
	
	public Ingreso(double ingreso, String description) {
		this.setDinero(ingreso);
		this.setDescription(description);
		
	} 
	/* Funci�n toString para almacenar los datos que el usuario ha introducido y 
	 * sacarlos por consola en el men� de mostrar ingresos*/
	@Override
	public String toString() {
		return "Concepto ingreso: "+ this.getDescription()+ ", Cantidad: "+ this.getDinero();

	}
}
