package Exercice44;

import java.awt.Color;

import graphicLayer.GElement;
import graphicLayer.GSpace;
import jfkbits.ExprList;
import jfkbits.LispParser.Expr;
import tools.Tools;

public class SetColor implements Command {


	@Override
	public Expr run(Reference receiver, ExprList method) {

		Color MyGrey =  new Color(56, 59, 68); 
		Object Recv = receiver.getReceiver();

		if (Recv instanceof GElement) {


			GElement element = (GElement) Recv;
			Color color = null;
			
			if(method.get(2).toString().startsWith("my")) {
				
				color = MyGrey;
				
			}
			else
			{
				color = Tools.getColorByName(method.get(2).toString());
			}
			
			

			if (color != null) {
				element.setColor(color);
			}
		}


		else if (Recv instanceof GSpace) {


			GSpace space = (GSpace) Recv;
			Color color = Tools.getColorByName(method.get(2).toString());


			if (color != null) {
				space.setColor(color);
			}
		}

		return null;
	}

}
