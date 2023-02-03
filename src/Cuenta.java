import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Cuenta {
	//Atributos instanciados de las clases usuario, gasto e ingreso
	private double saldo;
	private Usuario usuario;
	private List<Gasto>gastos;
	private List<Ingreso>ingresos;
	Locale spanish = new Locale("es", "ES");
	NumberFormat nf = NumberFormat.getInstance(spanish);
	
	//Constructor
	public Cuenta(Usuario usuario) {
		this.usuario= usuario;
		this.saldo=0;
		this.gastos=new ArrayList<>();
		this.ingresos=new ArrayList<>();
	}
	
	//Métodos getters/setters
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo= saldo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	//Funciones para calcular el saldo tras los ingresos y gastos incluida la exception 
	
	public double addIngresos(String description, double cantidad) {
		this.setSaldo(this.getSaldo() + cantidad); //suma del saldo disponible + la cantidad ingresada 
		this.ingresos.add(new Ingreso(cantidad, description));//añade la info al Arraylist
		return this.getSaldo(); 
	}
	
	public double addGastos(String description, double cantidad) throws GastoException {
		try {
			if ( this.getSaldo() < cantidad) { //cuando la cantidad gastada es superior al saldo disponible salta la exception
				throw new GastoException();
			}else {
				this.setSaldo(this.getSaldo() - cantidad);//resta del saldo disponible - la cantidad gastada
				this.gastos.add(new Gasto(cantidad, description));//añade la info al Arraylist
			}
		}catch (GastoException e) {
			System.out.println(e.getMessage()); //llamamos al mensaje creado en la clase GastoException
		}
		return this.getSaldo();
	}
	
		
	//Funciones para listar los gastos e ingresos
	
	public List<Ingreso>getIngresos(){
		return ingresos;
	}
	public List<Gasto>getGastos(){
		return gastos;
	}
	
	// Función toString para almacenar el saldo disponible
	@Override
	public String toString() {
		
		return "Saldo disponible: " +  nf.format(this.getSaldo()) + "€";
	}
	
	
	
	

}
