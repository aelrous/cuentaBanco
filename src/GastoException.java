
public class GastoException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//variable para el mensaje de salida de la excepción
	String msg;
	
	public GastoException() {
		super("El gasto supera el saldo disponible. \n");
	}
	/*public GastoException(String msg) {
		this.msg=msg;
	}
	@Override
	public String getMessage() {
		return msg;
	}*/
}


