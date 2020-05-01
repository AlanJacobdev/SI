package Exercice44;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import graphicLayer.GGif;
import graphicLayer.GImage;
import jfkbits.ExprList;
import jfkbits.LispParser.Expr;

public class NewImage implements Command {


	@Override
	public Expr run(Reference receiver, ExprList method) {

		
		
		if(method.get(2).toString().endsWith(".gif")) {
            URL url = null;
            try {
                url = new File(method.get(2).toString()).toURI().toURL();
            } catch (MalformedURLException e) {
                System.out.println("Erreur : " + e);
            }
            Image image = new ImageIcon(url).getImage();
            GGif img = new GGif(image);
            
            Reference ref = new Reference(img);
            
            ref.addCommand("translate", new Translate());
            ref.addCommand("addscript", new AddScript());
            ref.addCommand("delscript", new DelScript());
            
            return ref;
        } else {
        	
        
			try {
				Image image = ImageIO.read(new File(method.get(2).toString()));
				GImage img = new GImage(image);
				Reference ref = new Reference(img);
				ref.addCommand("translate", new Translate());
				ref.addCommand("addScript", new AddScript());
				ref.addCommand("delScript", new DelScript());
				return ref;
			}
	
			catch (IOException e) {
				e.printStackTrace();
			}
        }

		return null;
	}
}
