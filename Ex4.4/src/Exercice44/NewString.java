package Exercice44;

import graphicLayer.GString;
import jfkbits.ExprList;
import jfkbits.LispParser.Expr;

public class NewString implements Command {


	@Override
	public Expr run(Reference receiver, ExprList method) {

		GString gs = new GString(method.get(2).getValue());
		Reference ref = new Reference(gs);
		ref.addCommand("translate", new Translate());
		ref.addCommand("setColor", new SetColor());
		ref.addCommand("addScript", new AddScript());
		ref.addCommand("delScript", new DelScript());

		return ref;

	}

}
