import java.util.InputMismatchException;
import java.util.Scanner;



public class Main {

	public static void main(String[] args){
		/*Declaramos variables para el nuevo usuario, inicializamos la clase usuario y la clase Scanner*/
		String nombre, DNI;
		int edad;
		Usuario usuario = new Usuario();
		Scanner sc = new Scanner(System.in);
		
		// Pedimos nombre al usuario por consola
		System.out.println("Introduce el nombre del usuario: ");
		nombre =sc.nextLine();
		usuario.setNombre(nombre);
		
		// Pedimos la edad al usuario por consola
		System.out.println("Introduce la edad del usuario: ");
		edad = sc.nextInt();
		usuario.setEdad(edad);
		sc.nextLine();
		
		//Pedimos el DNI al usuario por consola
		System.out.println("Introduce el DNI del usuario: ");
		DNI = sc.nextLine();
		usuario.setDni(DNI);	
		//Mientras no sea el formato correcto nos saltar� esta excepci�n manual.
		while(usuario.setDni(DNI)== false) {
			System.out.println("DNI introducido incorrecto.");
			System.out.println("Introduce el DNI del usuario v�lido: ");
			DNI = sc.nextLine();
		}
		
		// Confirmaci�n de usuario creado.
		System.out.println("Usuario creado correctamente."+ "\n"+ usuario.toString());
		
		//Inicializamos el Men� con los dato del usuario ya guardados:
		
		Cuenta cuenta = new Cuenta(usuario); //Creamos la cuenta con el usuario introducido anteriormente.
		
		//Variables que utilizaremos para realizar los Gastos e Ingresos.
		String descripcion;
		double cantidad;
		
		/*Bucle Do/while para que despu�s de realizar una acci�n nos salte de nuevo el men�, 
		 * excepto cuando demos a la opci�n de salida(0)*/
		boolean salir =false;
		int opcion;
		do{
			//Imprimimos por consola las opciones del men�:
			System.out.println("Realiza una nueva acci�n");
			System.out.println("1 Introduce un nuevo gasto");
			System.out.println("2 Introduce un nuevo ingreso");
			System.out.println("3 Mostrar gastos");
			System.out.println("4 Mostrar ingresos");
			System.out.println("5 Mostrar saldo");
			System.out.println("0 Salir");
			
			
			opcion = sc.nextInt();//lectura de la opci�n del men�
			sc.nextLine();//salto de linea tras un int/boolean
			
			boolean continuar = false;// boolean para el bucle de la excepci�n del formato num�rico (formatoeuropeo)para el case 1 y 2.
			
			//Inicializamos un switch case para cada opci�n del men�, la cual tendr� una funci�n dentro cada case.
			switch(opcion) {
			
			case 1: //Introducir un gasto.
				System.out.println("Introduce la descripci�n");
				descripcion= sc.nextLine();
				//Bucle para excepcion try/catch para imprimir la cantidad con el formato correcto
				do {
				System.out.println("Introduce la cantidad: ");
				try {
					cantidad=sc.nextDouble();
					cuenta.addGastos(descripcion, cantidad);
					continuar=true;
				}catch(InputMismatchException e) {
					continuar=false;
					sc.nextLine();
					System.out.println("Tienes que introducir el formato europeo ####,##");
				}
				}while(!continuar);//cerramos bucle excepcion 
				System.out.println(cuenta.toString());
				break;	
				
			case 2: //Introducir un ingreso
				System.out.println("Introduce la descripci�n");
				descripcion= sc.nextLine();
				//Bucle para excepcion try/catch para imprimir la cantidad con el formato correcto
				do {
				System.out.println("Introduce la cantidad: ");
				try {
					cantidad=sc.nextDouble();
					cuenta.addIngresos(descripcion, cantidad);
					continuar=true;
				}catch(InputMismatchException e) {
					continuar=false;
					sc.nextLine();
					System.out.println("Tienes que introducir el formato europeo ####,##�");
				}
				}while(!continuar);//cerramos bucle excepcion 
				System.out.println(cuenta.toString());
				break;
				
			case 3: // resumen de gastos
				
				for(int i = 0; i< cuenta.getGastos().size(); i++) {
					System.out.println(cuenta.getGastos().get(i).toString());
				}
				break;
				
			case 4: // resumen de ingresos
				
				for(int j = 0; j< cuenta.getIngresos().size(); j++) {
					System.out.println(cuenta.getIngresos().get(j).toString());
				}
				break;
				
			case 5: // saldo actual
				
				System.out.println(cuenta.toString());
				break;
				
			case 0: //salida del programa
				
				salir=true;
				System.out.println("Fin del programa."+"\n" +  "Gracias por utilizar la aplicaci�n.");
				break;
			
			}
			
		}while(!salir);//cerramos bucle switch case
		
		sc.close();// cerramos Scanner
		
	}

	
		
}


/*TODO Auto-generated method stub*/




