package Exercice44;

import java.lang.reflect.InvocationTargetException;

import graphicLayer.GElement;
import graphicLayer.GImage;
import graphicLayer.GOval;
import graphicLayer.GRect;
import graphicLayer.GString;
import jfkbits.ExprList;
import jfkbits.LispParser.Expr;

class NewElement implements Command {
	public Expr run(Reference reference, ExprList method) {
		try {
			@SuppressWarnings("unchecked")
			GElement e = ((Class<GElement>) reference.getReceiver()).getDeclaredConstructor().newInstance();
			Reference ref = new Reference(e);
			ref.addCommand("setColor", new SetColor());
			ref.addCommand("translate", new Translate());
			ref.addCommand("setDim", new SetDim());

			Environment environnement = new Environment();

			Reference rectClassRef = new Reference(GRect.class);
			Reference ovalClassRef = new Reference(GOval.class);
			Reference imageClassRef = new Reference(GImage.class);
			Reference stringClassRef = new Reference(GString.class);

			ref.addCommand("add", new AddElement(environnement));
			ref.addCommand("del", new DelElement(environnement));
			ref.addCommand("addScript", new AddScript());
			ref.addCommand("delScript", new DelScript());
			ref.addCommand("clear", new clear());
			ref.setEnvironment(environnement);

			rectClassRef.addCommand("new", new NewElement());
			ovalClassRef.addCommand("new", new NewElement());
			imageClassRef.addCommand("new", new NewImage());
			stringClassRef.addCommand("new", new NewString());

			environnement.addReference("rect", rectClassRef);
			environnement.addReference("oval", ovalClassRef);
			environnement.addReference("image", imageClassRef);
			environnement.addReference("label", stringClassRef);

			return ref;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
}