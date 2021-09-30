package main;

import processing.core.PApplet;
import processing.core.PImage;

public class Incubator extends Button {

    DraggableObject storedObject;

    public Incubator(int x, int y, int width, int height, PImage img, String textLabel, DraggableObject object) {
        super(x,  y,  width,  height,  img,  textLabel);
        this.storedObject = object;
    }

    public void onClick(PApplet app) {

        if (!(this.storedObject == null)) { // if there is a stored object
            this.storedObject.draw(app);
        } 

    }

    public void putInIncubator(DraggableObject object, PApplet app) {
        this.storedObject = object;
        this.storedObject.inIncubator(app, this);
    }

    public void click(PApplet app, Experiment experiment) {
        if (!(this.storedObject == null)) {
            this.storedObject.removeFromIncubator(app, this.storedObject, experiment);
            this.storedObject = null;
        }
    }
    
}
