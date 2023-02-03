
public class Gasto extends Dinero {
	
	//Constructor que hereda los parametros de la clase Dinero
	
	public Gasto(double gasto, String description) {
		this.setDinero(gasto);
		this.setDescription(description);
		
	} 
	/* Función toString para almacenar los datos que el usuario ha introducido y 
	 * sacarlos por consola en el menú de mostrar gastos*/
	@Override
	public String toString() { 
		
		return "Concepto Gasto: "+ this.getDescription() + ", Cantidad: "+ this.getDinero();

	}
}