/**
 * 
 */
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
/**
 * 
 * @author Luis Diego Fernandez
 *
 */
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
	 * @param toReturn ,Sring con las condiciones de lo que se busca que se regrese
	 * @return Arreglo de strings con los nombres y habilidades de las personas.
	 */
	public String[] getDev(String toReturn){
		Iterator itr = set.iterator();
		int javaCounter = 0;
		int webCounter = 0;
		int mobileCounter = 0;
		
		int counter = 0;
		String[] ret = new String[set.size()];
		
		while (itr.hasNext()){
			String skills = (String) itr.next();
			String subsSkills = skills + "    ";
			boolean java = false;
			boolean web = false;
			boolean mobile = false;
			
			for (int n = 0; n < subsSkills.length(); n++){
				try{
					if (subsSkills.substring(n, n + 4).equals("Java"))
						java = true;
					if (subsSkills.substring(n, n + 3).equals("Web"))
						web = true;
					if (subsSkills.substring(n, n + 6).equals("Mobile"))
						mobile = true;

					
				} catch(Exception e){
					
				}
			}
			
			if (java)
				javaCounter++;
			if (web)
				webCounter++;
			if (mobile)
				mobileCounter++;
				
			if (toReturn.equals("allSkills")){
				if (java && web && mobile)
					ret[counter] = skills;
			}
			
			else if (toReturn.equals("javaNotWeb")){
				if (java && !web)
					ret[counter] = skills;
			}
			
			else if (toReturn.equals("allButJava")){
				if (!java && web && mobile)
					ret[counter] = skills;
			}
			
			else if (toReturn.equals("webOrMobile")){
				if ((web && !mobile && !java) || (mobile && !web && !java))
					ret[counter] = skills;
			}
			
			else if (toReturn.equals("java")){
				if (java)
					ret[counter] = skills;
			}
			
			else if (toReturn.equals("web")){
				if (web)
					ret[counter] = skills;
			}
			
			else if (toReturn.equals("mobile")){
				if (mobile)
					ret[counter] = skills;
			}
			
			counter++;
			
		}
		
		if (toReturn.equals("biggest")){
			String[] newRet = new String[1];
			if (javaCounter >= mobileCounter && javaCounter >= webCounter)
				newRet[0] =  "Java";
			else if (mobileCounter >= javaCounter && mobileCounter >= webCounter)
				newRet[0] =  "Mobile";
			else if (webCounter >= mobileCounter && webCounter >= javaCounter)
				newRet[0] =  "Web";
			
			return newRet;
		}
		
		else
			return ret;
	}
	
	
}
