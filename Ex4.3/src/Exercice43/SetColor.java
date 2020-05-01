package Exercice43;

import java.awt.Color;

import graphicLayer.GElement;
import graphicLayer.GSpace;
import jfkbits.ExprList;
import jfkbits.LispParser.Expr;
import tools.Tools;

public class SetColor implements Command {

	// Méthode permettant de fixer la couleur à un élement

	@Override
	public Expr run(Reference receiver, ExprList method) {

		// Déclaration de variable

		Object Recv = receiver.getReceiver();

		// Si l'objet est un GElement

		if (Recv instanceof GElement) {

			// Déclaration des variables

			GElement element = (GElement) Recv;
			Color color = Tools.getColorByName(method.get(2).toString());

			// Si la couleur donnée est pas nulle

			if (color != null) {
				element.setColor(color);
			}
		}

		// Sinon si il s'agit d'uu GSpace

		else if (Recv instanceof GSpace) {

			// Déclaration des variables

			GSpace space = (GSpace) Recv;
			Color color = Tools.getColorByName(method.get(2).toString());

			// Si la couleur donnée est pas nulle

			if (color != null) {
				space.setColor(color);
			}
		}

		return null;
	}

}
