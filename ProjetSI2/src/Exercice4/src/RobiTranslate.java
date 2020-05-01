package Exercice4.src;

import java.awt.Point;

import graphicLayer.GRect;
import jfkbits.ExprList;

public class RobiTranslate implements Command {

	
	@Override
	public void run(Object receiver, ExprList method) {
		
		GRect robi = (GRect) receiver;
		Integer x = Integer.parseInt(method.get(2).getValue());
		Integer y= Integer.parseInt(method.get(3).getValue());
		
		robi.translate(new Point(x, y));
		
	}

}
