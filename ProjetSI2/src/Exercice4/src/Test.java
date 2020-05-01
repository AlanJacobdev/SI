package Exercice4.src;

import tools.Tools;

public class Test {


	
	
	public  void launch() 
	{
		//Liste des commandes à executer *
		String commandes = "(space sleep 1000)!"+
				"(space setColor red)!" + 
				"(robi translate 50 50)!" + 
				"(robi setColor yellow)!" +
				"(robi translate -10 -10)!"+
				"(space setColor black)";
				
		
		
		String[] testCommande = commandes.split("!");
		
		
		
		
		Exercice_4_0 exo = new Exercice_4_0();
		
		
		for(String command : testCommande)
		{
			exo.runScript(command);
			Tools.sleep(500);
		}
		
		
	}
	
	public static void main(String[] args) {
		new Test().launch();
	}
	
	
}
