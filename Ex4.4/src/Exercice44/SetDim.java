package Exercice44;

import java.awt.Dimension;

import graphicLayer.GBounded;
import graphicLayer.GElement;
import graphicLayer.GSpace;
import jfkbits.ExprList;
import jfkbits.LispParser.Expr;

public class SetDim implements Command {


	@Override
	public Expr run(Reference receiver, ExprList method) {


		Object Recv = receiver.getReceiver();


		if (Recv instanceof GElement) {


			GElement element;
			Integer x = 0;
			Integer y = 0;


			element = (GElement) Recv;

			// Vérification si la valeur de X est différent d'un chiffre

			try {
				x = Integer.parseInt(method.get(2).getValue());
			} catch (NumberFormatException e) {
				System.err.println("Valeur de X invalide : " + e);
				x = ((GBounded) element).getWidth();
			}

			// Vérification si la valeur de Y est différent d'un chiffre

			try {
				y = Integer.parseInt(method.get(3).getValue());
			} catch (NumberFormatException e) {
				System.err.println("Valeur de Y invalide: " + e);
				y = ((GBounded) element).getHeight();
			}

			// Si les paramètres de longueur sont non null et >= 0

			if (y >= 0 && x >= 0) {

				Dimension dim = new Dimension(x, y);
				((GBounded) element).setDimension(dim);
				element.repaint();
			}


			else if (y < 0 && x < 0) {
				System.err.println("Valeur de x et y invalide: " + x + " " + y);
			}


			else if (x < 0) {
				System.err.println("Valeur de x invalide: " + x);
			}


			else {
				System.err.println("Valeur de y invalide: " + y);
			}

		} else if (Recv instanceof GSpace) {


			GSpace element;
			Integer x = 0;
			Integer y = 0;


			element = (GSpace) Recv;


			try {
				x = Integer.parseInt(method.get(2).getValue());
			} catch (NumberFormatException e) {
				System.err.println("Valeur de X invalide : " + e);
				x = ((GSpace) element).getWidth();
			}

			// Vérification si la valeur de Y est différent d'un chiffre
			try {
				y = Integer.parseInt(method.get(3).getValue());
			} catch (NumberFormatException e) {
				System.err.println("Valeur de Y invalide: " + e);
				y = ((GSpace) element).getHeight();
			}

			// Si les paramètres de longueur sont non null et >= 0

			if (y >= 0 && x >= 0) {

				Dimension dim = new Dimension(x, y);
				((GSpace) element).changeWindowSize(dim);
				element.repaint();
			}


			else if (y < 0 && x < 0) {
				System.err.println("Valeur de x et y invalide: " + x + " " + y);
			}


			else if (x < 0) {
				System.err.println("Valeur de x invalide: " + x);
			}


			else {
				System.err.println("Valeur de y invalide: " + y);
			}

		}

		return null;
	}

}
