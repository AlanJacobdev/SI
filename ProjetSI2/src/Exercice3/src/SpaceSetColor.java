package Exercice3.src;


import graphicLayer.GSpace;
import tools.Tools;

public class SpaceSetColor implements Command  {
	
	
	GSpace space ;
	String couleur;
	
	
	public SpaceSetColor(GSpace space, String color) {
		super();
		this.space = space;
		this.couleur = color;
	}
	
	
	
	@Override
	public void run() {
		space.setColor(Tools.getColorByName(couleur));
	}
	
}
