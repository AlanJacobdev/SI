package Exercice43;

import java.util.HashMap;
import java.util.Map;

import jfkbits.ExprList;
import jfkbits.LispParser.Expr;

class Reference implements Expr {

	// Déclaration de variables

	Object receiver;
	Map<String, Command> primitives;
	Environment environment;

	// Constructeur

	public Reference(Object receiver) {
		this.receiver = receiver;
		primitives = new HashMap<String, Command>();
	}

	// Setter de l'élement, forcer l'environemment

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

	// Ajouter une Commande au Hashmap

	public void addCommand(String selector, Command p) {
		primitives.put(selector, p);
	}

	// Récupérer le Receiver

	public Object getReceiver() {
		return receiver;
	}

	// Méthode Override de la méthode getValue de Expr

	@Override
	public String getValue() {
		return null;
	}
}
