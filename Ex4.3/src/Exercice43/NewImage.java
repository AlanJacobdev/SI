package Exercice43;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import graphicLayer.GImage;
import jfkbits.ExprList;
import jfkbits.LispParser.Expr;

public class NewImage implements Command {

	// Méthode permettant de créer et afficher une nouvelle image

	@Override
	public Expr run(Reference receiver, ExprList method) {

		try {
			Image image = ImageIO.read(new File(method.get(2).toString()));
			GImage img = new GImage(image);
			Reference ref = new Reference(img);
			ref.addCommand("translate", new Translate());
			return ref;
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
