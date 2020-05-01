package Exercice42;

import graphicLayer.GElement;
import graphicLayer.GSpace;
import jfkbits.ExprList;
import jfkbits.LispParser.Expr;

public class AddElement implements Command {


	Environment Element;


	public AddElement(Environment environment) {
		this.Element = environment;
	}


	@Override
	public Expr run(Reference receiver, ExprList method) {

		if (Element.getReferenceByName(method.get(2).getValue()) == null) {


			Object o = receiver.getReceiver();


			if (o instanceof GSpace) {


				GSpace space;
				Reference nr;
				Object o1;


				space = (GSpace) o;

				nr = (Reference) new Interpreter().compute(Element, (ExprList) method.get(3));

				o1 = nr.getReceiver();


				if (o1 != null && o1 instanceof GElement) {
					GElement e = (GElement) o1;
					Element.addReference(method.get(2).toString(), nr);
					space.addElement(e);
					space.repaint();
				}

			}
		}


		else {
			System.err.println("L'objet existe déja");
		}
		return receiver;
	}

}
