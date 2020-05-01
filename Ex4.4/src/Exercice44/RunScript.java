package Exercice44;

import jfkbits.ExprList;
import jfkbits.LispParser;
import jfkbits.LispParser.Expr;

public class RunScript implements Command {

	ExprList script;

	public RunScript(ExprList script) {
		this.script = script;
	}

	@Override
	public Expr run(Reference receiver, ExprList method) {
		ExprList parametres = (ExprList) this.script.get(0);

		for (int i = 1; i < script.size(); i++) {
			String chaineScript = script.get(i).toString();

			// Remplacer le self
			
			chaineScript = chaineScript.replaceAll("\\b" + parametres.get(0).toString() + "\\b", receiver.name);

			// Remplacer les paramètres
			
			for (int j = 1; j < parametres.size(); j++) {
				chaineScript = chaineScript.replaceAll("\\b" + parametres.get(j).toString() + "\\b",
						method.get(j + 1).toString());
			}

			// Execution
			
			LispParser parser = new LispParser(chaineScript);
			try {
				Expr e = parser.parseExpr();
				if (e instanceof ExprList) {
					ExprList compiled = (ExprList) e;
					// System.out.println(compiled.toString());
					new Interpreter().compute(receiver.environmentParent, compiled);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		return null;
	}

}
