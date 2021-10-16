package main;

import processing.core.PApplet;
import processing.core.PImage;

public class Pipette {

    int selectedAmount;
    Button increase;
    Button decrease;
    PImage pipette;
    Object firstSelectedObject;
    Object secondSelectedObject;
    boolean pipetteClicked;

    public Pipette(int selectedAmount, Button increase, Button decrease, PImage pipette) {
        this.selectedAmount = selectedAmount;
        this.increase = increase;
        this.decrease = decrease;
        this.pipette = pipette;
        this.firstSelectedObject = null;
        this.secondSelectedObject = null;
        this.pipetteClicked = false;
    }

    public void draw(PApplet app, Experiment experiment, Lab lab) {
        this.increase.draw(app);
        this.decrease.draw(app);
        app.image(this.pipette, 65, 300, 90, 170);
        app.textSize(20);
        app.text(Integer.toString(selectedAmount) + "um", 100, 500);
        if (pipetteClicked) {
            if (firstSelectedObject == null) {
                app.text("Click the item you'd like to pipette from", 75, 550);
            } else if (secondSelectedObject == null) {
                app.text("Click the item you'd like to pipette to", 75, 550);
            } else {
                this.pipetteClicked = false;
                // boolean valid = experiment.validatePipette(firstSelectedObject, secondSelectedObject);
                boolean end = experiment.isGameEndingPipette(firstSelectedObject, secondSelectedObject, this.selectedAmount);
                // System.out.println(end);
                if (end) {
                    lab.end = true;
                }
                
            }
        }
    }

    public void increasePipette() {
        this.selectedAmount++;
    }

    public void decreasePipette() {
        if (this.selectedAmount > 0) {
            this.selectedAmount--;
        }
    }

    public void clickPipette() {
        this.pipetteClicked = true;
    }

    public void validatePipette() {

    }
    
}
