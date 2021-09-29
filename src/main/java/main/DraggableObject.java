package main;

import processing.core.PApplet;
import processing.core.PImage;

public class DraggableObject {

    PImage assetImage;
    int startX;
    int endX;
    int startY;
    int endY;

    public DraggableObject(PImage assetImage, int startX, int endX, int startY, int endY) {
        this.assetImage = assetImage;
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
    }

    boolean beingClicked(int mouseX, int mouseY) {
        if (mouseX >= this.startX && mouseX <= this.endX && mouseY >= this.startY && mouseY <= this.endY) {
            return true;
        }

        return false;
    }

    public void draw(PApplet app) {
        app.image(assetImage, startX, startY);
    }

    
}
