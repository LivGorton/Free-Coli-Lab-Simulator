package main;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PFont;
import main.Button;

public class App extends PApplet {

    Button freecoliButton;
    Button heatshockButton;
    Button electroButton;
    Button startButton;
    Title startTitle;
    Incubator incubatorButton;
    Menu startMenu;
    Lab lab;
    PImage freecoliTube;
    PImage heatshockTube;
    PImage electroTube;
    PImage incubator;
    PImage freecoli;
    PImage start;
    PImage logo;
    PImage pipetteImg;
    PImage increasePipette;
    PImage decreasePipette;
    PImage dnaTube;
    Button increasePipetteButton;
    Button decreasePipetteButton;
    PFont font;
    boolean inLab = false;
    String experimentType;
    DraggableObject freecoliDraggable;
    StaticObject dnaTubObject;
    Pipette pipette;
    boolean selectMenu = false;
    boolean startMenuDisplay = true;

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
        logo = loadImage("src/main/resources/logo.png");
        start = loadImage("src/main/resources/startbutton.png");

        pipetteImg = loadImage("src/main/resources/pipette_mono.png");   
        increasePipette = loadImage("src/main/resources/plusbutton.png");
        decreasePipette = loadImage("src/main/resources/minusbutton.png");
        increasePipetteButton = new Button(160, 350, 20, 20, increasePipette, null);
        decreasePipetteButton = new Button(40, 350, 20, 20, decreasePipette, null);
        pipette = new Pipette(0, increasePipetteButton, decreasePipetteButton, pipetteImg);

        dnaTube = loadImage("src/main/resources/dnatube.png");
        dnaTubObject = new StaticObject("DNA", dnaTube, 70, 100, 1100, 670);

        freecoliDraggable = new DraggableObject(freecoli, 750, 772, 100, 137);
        incubatorButton = new Incubator(900, 100, 200, 250, incubator, null, freecoliDraggable);
        freecoliButton = new Button(300, 250, 100, 300, freecoliTube, "Free Coli");
        heatshockButton = new Button(550, 250, 100, 300, heatshockTube, "Heat Shock");
        electroButton = new Button(800, 250, 100, 300, electroTube, "Electroporation");
        startButton = new Button(this.width/2 + 280,this.height/2 -100, 60,60, start, " ");
        font = createFont("Comfortaa", 20);

        // this.startButton = new Button(500, 365, 200, 70, "Start");
        startTitle = new Title(startButton, logo, font);
        startTitle.draw(this);


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
        if (mouseX >= this.width/2 + 240 && mouseX <= this.width/2 + 320 && mouseY <= this.height/2 -60 && mouseY >= this.height/2 -140 && inLab == false){
            startMenu = new Menu(freecoliButton, heatshockButton, electroButton, font);
            startMenu.draw(this);
            selectMenu = true;
        } else if (mouseX >= 300 && mouseX <= 400 && mouseY >= 250 && mouseY <= 550 && inLab == false && selectMenu) {
            inLab = true;
            experimentType = "freecoli";
            this.lab = new Lab(experimentType, incubatorButton, pipette);
            this.lab.experiment.gameEndingPippeteAmount = 5;
            this.lab.experiment.staticItems.add(dnaTubObject);
            this.lab.experiment.gameEndingPippete.add(dnaTubObject);
            this.lab.experiment.gameEndingPippete.add(freecoliDraggable);
            // print(this.lab.experiment.staticItems);
            this.lab.incubator.putInIncubator(freecoliDraggable, this);
        } else if (mouseX >= 550 && mouseY <= 650 && mouseY >= 250 && mouseY <= 550 && inLab == false && selectMenu) {
            inLab = true;
            experimentType = "electrocoli";
            this.lab = new Lab(experimentType, incubatorButton, pipette);
        } else if (mouseX >= 800 && mouseY <= 900 && mouseY >= 250 && mouseY <= 550 && inLab == false && selectMenu) {
            inLab = true;
            experimentType = "heatcoli";
            this.lab = new Lab(experimentType, incubatorButton, pipette);
        } else if (mouseX >= 900 && mouseX <= 1100 && mouseY >= 200 && mouseY <= 350 && inLab == true) { // if incubator clicked
            this.lab.incubator.click(this, this.lab.experiment);
        } else if (mouseX >= 40 && mouseX <= 60 && mouseY >= 350 && mouseY <= 370 && inLab) {
            this.pipette.decreasePipette();
        } else if (mouseX >= 160 && mouseX <= 180 && mouseY >= 350 && mouseY <= 370 && inLab) {
            this.pipette.increasePipette();
        } 
        else if (mouseX >= 65 && mouseX <= 155 && mouseY >= 300 && mouseY <= 470 && inLab) {
            this.pipette.clickPipette();
        } 
        else if (inLab) {
            if (this.pipette.pipetteClicked) {
                for (int i = 0; i < this.lab.experiment.itemsToDraw.size(); i++) {
                    if (this.lab.experiment.itemsToDraw.get(i).beingClicked(mouseX, mouseY)) {
                        if (this.pipette.firstSelectedObject == null) {
                            this.pipette.firstSelectedObject = this.lab.experiment.itemsToDraw.get(i);
                        } else if (this.pipette.secondSelectedObject == null) {
                            this.pipette.secondSelectedObject = this.lab.experiment.itemsToDraw.get(i);
                        } else {
                            this.pipette.firstSelectedObject = null;
                            this.pipette.secondSelectedObject = null;
                        }
                    }
                }
               
                for (int i = 0; i < this.lab.experiment.staticItems.size(); i++) {

                    if (this.lab.experiment.staticItems.get(i).beingClicked(mouseX, mouseY)) {
                        if (this.pipette.firstSelectedObject == null) {
                            this.pipette.firstSelectedObject = this.lab.experiment.staticItems.get(i);
                        } else if (this.pipette.secondSelectedObject == null) {
                            this.pipette.secondSelectedObject = this.lab.experiment.staticItems.get(i);
                        } else {
                            this.pipette.firstSelectedObject = null;
                            this.pipette.secondSelectedObject = null;
                        }
                    }
                }
            }
            for (int i = 0; i < this.lab.experiment.itemsToDraw.size(); i++) {
                if (this.lab.experiment.itemsToDraw.get(i).beingClicked(mouseX, mouseY)) {
                    this.lab.experiment.itemsToDraw.get(i).beingDragged = true;  
                }
                
            }
        }
            
    }

    public void mouseDragged() {
        if (inLab) {
            
            for (int i = 0; i < this.lab.experiment.itemsToDraw.size(); i++) {
                
                if (this.lab.experiment.itemsToDraw.get(i).beingDragged) {
                    float deltaX = mouseX - pmouseX;
                    float deltaY = mouseY - pmouseY;
                    this.lab.experiment.itemsToDraw.get(i).startX += Math.round(deltaX);
                    this.lab.experiment.itemsToDraw.get(i).startY += Math.round(deltaY);
                }
            }
        }
    }

    public void mouseReleased() {
        if (inLab) {
            for (int i = 0; i < this.lab.experiment.itemsToDraw.size(); i++) {
                this.lab.experiment.itemsToDraw.get(i).beingDragged = false;
            }
        }
    }

    public static void main(String[] args) {
        // Don't touch this
        PApplet.main("main.App");
    }
}