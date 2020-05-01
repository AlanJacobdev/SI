package Exercice42;

import tools.Tools;

public class Test {


	
	
	public  void launch() 
	{
		//Liste des commandes à executer *
		String commandes = "(space add robi (rect new))!"+
				"(space setColor red)!" + 
				"(robi translate 50 50)!" + 
				"(robi setColor yellow)!" +
				"(space setDim 500 500)!" +
				"(robi translate 250 250)!" +
				"(robi setDim 200 200)!" + 
				"(space setColor white)!" +
				"(space add hello (label new \"Ceci est un texte\"))!"+
				"(hello setColor red)!"+
				"(hello translate 200 200)!"+
				"(space add pif (image new logo.png))!" +
				"(pif translate 50 50)!"+
				"(space del robi)!"+
				"(space del pif)!"+
				"(space del hello)!" +
				"(space setDim 120 120)"
				;
				
		
		
		String[] testCommande = commandes.split("!");
		
		
		
		
		Exercice4_2_0 exo = new Exercice4_2_0();
		
		
		for(String command : testCommande)
		{
			exo.runScript(command);
			Tools.sleep(400);
		}
		
		
	}
	
	public static void main(String[] args) {
		new Test().launch();
	}
	
	
}
