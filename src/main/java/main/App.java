package main;

import processing.core.PApplet;
import processing.core.PImage;
import main.Button;

public class App extends PApplet {

    Button freecoliButton;
    Button heatshockButton;
    Button electroButton;
    Incubator incubatorButton;
    Menu startMenu;
    Lab lab;
    PImage freecoliTube;
    PImage heatshockTube;
    PImage electroTube;
    PImage incubator;
    PImage freecoli;
    boolean inLab = false;
    String experimentType;
    DraggableObject freecoliDraggable;

    /**
     * Setup non-image based objects
     */
    public App() {
        // this.handler = new MidiHandler();
        
        
    }

    /**
     * Change the window settings
     */
    public void settings() {
        // Don't touch
        size(1200, 800);
        
    }

    /**
     * Setup the app frame rate and create objects 
     * that need images associated with them
     * The objects created are all buttons, the cursor, 
     * the blocks on the grid, and the background
     */
    public void setup() {
        // set frame rate
        frameRate(60);
        

        freecoliTube = loadImage("src/main/resources/freecoli.png");
        heatshockTube = loadImage("src/main/resources/heatshock.png");
        electroTube = loadImage("src/main/resources/electro.png");
        incubator = loadImage("src/main/resources/incubator.png");
        freecoli = loadImage("src/main/resources/freecolitube.png");
        freecoliDraggable = new DraggableObject(freecoli, 800, 830, 100, 150);
        incubatorButton = new Incubator(900, 100, 200, 250, incubator, null, freecoliDraggable);
        freecoliButton = new Button(300, 250, 100, 300, freecoliTube, "Free Coli");
        heatshockButton = new Button(550, 250, 100, 300, heatshockTube, "Heat Shock");
        electroButton = new Button(800, 250, 100, 300, electroTube, "Electroporation");
        

        // this.startButton = new Button(500, 365, 200, 70, "Start");
        startMenu = new Menu(freecoliButton, heatshockButton, electroButton);

        startMenu.draw(this);

    }

    /**
     * Draw the current state of the game objects
     */
    public void draw() {
        if (inLab == true) {
            lab.draw(this);
        }
        
    }
    
    /**
     * Method is called when the mouse is pressed by the user
     * Passes current App instance to ClickHandler object which checks
     * which buttons have been pressed
     */
    public void mousePressed() { 

        if (mouseX >= 300 && mouseX <= 400 && mouseY >= 250 && mouseY <= 550) {
            inLab = true;
            experimentType = "freecoli";
            this.lab = new Lab(experimentType, incubatorButton);
        } else if (mouseX >= 550 && mouseY <= 650 && mouseY >= 250 && mouseY <= 550) {
            inLab = true;
            experimentType = "electrocoli";
            this.lab = new Lab(experimentType, incubatorButton);
        } else if (mouseX >= 800 && mouseY <= 900 && mouseY >= 250 && mouseY <= 550) {
            inLab = true;
            experimentType = "heatcoli";
            this.lab = new Lab(experimentType, incubatorButton);
        }

        
        
    }

    public static void main(String[] args) {
        // Don't touch this
        PApplet.main("main.App");
    }
}