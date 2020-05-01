package Exercice43;

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
	
	
	
	(robi translate 130 50)
	(robi setColor yellow)
	(space add robi (rect new))
	(space.robi translate 130 50)
	(space.robi setDim 130 130)
	(space.robi add momo (oval new))
	(space.robi.momo setColor red)
	(momo translate 80 80)
	(space.robi.momo translate 80 80)
	(space.robi.momo setDim 150 150)
	(space.robi add pif (image new logo.png))
	(pif translate 100 0)
	(space add hello (label new "Hello world"))
	(hello translate 10 10)
	(hello setColor black)

*/

import java.awt.Dimension;
import graphicLayer.GImage;
import graphicLayer.GOval;
import graphicLayer.GRect;
import graphicLayer.GSpace;
import graphicLayer.GString;
import jfkbits.ExprList;
import jfkbits.LispParser;
import jfkbits.LispParser.Expr;
import tools.Tools;



public class Exercice4_3_0 {
	// Une seule variable d'instance
	Environment environment = new Environment();

	public Exercice4_3_0() {
		GSpace space = new GSpace("Exercice 4", new Dimension(400, 400));
		space.open();

		Reference spaceRef = new Reference(space);
		Reference rectClassRef = new Reference(GRect.class);
		Reference ovalClassRef = new Reference(GOval.class);
		Reference imageClassRef = new Reference(GImage.class);
		Reference stringClassRef = new Reference(GString.class);

		Environment EnvironnementBase = new Environment();
		spaceRef.setEnvironment(EnvironnementBase);

		spaceRef.addCommand("setColor", new SetColor());
		spaceRef.addCommand("sleep", new Sleep());
		spaceRef.addCommand("setDim", new SetDim());

		spaceRef.addCommand("add", new AddElement(EnvironnementBase));
		spaceRef.addCommand("del", new DelElement(EnvironnementBase));
		// spaceRef.addCommand("addScript", new AddElement(environment));

		rectClassRef.addCommand("new", new NewElement());
		ovalClassRef.addCommand("new", new NewElement());
		imageClassRef.addCommand("new", new NewImage());
		stringClassRef.addCommand("new", new NewString());

		environment.addReference("space", spaceRef);
		EnvironnementBase.addReference("rect", rectClassRef);
		EnvironnementBase.addReference("oval", ovalClassRef);
		EnvironnementBase.addReference("image", imageClassRef);
		EnvironnementBase.addReference("label", stringClassRef);

		this.mainLoop();
	}

	private void mainLoop() {
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
		new Exercice4_3_0();
	}

}