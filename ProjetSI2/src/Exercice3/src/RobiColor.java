package Exercice3.src;

import graphicLayer.GRect;
import tools.Tools;

public class RobiColor implements Command{

	GRect robi;
	String Couleur;
	
	
	public RobiColor(GRect robi, String couleur) {
		super();
		this.robi = robi;
		Couleur = couleur;
	}
	
	
	
	@Override
	public void run() {
		robi.setColor(Tools.getColorByName(Couleur));
	}
	
}
