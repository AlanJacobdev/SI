package Exercice42;

/*
(space setColor black)  
(robi setColor yellow) 
(space sleep 2000) 
(space setColor white)  
(space sleep 1000) 	
(space add robi (GRect new))
(robi setColor green)
(robi translate 100 50)
(space del robi)
(robi setColor red)		  
(space sleep 1000)
(robi translate 100 0)
(space sleep 1000)
(robi translate 0 50)
(space sleep 1000)
(robi translate -100 0)
(space sleep 1000)
(robi translate 0 -40) ) 


(space add robi (rect.class new))
(robi translate 130 50)
(robi setColor yellow)
(space add momo (oval.class new))
(momo setColor red)
(momo translate 80 80)
(space add pif (image.class new logo.png))
(pif translate 100 0)
(space add hello (label.class new "Hello world"))
(hello translate 10 10)
(hello setColor black)

*/

import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;

import graphicLayer.GElement;
import graphicLayer.GImage;
import graphicLayer.GOval;
import graphicLayer.GRect;
import graphicLayer.GSpace;
import graphicLayer.GString;
import jfkbits.ExprList;
import jfkbits.LispParser;
import jfkbits.LispParser.Expr;
import tools.Tools;

class NewElement implements Command {
	public Expr run(Reference reference, ExprList method) {
		try {
			@SuppressWarnings("unchecked")
			GElement e = ((Class<GElement>) reference.getReceiver()).getDeclaredConstructor().newInstance();
			Reference ref = new Reference(e);
			ref.addCommand("setColor", new SetColor());
			ref.addCommand("translate", new Translate());
			ref.addCommand("setDim", new SetDim());
			return ref;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
}

public class Exercice4_2_0 {
	// Une seule variable d'instance
	static Environment environment = new Environment();

	public Exercice4_2_0() {
		GSpace space = new GSpace("Exercice 4", new Dimension(200, 100));
		space.open();

		Reference spaceRef = new Reference(space);
		Reference rectClassRef = new Reference(GRect.class);
		Reference ovalClassRef = new Reference(GOval.class);
		Reference imageClassRef = new Reference(GImage.class);
		Reference stringClassRef = new Reference(GString.class);

		spaceRef.addCommand("setColor", new SetColor());
		spaceRef.addCommand("sleep", new Sleep());
		spaceRef.addCommand("setDim", new SetDim());

		spaceRef.addCommand("add", new AddElement(environment));
		spaceRef.addCommand("del", new DelElement(environment));

		rectClassRef.addCommand("new", new NewElement());
		ovalClassRef.addCommand("new", new NewElement());
		imageClassRef.addCommand("new", new NewImage());
		stringClassRef.addCommand("new", new NewString());

		environment.addReference("space", spaceRef);
		environment.addReference("rect", rectClassRef);
		environment.addReference("oval", ovalClassRef);
		environment.addReference("image", imageClassRef);
		environment.addReference("label", stringClassRef);

		
	}

	
	void runScript(String script) {
		
		try 
        {    
            LispParser parser = new LispParser(script);
            Expr e = parser.parseExpr();
            if (e instanceof ExprList) {
                ExprList compiled = (ExprList) e;
                new Interpreter().compute(environment, compiled);
            }
        } catch (Exception e1) {
            System.out.println("Erreur");
        }
		
	}
	
	
	private static void mainLoop() {
		while (true) {
			System.out.print("> ");
			String input = Tools.readKeyboard();
			LispParser parser = new LispParser(input);
			try {
				Expr e = parser.parseExpr();
				if (e instanceof ExprList) {
					ExprList compiled = (ExprList) e;
					new Interpreter().compute(environment, compiled);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Exercice4_2_0();
		Exercice4_2_0.mainLoop();
	}

}