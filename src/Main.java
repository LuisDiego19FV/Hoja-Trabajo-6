/**
 * 
 */
import java.util.Scanner;
/**
 * 
 * @author Luis Diego Fernandez 16344
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
		
		System.out.println("");
		
		
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
		
		//Imprime desarrolladores java, web y mobiles
		String[] arrAllSkills = setFactory.getDev("allSkills");

		System.out.println("");
		System.out.println("1) Desarrolladores de Java, Web y Mobiles");
		for (int n = 0; n  < arrAllSkills.length; n++){
			if(arrAllSkills[n] != null)
				System.out.println(arrAllSkills[n]);
		}
		
		//Imprime desarrolladores java pero no web
		String[] arrJavaNotWeb = setFactory.getDev("javaNotWeb");
		
		System.out.println("");
		System.out.println("2) Desarrolladores de Java pero no de Web");
		for (int n = 0; n + 1 <= arrJavaNotWeb.length; n++){
			if(arrJavaNotWeb[n] != null)
				System.out.println(arrJavaNotWeb[n]);
		}
		
		//Imprime desarrolladores que no sean de java
		String[] arrWebMobile = setFactory.getDev("allButJava");
		
		System.out.println("");
		System.out.println("3) Desarrolladores Web y Mobil pero no de Java");
		for (int n = 0; n + 1 <= arrWebMobile.length; n++){
			if(arrWebMobile[n] != null)
				System.out.println(arrWebMobile[n]);
		}
		
		//Imprime desarrolladores web o mobiles
		String[] arrWebOrMobile = setFactory.getDev("webOrMobile");
		
		System.out.println("");
		System.out.println("4) Desarrolladores Web o Mobil pero no de Java");
		for (int n = 0; n + 1 <= arrWebOrMobile.length; n++){
			if(arrWebOrMobile[n] != null)
				System.out.println(arrWebOrMobile[n]);
		}
		System.out.println("");
		System.out.println("5) No es subconjunto");

		String[] arrMayor = setFactory.getDev("biggest");
		
		//Imprime el mayor grupo
		System.out.println("");
		System.out.println("6) Conjunto con mayor grupo de Desarrolladores:");
		System.out.println(arrMayor[0]);
		
		String[] arrJava = setFactory.getDev("java");
		String[] arrWeb = setFactory.getDev("web");
		String[] arrMobile = setFactory.getDev("mobile");
		
		//Imprime en orden alfabetico los desarrolladores del mayor grupo
		System.out.println("");
		System.out.println("7) Conjunto con mayor grupo de Desarrolladores:");

		if (arrMayor[0].equals("Java")){
			
			for (int j = 97; j < (97+26); j++){
				for (int n = 0; n + 1 <= arrJava.length; n++){
					if(arrJava[n] != null && arrJava[n].substring(0, 1).toLowerCase().equals(Character.toString((char) j)))
						System.out.println(arrJava[n]);
				}
			}
			
		}
		
		if (arrMayor[0].equals("Web")){
			for (int j = 97; j < (97+26); j++){
				for (int n = 0; n + 1 <= arrWeb.length; n++){
					if(arrWeb[n] != null && arrWeb[n].substring(0, 1).toLowerCase().equals(Character.toString((char) j)))
						System.out.println(arrWeb[n]);
				}
			}
			
		}
		
		if (arrMayor[0].equals("Mobile")){
			
			for (int j = 97; j < (97+26); j++){
				for (int n = 0; n + 1 <= arrMobile.length; n++){
					if(arrMobile[n] != null && arrMobile[n].substring(0, 1).toLowerCase().equals(Character.toString((char) j)))
						System.out.println(arrMobile[n]);
				}
			}
			
		}

	}

}
