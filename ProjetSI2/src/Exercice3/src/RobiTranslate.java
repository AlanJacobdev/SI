package Exercice3.src;

import java.awt.Point;

import graphicLayer.GRect;

public class RobiTranslate implements Command {

	GRect robi;
	int x;
	int y;
	
	
	public RobiTranslate(GRect robi, int x, int y) {
		super();
		this.robi = robi;
		this.x = x;
		this.y = y;
	}

	
	@Override
	public void run() {
	
		robi.translate(new Point(x,y));

	}

}
