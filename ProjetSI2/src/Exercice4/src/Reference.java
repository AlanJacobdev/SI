package Exercice4.src;

import java.util.HashMap;

import jfkbits.ExprList;
import jfkbits.LispParser.Expr;

public class Reference  {

	
	Object receiver;
	HashMap<String, Command> primitives = new HashMap<String, Command>(); 
	
	
	
	
	public Reference(Object receiver) {
		this.receiver = receiver;
		
	}
	
	
	public Command getCommandByName ( String selector ) {
		
		Command Cmd;
		
		if (primitives.isEmpty()) return null;
		
		Cmd = primitives.get(selector);
		
		return Cmd;
	}
	
	
	public void addCommand( String Selector, Command primitive) {
		
		primitives.put(Selector, primitive);
		
	}

	// Recevoir les insctruction, les décoder et lancer la bonne commande
	
	public Expr run(ExprList expr) {
		
		System.out.println(expr);
		Command cmd = getCommandByName(expr.get(1).getValue());
		cmd.run(receiver, expr);
		return expr;
		
		
	}
	
	
	
}
