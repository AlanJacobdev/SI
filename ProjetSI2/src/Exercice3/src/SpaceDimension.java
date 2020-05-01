package Exercice3.src;

import java.awt.Dimension;

import graphicLayer.GSpace;

public class SpaceDimension implements Command {

	
	GSpace space;
	int width;
	int height;

	
	public SpaceDimension(GSpace space, Integer width, Integer height) {
		super();
		this.space = space;
		this.width = width;
		this.height = height;
	}
	
	
	@Override
	public void run() {
	
		Dimension Dim = new Dimension(width, height);
	
		space.changeWindowSize(Dim);
	}


}
