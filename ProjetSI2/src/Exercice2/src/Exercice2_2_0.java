package Exercice2.src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Iterator;

import graphicLayer.GRect;
import graphicLayer.GSpace;
import jfkbits.ExprList;
import jfkbits.LispParser;
import jfkbits.LispParser.Expr;
import jfkbits.LispParser.ParseException;
import tools.Tools;

public class Exercice2_2_0 {
	GSpace space = new GSpace("Exercice 2_2", new Dimension(200, 100));
	GRect robi = new GRect();
	String script = "(script (space sleep 10000)(space color white)(robi color red) (robi translate 10 0)(space sleep 100)(robi translate 0 10)(space sleep 100)(robi translate -10 0)(space sleep 100)(robi translate 0 -10) )";

	
	public Exercice2_2_0() {
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
		
		
		int x,y;
		
		Iterator<Expr> itor = expr.iterator();
		while(itor.hasNext()) {
			String get = itor.next().getValue();
			
		
			// Pour SPACE
			
			if (get.equals("space")) {
				get = itor.next().getValue();
					
				// setColor
				
				if(get.equals("color")) {
					get = itor.next().getValue();
					space.setColor(ColorSet(get));
				}	
				
				// Sleep
				
				if(get.equals("sleep")) {
					get = itor.next().getValue();
					Tools.sleep(Integer.parseInt(get));
				}
				
				
				
					
			}
				
			// Pour ROBI 
			
			if (get.equals("robi")) {
				get = itor.next().getValue();
				
				// setColor
				
				if(get.equals("color")) {
					get = itor.next().getValue();
					robi.setColor(ColorSet(get));
				}	
				
				// Translate
				
				if(get.equals("translate")) {
					x = Integer.parseInt(itor.next().getValue());
					y = Integer.parseInt(itor.next().getValue());
					
					robi.translate(new Point(x,y));
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
		new Exercice2_2_0();
	}

}