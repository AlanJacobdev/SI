
package Exercice44;


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



public class Exercice4_4_0Test {
	// Une seule variable d'instance
	Environment environment = new Environment();

	public Exercice4_4_0Test() {
		GSpace space = new GSpace("Exercice 4", new Dimension(400, 400));
		space.open();

		Reference spaceRef = new Reference(space);
		Reference rectClassRef = new Reference(GRect.class);
		Reference ovalClassRef = new Reference(GOval.class);
		Reference imageClassRef = new Reference(GImage.class);
		Reference stringClassRef = new Reference(GString.class);

		Environment EnvironnementBase = new Environment();
		spaceRef.setEnvironment(EnvironnementBase);
		spaceRef.setParent(environment);
		spaceRef.setName("space");

		spaceRef.addCommand("setColor", new SetColor());
		spaceRef.addCommand("sleep", new Sleep());
		spaceRef.addCommand("setDim", new SetDim());

		spaceRef.addCommand("add", new AddElement(EnvironnementBase));
		spaceRef.addCommand("del", new DelElement(EnvironnementBase));
		spaceRef.addCommand("delScript", new DelScript());
		spaceRef.addCommand("addScript", new AddScript());
		spaceRef.addCommand("clear", new clear());

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
	
			
			System.out.println(" Test des Scripts ");
			
			//Liste des commandes à executer *
					String script = 
							
							"(space addScript resize ((self hauteur largeur)(self setDim hauteur largeur)))!" +
			                "(space resize 750 750)!" +
							
							"( space addScript addrect (( self name w y c )( self add name ( rect new ) )( self.name setColor c )( self.name setDim w y ) ) )!"+
							"( space addrect robi 500 600 LIGHT_GRAY )!"+

							"(space.robi addScript translate ((self y z)(self translate y z)))!" +
							"(space.robi translate 100 50)!" +
							
							"( space.robi addScript addOvalandTran (( self name w c y z)( self add name ( oval new ) )( self.name setColor c )( self.name setDim w w ) (self.name translate y z) ))!"+
							"( space.robi addOvalandTran momo 180 black 155 196)!"+

							"(space.robi addScript addimage((self name filename )(self add name (image new filename))))!" +
							"(space.robi addimage aj logo.png )!" +
							
							"(space.robi.aj addScript moveimg((self y z)(self translate y z)))!" +
			                "(space.robi.aj moveimg 170	210)!" +

			                "( space.robi addScript addlabel (( self name text )( self add name ( label new text ) ) ) )!"+
			                "( space.robi addlabel labelAlan \"Alan Jacob CDA \" )! " +

							"( space.robi.labelAlan addScript translatelabel (( self y z )( self translate y z) ) )!"+
							"( space.robi.labelAlan translatelabel 200 400 )!" +
					
							"( space.robi.labelAlan addScript changecolorlabel (( self c )( self setColor c) ) )!"+
							"( space.robi.labelAlan changecolorlabel red )!" +
							
							"( space addScript empty (( self tps )(self sleep tps) (self clear) ) )!"+
							"( space empty 510 )!"+
							
							"(space addScript addimageAndResize((self name filename y z )(self add name (image new filename))  (self setDim y z) ))!" +
							"(space addimageAndResize aj img.png 1200 599)!" +
							
							"(space addScript moveimg((self y z)(self translate y z)))!" +
			                "(space moveimg 10 10)!"+ 
							
							"( space addScript addOvalandTran (( self name w x c y z)( self add name ( oval new ) )( self.name setDim w x )( self.name setColor c ) (self.name translate y z) ))!"+
							"( space addOvalandTran bulle1 5 5 white 640 220)!"+

							"( space addOvalandTran bulle2 15 15 white 655 205)!"+

							"( space addOvalandTran bulle3 25 25 white 680 180)!"+

							"( space addOvalandTran bulle4 35 35 white 710 140)!"+
			                
							"( space addOvalandTran bulle5 500 110 white 650 25)!" +
			                
							"(space addScript addimageAndMove((self name filename c y z )(self add name (image new filename))  (self.name translate y z) ( self.bulle5 setColor c ) ))!" +
							"(space addimageAndMove ex4 ex4.png my 700 50)!" +
							
							"( space addOvalandTran bulle6 5 5 white 540 240)!"+

							"( space addOvalandTran bulle7 15 15 white 515 225)!"+

							"( space addOvalandTran bulle8 25 25 white 480 210)!"+

							"( space addOvalandTran bulle9 35 35 white 430 190)!"+
			                
							"( space addOvalandTran bulle10 200 200 white 250 20)!" +
							
							"(space addScript addgif ((self name filename y z )(self add name (image new filename))  (self.name translate y z)  ))!" +
							"(space addgif gifpepe pepe.gif 280 60)";
			                
			                
				String[] testScript = script.split("!");
					
					
				for(String scripts : testScript)
				{
					
					LispParser parser = new LispParser(scripts);
					try {
						Expr e = parser.parseExpr();
						if (e instanceof ExprList) {
							ExprList compiled = (ExprList) e;
							new Interpreter().compute(environment, compiled);
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					
					Tools.sleep(400);
				}
	}

	
	
	public static void main(String[] args) {
		new Exercice4_4_0Test();
	}

}