package Exercice44;

import jfkbits.ExprList;
import jfkbits.LispParser.Expr;

class Interpreter {

	public Expr compute(Environment env, ExprList expr) {
		if (expr.size() < 2)
			return null;

		String[] path = expr.get(0).getValue().split("\\.");
		Reference receiver = env.getReferenceByName(expr.get(0).getValue());

		
		// Récupération du dernier environnement
		
		for (int i = 0; i < path.length; i++) {
			receiver = env.getReferenceByName(path[i]);

			if (receiver.environment != null) {
				env = receiver.environment;
			} else if (i > path.length - 1) {
				return null;
			}

		}

		if (receiver == null) {
			return null;
		}

		return receiver.run(expr);
	}
}
