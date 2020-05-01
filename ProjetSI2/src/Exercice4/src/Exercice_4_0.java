package Exercice4.src;
 
//	(space setColor black)  
//	(robi setColor yellow) 
//	(space sleep 2000) 
//	(space setColor white)  
//	(space sleep 1000) 	
//	(robi setColor red)		  
//	(space sleep 1000)
//	(robi translate 100 0)
//	(space sleep 1000)
//	(robi translate 0 50)
//	(space sleep 1000)
//	(robi translate -100 0)
//	(space sleep 1000)
//	(robi translate 0 -40) ) 


import java.awt.Dimension;

import graphicLayer.GRect;
import graphicLayer.GSpace;
import jfkbits.ExprList;
import jfkbits.LispParser;
import jfkbits.LispParser.ParseException;
import tools.Tools;


public class Exercice_4_0 {
	
	static Environment environment = new Environment();

	public Exercice_4_0() {
		GSpace space = new GSpace("Exercice 4", new Dimension(200, 100));
		GRect robi = new GRect();

		space.addElement(robi);
		space.open();

		Reference spaceRef = new Reference(space);
		Reference robiRef = new Reference(robi);

		
		robiRef.addCommand("setColor", new RobiColor());
		robiRef.addCommand("translate", new RobiTranslate());
		
		
		spaceRef.addCommand("setColor", new SpaceSetColor());
		spaceRef.addCommand("sleep", new SpaceSleep());
		
		environment.addReference("space", spaceRef);
		environment.addReference("robi", robiRef);

		
	}

	void runScript(String script) {
		
			
				LispParser parser = new LispParser(script);
				try {
					// compilation 
					ExprList compiled = (ExprList) parser.parseExpr();
					// execution de la s-expression compilee
					run(compiled);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
	}
			
		
    
	
	
	private static void mainLoop() {
		while (true) {
			// prompt
			System.out.print("> ");
			// lecture d'une s-expression au clavier
			String input = Tools.readKeyboard();
			// creation du parser
			if (!input.equals("")) {
				LispParser parser = new LispParser(input);
				try {
					// compilation 
					ExprList compiled = (ExprList) parser.parseExpr();
					// execution de la s-expression compilee
					run(compiled);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
			else
			{
				System.out.println("Veuillez rentrer une valeur");
			}
		}
	}

	private static void run(ExprList expr) {
		// quel est le nom du receiver
		String receiverName = expr.get(0).getValue();
		// quel est le receiver
		Reference receiver = environment.getReferenceByName(receiverName);
		// demande au receiver d'executer la s-expression compilee
		receiver.run(expr);
	}

	
	public static void main(String[] args) {
		new Exercice_4_0();
		Exercice_4_0.mainLoop();
	}

}