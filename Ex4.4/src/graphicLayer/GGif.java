package graphicLayer;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.ImageObserver;

public class GGif extends GElement implements ImageObserver{
    Point position;
    Image rawImage;
    
    public GGif(Image image) {
        this.position = new Point(0,0);
        this.rawImage = image;
    }
    
    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y,
        int width, int height) {

        if (img != this.rawImage) {
            throw new RuntimeException("Wrong image in observer");
        }

        if ((infoflags & (ImageObserver.ERROR | ImageObserver.ABORT))
            != 0) {
            throw new RuntimeException("Error during image loading");
        }

        this.repaint();
        
        return (infoflags & ImageObserver.ALLBITS) == 0;

    }
    
    public Point getPosition() {
        return position;
    }
    
    public void setPosition(Point p) {
        position = p;
        repaint();        
    }
    
    public Image getRawImage() {
        return rawImage;
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(rawImage, getPosition().x, getPosition().y, this);    
    }

    @Override
    public void translate(Point gap) {
        Point p = getPosition();
        this.setPosition(new Point(p.x+gap.x, p.y+gap.y));
    }
}