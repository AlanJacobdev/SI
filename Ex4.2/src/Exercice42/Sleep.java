package Exercice42;

import jfkbits.ExprList;
import jfkbits.LispParser.Expr;
import tools.Tools;

public class Sleep implements Command {


	@Override
	public Expr run(Reference receiver, ExprList method) {


		Integer temps = 0;

		try {


			temps = Integer.parseInt(method.get(2).getValue());


			Tools.sleep(temps);

		} catch (IllegalArgumentException e) {

			System.err.println("Durée invalide " + e);

		}

		return null;
	}

}
