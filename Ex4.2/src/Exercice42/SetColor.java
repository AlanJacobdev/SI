package Exercice42;

import java.awt.Color;

import graphicLayer.GElement;
import graphicLayer.GSpace;
import jfkbits.ExprList;
import jfkbits.LispParser.Expr;
import tools.Tools;

public class SetColor implements Command {


	@Override
	public Expr run(Reference receiver, ExprList method) {


		Object Recv = receiver.getReceiver();


		if (Recv instanceof GElement) {


			GElement element = (GElement) Recv;
			Color color = Tools.getColorByName(method.get(2).toString());


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
