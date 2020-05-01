package Exercice43;

import jfkbits.ExprList;
import jfkbits.LispParser.Expr;
import tools.Tools;

public class Sleep implements Command {

	// Méthode appelant le Sleep

	@Override
	public Expr run(Reference receiver, ExprList method) {

		// Déclaration de variable

		Integer temps = 0;

		try {

			// Récupération et cast du temps

			temps = Integer.parseInt(method.get(2).getValue());

			// Sleep

			Tools.sleep(temps);

		} catch (IllegalArgumentException e) {

			System.err.println("Durée invalide " + e);

		}

		return null;
	}

}
