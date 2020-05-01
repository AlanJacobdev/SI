package Exercice43;

import java.awt.Dimension;

import graphicLayer.GBounded;
import graphicLayer.GElement;
import graphicLayer.GSpace;
import jfkbits.ExprList;
import jfkbits.LispParser.Expr;

public class SetDim implements Command {

	// Méthode permettant de forcer les dimensions d'un élement

	@Override
	public Expr run(Reference receiver, ExprList method) {

		// Déclaration de variables

		Object Recv = receiver.getReceiver();

		// Si l'objet est un GElement

		if (Recv instanceof GElement) {

			// Declaration des variables

			GElement element;
			Integer x = 0;
			Integer y = 0;

			// Instanciation des variables

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

			// Si les deux valeur sont négatives

			else if (y < 0 && x < 0) {
				System.err.println("Valeur de x et y invalide: " + x + " " + y);
			}

			// Si x est négatif

			else if (x < 0) {
				System.err.println("Valeur de x invalide: " + x);
			}

			// Si y est négatif

			else {
				System.err.println("Valeur de y invalide: " + y);
			}

		} else if (Recv instanceof GSpace) {

			// Declaration des variables

			GSpace element;
			Integer x = 0;
			Integer y = 0;

			// Instanciation des variables

			element = (GSpace) Recv;

			// Vérification si la valeur de X est différent d'un chiffre

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

			// Si les deux valeur sont négatives

			else if (y < 0 && x < 0) {
				System.err.println("Valeur de x et y invalide: " + x + " " + y);
			}

			// Si x est négatif

			else if (x < 0) {
				System.err.println("Valeur de x invalide: " + x);
			}

			// Si y est négatif

			else {
				System.err.println("Valeur de y invalide: " + y);
			}

		}

		return null;
	}

}
