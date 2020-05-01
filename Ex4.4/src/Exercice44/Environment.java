package Exercice44;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import graphicLayer.GContainer;
import graphicLayer.GElement;

public class Environment {


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
	
	// Clear de l'interface et réference

	public void clearElementAndReference(GContainer container) {

		for (Iterator<Entry<String, Reference>> it = variables.entrySet().iterator(); it.hasNext();) {
			Entry<String, Reference> entry = it.next();

			Object receiver = entry.getValue().getReceiver();

			if (receiver != null && receiver instanceof GElement) {
				System.out.println("La référence " + entry.getKey() + " à été supprimée");
				GElement element = (GElement) receiver;
				container.removeElement(element);
				it.remove();
			}

		}

		container.repaint();
	}

}
