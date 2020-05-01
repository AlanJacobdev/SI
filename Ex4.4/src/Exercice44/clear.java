package Exercice44;

import graphicLayer.GContainer;
import jfkbits.ExprList;
import jfkbits.LispParser.Expr;

public class clear implements Command {

	@Override
	public Expr run(Reference receiver, ExprList method) {

		GContainer container = (GContainer) receiver.getReceiver();

		receiver.environment.clearElementAndReference(container);

		return null;
	}

}
