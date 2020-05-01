package Exercice3.src;

import java.awt.Dimension;
import java.util.Iterator;

import graphicLayer.GRect;
import graphicLayer.GSpace;
import jfkbits.ExprList;
import jfkbits.LispParser;
import jfkbits.LispParser.Expr;
import jfkbits.LispParser.ParseException;

public class Exercice3_0 {
	
	
	
	GSpace space = new GSpace("Exercice 3", new Dimension(200, 100));
	GRect robi = new GRect();
	String script = "(script (space sleep 1000)(space color cyan)(robi color blue)(space sleep 1000) (robi translate 10 0)(space sleep 100)(robi translate 0 10)(space sleep 100)(robi translate -10 0)(space sleep 100)(robi translate 0 -10) )";
	
	
	public Exercice3_0() {
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
		
		Command cmd = getCommandFromExpr(expr);
		if (cmd == null) throw new Error("unable ti get command for: " + expr);
		cmd.run();
		
	}
	

	Command getCommandFromExpr(ExprList expr) {
		
	
		Iterator<Expr> itor = expr.iterator();
		int height;
		int width; 
		int x;
		int y;
		
		
		String command = itor.next().getValue();
		
		// Gestion du SPACE
		
		if(command.equals("space") ) {
			
			command = itor.next().getValue();
			
			// Commande SLEEP
			
			if(command.equals("sleep") ) {
			
				command = itor.next().getValue();
				return new SpaceSleep(command);
				
				
			}
		
			// Commande SETCOLOR
			
			if(command.equals("setColor")  || command.equals("color")) {
				command = itor.next().getValue();
				
				return new SpaceSetColor(space, command);
				
			}
			
			//SETDIMENSION
			
			if(command.equals("dimension") ) {
				width  = Integer.parseInt(itor.next().getValue());
				height  = Integer.parseInt(itor.next().getValue());
				
				return new SpaceDimension(space, width, height);
			}
		
		
		
		}
		
		// Gestion du SPACE
		if(command.equals("robi") ) {
			command = itor.next().getValue();
			
			// SETCOLOR
			
			if(command.equals("setColor") || command.equals("color")) {
				
				command = itor.next().getValue();
				return new RobiColor(robi, command);
				
			}
			
			// TRANSLATE
			
			if(command.equals("translate") ) {
				
				x = Integer.parseInt(itor.next().getValue());
				y = Integer.parseInt(itor.next().getValue());
				
				return new RobiTranslate(robi, x,y);
				
			}
			
		}
		
		// Aucunes Commandes
		else
		{
			return null;
		}
		
		
		
		return null;
	}
	
	
	
	public static void main(String[] args) {
		new Exercice3_0();
	}

}