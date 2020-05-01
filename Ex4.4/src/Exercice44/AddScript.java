package Exercice44;

import jfkbits.ExprList;
import jfkbits.LispParser;
import jfkbits.LispParser.Expr;
import jfkbits.LispParser.ParseException;

public class AddScript implements Command {


	@Override
	public Expr run(Reference receiver, ExprList method) {

		String script = null;
		Expr expression = null;
		LispParser sep = null;
		ExprList action = null;
		boolean flag = false;
		int i;
		ExprList ligne = null;

		script = method.get(2).toString();

		if (receiver.environmentParent.getReferenceByName(script) == null) {

			sep = new LispParser(method.get(3).toString());

			try {
				expression = sep.parseExpr();

				// Effectuer le code si le receiver est un ExprList

				if (expression instanceof ExprList) {
					action = (ExprList) expression;
					for (i = 0; i < action.size() && !(flag); i++) {

						ligne = (ExprList) action.get(i);
						System.out.println(ligne);

						if (!(ligne.get(0).toString().startsWith("self"))) {
							flag = true;
						}

					}

					// Si il n'y a pas d'erreur dans le script
					
					if (!(flag)) {
						receiver.addScript(script, new RunScript(action));
						System.out.println("Création du Script effectué");
						System.out.println("Script → " + script + "\n" + action);
					} else {
						String error = ligne.toString();
						if (error.contains("\n")) {
							error = error.replace("\n", "");
						}
						System.err.println("Problème de commande n° " + (i - 1) + " → " + error);
					}
				} else {
					System.err.println("Impossible de convertir l'expression");
				}

			} catch (ParseException e) {
				System.err.println("Erreur de ParseExpr");
			}
		}

		else {
			System.err.println("Script déja existant");
		}

		return receiver;
	}

}