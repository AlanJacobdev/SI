package Exercice42;

import java.awt.Point;

import graphicLayer.GBounded;
import graphicLayer.GElement;
import jfkbits.ExprList;
import jfkbits.LispParser.Expr;

public class Translate implements Command {


	@Override
	public Expr run(Reference receiver, ExprList method) {


		Object Recv = receiver.getReceiver();
		Integer x;
		Integer y;


		if (Recv instanceof GElement) {


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


				element.translate(new Point(x, y));


			} catch (NumberFormatException e) {

				System.err.println("Mauvaise valeur " + e);
			}

		}

		return null;
	}

}
