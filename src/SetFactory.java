
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetFactory {
	
	// Atributos de la clase
	private Set set;
	
	/**
	 * @param method ,String con el metodo a utilizar
	 * Inicializa el atributo set segun el metodo indicado.
	 */
	public SetFactory(String method) {

		if (method.equals("hashset"))
			set = new HashSet();
		else if (method.equals("linkedhashset"))
			set = new LinkedHashSet();
		else 
			set = new TreeSet();
		
	}
	
	/**
	 * @param name ,String con el nombre de la persona ingresada
	 * @param skills ,String con los skills de la persona ingresada
	 * Se encarga de ingresar un String con el nombre y habilidades de la persona a la lista.
	 */
	public void inputName_Skills(String name, String skills){
		String input = name + " || " + skills;
		set.add(input);
		
	}
	
	/**
	 * @return regresar un arreglo de String con todos los nombres y habilidades de las personas ingresadas.
	 */
	public String[] getNames(){
		Iterator itr = set.iterator();
		
		int counter = 0;
		String[] ret = new String[set.size()];
		
		while (itr.hasNext()){
			ret[counter] = (String) itr.next();
			counter++;
		}
		return ret;
	}
	
	public String[] getNames(){
		Iterator itr = set.iterator();
		
		int counter = 0;
		String[] ret = new String[set.size()];
		
		while (itr.hasNext()){
			String skills = (String) itr.next();
			boolean java = false;
			boolean web = false;
			boolean mobile = false;
			
			for (int n = 0; n < skills.length(); n++){
				
			}
		}
		return ret;
	}
	
	
}
