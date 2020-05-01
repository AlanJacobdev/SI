package Exercice44;

import graphicLayer.GContainer;
import graphicLayer.GElement;
import jfkbits.ExprList;
import jfkbits.LispParser.Expr;

public class DelElement implements Command {


	Environment Element;


	public DelElement(Environment environment) {
		this.Element = environment;
	}

	@Override
	public Expr run(Reference receiver, ExprList method) {


		Object o = receiver.getReceiver();


		if (o instanceof GContainer) {


			GContainer container;
			Reference ref;
			Object o1;


			container = (GContainer) o;

			String RefConca = method.get(2).getValue();

			if ((ref = this.Element.getReferenceByName(RefConca)) != null) {

				o1 = ref.getReceiver();

				// Si il s'agit d'un GElement => Suppresion ( en cascade)

				if (o1 instanceof GElement) {

					GElement elem = (GElement) o1;
					this.Element.delReference(RefConca);
					container.removeElement(elem);
					container.repaint();

				}
			}


			else {
				System.err.println("L'objet n'existe pas ...");
			}

		}

		return null;
	}

}
