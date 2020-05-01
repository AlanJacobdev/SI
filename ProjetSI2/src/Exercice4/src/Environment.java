package Exercice4.src;

import java.util.HashMap;

public class Environment {
	

	HashMap<String, Reference> variables = new HashMap<String, Reference>(); 
	
	
	public void addReference(String name, Reference Ref) {
		
		variables.put(name, Ref);
		
	}
	
	public Reference getReferenceByName(String name) {
		
		Reference Ref;
		
		if(variables.isEmpty()) return null;
		
		Ref = variables.get(name);
		
		return Ref;
	}
}
