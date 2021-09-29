package main;

import processing.core.PImage;

public class Incubator  extends Button {

    DraggableObject storedObject;

    public Incubator(int x, int y, int width, int height, PImage img, String textLabel, DraggableObject object) {
        super(x,  y,  width,  height,  img,  textLabel);
        this.storedObject = object;
    }

    public void onClick() {

        if (this.storedObject != null) {
            // draw stored object
        } 

    }
    
}
