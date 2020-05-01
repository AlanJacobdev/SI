package Exercice43;

import java.util.HashMap;

public class Environment {

	// Déclaration de variables

	HashMap<String, Reference> variables = new HashMap<String, Reference>();

	// Ajout de reférences

	public void addReference(String name, Reference Ref) {

		variables.put(name, Ref);

	}

	// Suppression de référence

	public void delReference(String name) {

		this.variables.remove(name);

	}

	// Récupérer une réference par son nom

	public Reference getReferenceByName(String name) {

		Reference Ref;

		if (variables.isEmpty())
			return null;

		Ref = variables.get(name);

		return Ref;
	}

}
