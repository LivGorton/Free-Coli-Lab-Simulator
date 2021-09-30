package main;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PImage;


public class Title {

    // Button startButton;
    Button startButton;
    PFont font;
    PImage logo;

    public Title(Button startButton, PImage logo, PFont font) {
        this.startButton = startButton;
        this.font = font;
        this.logo = logo;
    }

    public void draw(PApplet app) {
        app.background(245, 242, 255);
        // this.startButton.draw(app);
        app.textFont(this.font,70);
        app.image(this.logo, 40,100, this.logo.width*2, this.logo.height*2);                  
        app.fill(0);  
        app.textAlign(PConstants.CENTER);
        app.text("FreeColi",app.width/2 + 300,app.height/2 -200); 
        app.textFont(this.font,25);
        app.text("A natural transformation lab simulator", app.width/2 + 300, app.height/2 - 150);
        app.textAlign(PConstants.LEFT);
        this.startButton.draw(app);
        
}



    
}