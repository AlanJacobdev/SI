package Exercice43;

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

	public class Exercice4_3_0test {

	
		// Une seule variable d'instance
		Environment environment = new Environment();

		public Exercice4_3_0test() {
			GSpace space = new GSpace("Exercice 4 3", new Dimension(400, 400));
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
			System.out.println(" Test des commandes ");
			
			//Liste des commandes à executer *
					String commandes = 	"(space add robi (rect new))!"+
										"(space setColor red)!" + 
										"(space.robi translate 50 50)!" + 
										"(space.robi setColor yellow)!" +
										"(space setDim 500 500)!" +
										"(space.robi translate 250 250)!" +
										"(space.robi setDim 200 200)!" + 
										"(space setColor white)!" +
										"(space add hello (label new \"Ceci est un texte\"))!"+
										"(space.hello setColor red)!"+
										"(space.hello translate 200 200)!"+
										"(space add pif (image new logo.png))!" +
										"(space.pif translate 50 50)!"+
										"(space del robi)!"+
										"(space del pif)!"+
										"(space del hello)!" +
										"(space setDim 120 120)"
										;
							
				
					
				String[] testCommande = commandes.split("!");
					
					
				for(String command : testCommande)
				{
					
					LispParser parser = new LispParser(command);
					try {
						Expr e = parser.parseExpr();
						if (e instanceof ExprList) {
							ExprList compiled = (ExprList) e;
							System.out.println(">> "+ compiled.toString());
							new Interpreter().compute(environment, compiled);
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					
					Tools.sleep(400);
				}
		}

		public static void main(String[] args) {
			new Exercice4_3_0test();
		}

	}
	

