package Exercice4.src;

import graphicLayer.GRect;
import jfkbits.ExprList;
import tools.Tools;

public class RobiColor implements Command{


	
	@Override
	public void run(Object receiver, ExprList method) {
		
		GRect robi = (GRect) receiver;
		robi.setColor(Tools.getColorByName(method.get(2).getValue()));
	}
	
}
