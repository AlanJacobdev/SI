package Exercice4.src;


import graphicLayer.GSpace;
import jfkbits.ExprList;
import tools.Tools;

public class SpaceSetColor implements Command  {
	

	@Override
	public void run(Object receiver, ExprList method) {
		
		GSpace space  = (GSpace) receiver;
		
		space.setColor(Tools.getColorByName(method.get(2).getValue()));
	}
	
}
