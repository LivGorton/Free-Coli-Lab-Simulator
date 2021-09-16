package main;

import processing.core.PApplet;

public class Menu {

    // Button startButton;
    Button freeColi;
    Button electroColi;
    Button heatshockColi;

    public Menu(Button freeColi, Button electroColi, Button heatsockColi) {
        this.freeColi = freeColi;
        this.electroColi = electroColi;
        this.heatshockColi = heatsockColi;
    }

    public void draw(PApplet app) {
        app.background(245, 242, 255);
        // this.startButton.draw(app);
        this.freeColi.draw(app);
        this.electroColi.draw(app);
        this.heatshockColi.draw(app);
    }
    
}
