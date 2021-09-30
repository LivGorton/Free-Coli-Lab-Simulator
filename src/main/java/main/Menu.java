package main;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;


public class Menu {
    Button freeColi;
    Button electroColi;
    Button heatshockColi;
    PFont font;

    public Menu(Button freeColi, Button electroColi, Button heatsockColi, PFont font) {
        this.freeColi = freeColi;
        this.electroColi = electroColi;
        this.heatshockColi = heatsockColi;
        this.font = font;
    }

    public void draw(PApplet app) {
        app.background(245, 242, 255);
        this.freeColi.draw(app);
        this.electroColi.draw(app);
        this.heatshockColi.draw(app);

    }
    
}