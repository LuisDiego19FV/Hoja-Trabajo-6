/**
 * 
 */
import java.util.Scanner;
/**
 * 
 * @author luisd
 * @version 12/03/2017
 * Programa principal para la utilizacion de SetFactory para guardar datos de empleados con diferentes habilidades, y organizarlos segun estas.
 *
 */
public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String method = "";
		boolean seguir = true;
		
		//Pide el metodo a utilizar de la interfaz set
		while (!method.equals("hashset") && !method.equals("linkedhashset") && !method.equals("treeset")){
			
			if (!method.equals("hashset") && !method.equals("linkedhashset") && !method.equals("treeset") && !method.equals(""))
				System.out.println("Porfavor ingrese unicamente uno de los metodos listados arriba (HashSet, LinkedHashSet, TreeSet)");
			
			System.out.println("Ingrese el methodo a utilizar: (HashSet, LinkedHashSet, TreeSet)");
			method = scanner.nextLine().toLowerCase();
			
		}
		
		
		//Inicializa el metodo a utilizar por medio de la clase SetFactory
		SetFactory setFactory = new SetFactory(method);
		
		
		//Loop para ingresar la cantidad de personas necesarias
		while (seguir){
			System.out.println("Ingrese el nombre de la persona");
			String nombre = scanner.nextLine();
			String habilidades = "";
			
			System.out.println("Elija las habilidades de la persona (elija los numeros de las habilidades de la persona)");
			System.out.println("Si tienen mas de una de estas habilidades ingrese un numero seguido de un espacio y el siguiente numero (ej: 1 2 3)");
			System.out.println("1) Java Developer");
			System.out.println("2) Web Developer");
			System.out.println("3) Mobile Developer");
			String habilidadesNumeros = scanner.nextLine();
			
			//Convierte los numeros ingresados en un String con las habilidades de cada individuo
			for (int n = 0; n < habilidadesNumeros.length(); n++){
				try{	
					if (habilidadesNumeros.substring(n, n+1).equals("1")){
						habilidades = habilidades + "/Java";
					}
					
					else if(habilidadesNumeros.substring(n, n+1).equals("2")){
						habilidades = habilidades + "/Web";
					}
					
					else if(habilidadesNumeros.substring(n, n+1).equals("3")){
						habilidades = habilidades + "/Mobile";
					}
					
				} catch(Exception e){
					System.out.println("out");
				}
			}
			
			//Pregunta al usuario si desea ingresar los datos (en caso de que hubiese un error en estos)
			System.out.println("Desea Ingresar los siguientes datos: nombre: " + nombre + ", habilidades: " + habilidades + " (Si/No)");
			String response = scanner.nextLine().toLowerCase();
			
			while (!response.equals("si") && !response.equals("s") && !response.equals("no") && !response.equals("n")){
				
				System.out.println("Unicamente puede ingresar: si, s, no, n");
				System.out.println("Desea Ingresar los siguientes datos: nombre: " + nombre + ", habilidades: " + habilidades + " (Si/No)");
				response = scanner.nextLine().toLowerCase();
				
			}
			
			if (response.equals("si") || response.equals("s"))
				setFactory.inputName_Skills(nombre, habilidades);
			else
				System.out.println("Los Nombres no fueron ingresados...");
			
			System.out.println("");
			
			String continuar = "";
			
			while (!continuar.equals("si") && !continuar.equals("no")){
				
				System.out.println("Desea Ingresar otra persona (Si/No)");
				continuar = scanner.nextLine().toLowerCase();
				
				if (continuar.equals("si"))
					seguir = true;
				else if (continuar.equals("no"))
					seguir = false;
				else 
					System.out.println("Porfavor ingrese unicamente si o no");
			}
			
		
			System.out.println("");
			
		}
		
		String[] arregloNombres = setFactory.getNames();

		
		for (int n = 0; n + 1 <= arregloNombres.length; n++){
			System.out.println(arregloNombres[n]);
		}

	}

}
