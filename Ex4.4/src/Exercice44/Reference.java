package Exercice44;

import java.util.HashMap;
import java.util.Map;

import jfkbits.ExprList;
import jfkbits.LispParser.Expr;

class Reference implements Expr {


	Object receiver;
	Map<String, Command> primitives;
	Environment environment;
	String name;
	Environment environmentParent;

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
		if (c == null) {
			c = (Command) this.getScriptByName(selector);

			if (c == null) {
				return null;
			}
		}
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


	HashMap<String, Command> StockScript = new HashMap<String, Command>();

	// Suppresion d'un Script

	public boolean delScript(String name) {

		if (StockScript.remove(name) != null) {
			return true;
		} else {
			return false;
		}

	}

	// Ajout d'un Script

	public void addScript(String name, Command script) {
		StockScript.put(name, script);
	}


	public Command getScriptByName(String name) {
		return StockScript.get(name);
	}

	public void setName(String string) {
		this.name = string;

	}

	public void setParent(Environment parent) {

		this.environmentParent = parent;
	}

}
