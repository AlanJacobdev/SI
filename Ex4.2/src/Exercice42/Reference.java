package Exercice42;

import java.util.HashMap;
import java.util.Map;

import jfkbits.ExprList;
import jfkbits.LispParser.Expr;

class Reference implements Expr {


	Object receiver;
	Map<String, Command> primitives;
	Environment environment;


	public Reference(Object receiver) {
		this.receiver = receiver;
		primitives = new HashMap<String, Command>();
	}


	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	// Récupérer une commande par son nom Clé

	public Command getCommandByName(String selector) {
		return primitives.get(selector);
	}

	// Lancer la commande correspondant a l'expression

	public Expr run(ExprList e) {
		String selector = e.get(1).getValue();
		Command c = this.getCommandByName(selector);
		if (c == null)
			return null;
		return c.run(this, e);
	}


	public void addCommand(String selector, Command p) {
		primitives.put(selector, p);
	}


	public Object getReceiver() {
		return receiver;
	}


	@Override
	public String getValue() {
		return null;
	}
}
