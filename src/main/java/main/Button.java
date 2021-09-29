package main;
import processing.core.PApplet;
import processing.core.PImage;

public class Button {

    float x;
    float y;
    float width;
    float height;
    PImage img;
    String textLabel;

    public Button(int x, int y, int width, int height, PImage img, String textLabel) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.img = img;
        this.textLabel = textLabel;
    }

    public void draw(PApplet app) {
        app.image(this.img, this.x, this.y, this.width, this.height);
        app.textSize(16);
        app.fill(0, 0, 0);
        if (!(this.textLabel == null)) {
            app.text(this.textLabel, this.x + 30 - textLabel.length(), this.y + this.height + 30);
        }
    }
    
}
