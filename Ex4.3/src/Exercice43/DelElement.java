package Exercice43;

import graphicLayer.GContainer;
import graphicLayer.GElement;
import jfkbits.ExprList;
import jfkbits.LispParser.Expr;

public class DelElement implements Command {

	// Déclaration de variables

	Environment Element;

	// Constructeur

	public DelElement(Environment environment) {
		this.Element = environment;
	}

	// Méthode supprimant un élément de l'affichage

	public Expr run(Reference receiver, ExprList method) {

		// Récupération du receiver

		Object o = receiver.getReceiver();

		// Effectuer le code si le receiver est un GContainer

		if (o instanceof GContainer) {

			// Déclaration des variables

			GContainer container;
			Reference ref;
			Object o1;

			// Instanciation des variables

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
					System.out.println("L'élément "+ RefConca +" à été supprimé");

				}
			}

			// La référence est inconnue

			else {
				System.err.println("L'objet n'existe pas ...");
			}

		}

		return null;
	}

}
