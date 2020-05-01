package Exercice43;

import graphicLayer.GString;
import jfkbits.ExprList;
import jfkbits.LispParser.Expr;

public class NewString implements Command {

	// Méthode permettant de créer et afficher une nouvelle chaine de caractère

	@Override
	public Expr run(Reference receiver, ExprList method) {

		GString gs = new GString(method.get(2).getValue());
		Reference ref = new Reference(gs);
		ref.addCommand("translate", new Translate());
		ref.addCommand("setColor", new SetColor());
		return ref;

	}

}
