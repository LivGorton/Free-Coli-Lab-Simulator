package main;

import processing.core.PApplet;
import processing.core.PImage;

public class StaticObject {

    String textLabel;
    PImage image;
    int width;
    int height;
    int x;
    int y;

    public StaticObject(String textLabel, PImage image, int width, int height, int x, int y) {
        this.textLabel = textLabel;
        this.image = image;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public void draw(PApplet app) {
        app.image(this.image, this.x, this.y, this.width, this.height);
        app.text(this.textLabel, this.x + 10, this.y + this.height + 15);
    }

    boolean beingClicked(int mouseX, int mouseY) {
        if (mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y && mouseY <= this.y + this.height) {
            return true;
        } else {
            return false;
        }
    }
    
}
