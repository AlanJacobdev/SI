package Exercice44;

import jfkbits.ExprList;
import jfkbits.LispParser.Expr;

public class DelScript implements Command {

	@Override
	public Expr run(Reference receiver, ExprList method) {

		String script;

		try {

			script = method.get(2).getValue();

			if (!(script.isEmpty())) {

				// Suppression effectuée
				if ((receiver.delScript(script)) == true) {
					System.out.println("Script supprimé : " + script);
				} else {
					System.out.println("Script Inconnnu");
				}

			} else if (script.isEmpty()) {

				System.err.println("Script vide");

			}

		} catch (NullPointerException e) {
			System.out.println(" Script null");
		}

		return null;
	}

}
