package main;

import processing.core.PApplet;
import processing.core.PImage;

public class DraggableObject {

    PImage assetImage;
    int startX;
    int endX;
    int startY;
    int endY;
    boolean beingDragged;

    public DraggableObject(PImage assetImage, int startX, int endX, int startY, int endY) {
        this.assetImage = assetImage;
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.beingDragged = false;
        // start X were item begin and end X where item should end - this is super sus so far may fix later
    }

    boolean beingClicked(int mouseX, int mouseY) {
        if (mouseX >= this.startX && mouseX <= this.startX + this.assetImage.width && mouseY >= this.startY && mouseY <= this.startY + this.assetImage.height) {
            return true;
        } else {
            return false;
        }
    }

    public void draw(PApplet app) {
        app.image(assetImage, startX, startY);
    }

    public void inIncubator(PApplet app, Incubator incubator) {
        app.image(this.assetImage, incubator.x, incubator.y);
        incubator.draw(app);
    }

    public void removeFromIncubator(PApplet app, DraggableObject object, Experiment experiment) {
        // System.out.println("1");
        // experiment.itemsToDraw.add(object);
        experiment.addItemToDraw(object);
       
        // app.image(this.assetImage, 800, 100);
    }

    
}
