package Exercice2.src;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Iterator;

import graphicLayer.GRect;
import graphicLayer.GSpace;
import jfkbits.ExprList;
import jfkbits.LispParser;
import jfkbits.LispParser.Expr;
import jfkbits.LispParser.ParseException;
import tools.Tools;

public class Exercice2_1_0 {
	GSpace space = new GSpace("Exercice 2_1", new Dimension(200, 100));
	GRect robi = new GRect();
	String script = "(script (space setColor black) (robi setColor yellow) )";

	
	public Exercice2_1_0() {
		space.addElement(robi);
		space.open();
		this.runScript();
	}

	
	private void runScript() {
		LispParser parser = new LispParser(script);
		try {
			ExprList result = (ExprList) parser.parseExpr();
			Iterator<Expr> itor = result.iterator();
			itor.next(); // eat the "script" keyword atom
			while (itor.hasNext()) {
				this.run((ExprList) itor.next());
			}
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}

	
	private void run(ExprList expr) {
		
		
		String get;
		Iterator<Expr> itor = expr.iterator();
		
		
		while(itor.hasNext()) {
			
			
			get= itor.next().getValue();
				
			
			// Pour SPACE
			
			if (get.equals("space")) {
				get = itor.next().getValue();
					
				// setColor
				if(get.equals("setColor")) {
					get = itor.next().getValue();
					space.setColor(ColorSet(get));
				}
			}
				
			// Pour ROBI 
			
			if (get.equals("robi")) {
				get = itor.next().getValue();
				
				// setColor
				
				if(get.equals("setColor")) {
					get = itor.next().getValue();
						robi.setColor(ColorSet(get));
				}	
			}
			
			// Aucune commande
			else {
				new Error("Commande inconnue → " + expr);
			}
			
		}
	}
	
	// Renvoi la couleur associé au String
	
	private Color ColorSet(String c) {
			
		Color color;
		
		color = Tools.getColorByName(c);
			
		return color;
	}

	
	public static void main(String[] args) {
		new Exercice2_1_0();
	}

}