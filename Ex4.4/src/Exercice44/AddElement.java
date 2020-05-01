package Exercice44;

import graphicLayer.GContainer;
import graphicLayer.GElement;
import graphicLayer.GRect;
import graphicLayer.GSpace;
import jfkbits.ExprList;
import jfkbits.LispParser.Expr;

public class AddElement implements Command {


	Environment Element;


	public AddElement(Environment environment) {
		this.Element = environment;
	}

	// Méthode ajoutant un élement à l'affichage

	@Override
	public Expr run(Reference receiver, ExprList method) {

		Object o = null;

		if (Element.getReferenceByName(method.get(2).toString()) == null) {


			o = receiver.getReceiver();

			// Effectuer le code si le receiver est un GSpace

			if (o instanceof GRect || o instanceof GSpace && o != null) {


				GContainer container;
				Reference nr;
				Object o1;


				container = (GContainer) o;

				nr = (Reference) new Interpreter().compute(Element, (ExprList) method.get(3));

				o1 = nr.getReceiver();

				// Si le receiver n'est pas null et qu'il s'agit d'un GElement

				if (o1 != null && o1 instanceof GElement) {
					GElement e = (GElement) o1;
					Element.addReference(method.get(2).toString(), nr);
					nr.setParent(this.Element);
					nr.setName(method.get(2).toString());
					container.addElement(e);
					container.repaint();
				}

			}


			else {
				System.err.println("Impossible d'ajouter des élements ici");
			}
		}


		else {
			System.err.println("L'objet existe déja");
		}

		return receiver;
	}

}
