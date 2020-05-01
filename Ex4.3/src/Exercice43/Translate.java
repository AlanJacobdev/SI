package Exercice43;

import java.awt.Point;

import graphicLayer.GBounded;
import graphicLayer.GElement;
import jfkbits.ExprList;
import jfkbits.LispParser.Expr;

public class Translate implements Command {

	// Méthode appelant le déplacement d'un élément

	@Override
	public Expr run(Reference receiver, ExprList method) {

		// Déclaration des élements

		Object Recv = receiver.getReceiver();
		Integer x;
		Integer y;

		// Si l'objet est un GElement

		if (Recv instanceof GElement) {

			// Cast de l'Object vers un GElement

			GElement element = (GElement) Recv;

			try {

				// Vérification si x est valide

				try {
					x = Integer.parseInt(method.get(2).getValue());
				} catch (NumberFormatException e) {
					System.err.println("Valeur de X invalide : " + e);
					x = ((GBounded) element).getWidth();
				}

				// Vérification si y est valide

				try {
					y = Integer.parseInt(method.get(3).getValue());
				} catch (NumberFormatException e) {
					System.err.println("Valeur de Y invalide: " + e);
					y = ((GBounded) element).getHeight();
				}

				// Translation d'un élement

				element.translate(new Point(x, y));

				// Catch de l'exception

			} catch (NumberFormatException e) {

				System.err.println("Mauvaise valeur " + e);
			}

		}

		return null;
	}

}
