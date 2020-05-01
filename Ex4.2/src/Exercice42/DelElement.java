package Exercice42;

import graphicLayer.GElement;
import graphicLayer.GSpace;
import jfkbits.ExprList;
import jfkbits.LispParser.Expr;

public class DelElement implements Command {


	Environment Element;

	public DelElement(Environment environment) {
		this.Element = environment;
	}


	public Expr run(Reference receiver, ExprList method) {


		Object o = receiver.getReceiver();


		if (o instanceof GSpace) {

			GSpace space;
			Reference ref;
			Object o1;


			space = (GSpace) o;
			if ((ref = this.Element.getReferenceByName(method.get(2).getValue())) != null) {
				o1 = ref.getReceiver();

				// Si il s'agit d'un GElement => Suppresion

				if (o1 instanceof GElement) {

					GElement elem = (GElement) o1;
					Element.variables.remove(method.get(2).getValue());
					space.removeElement(elem);
					space.repaint();
				}
			} else {
				System.err.println("L'objet n'existe pas ...");
			}

		}

		return null;
	}

}
