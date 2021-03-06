package main;

import java.util.ArrayList;
import processing.core.PApplet;

public class Lab {

    int timeMultiplier;
    int hoursPassed;
    String experimentType;
    Experiment experiment;
    Incubator incubator;
    Pipette pipette;
    boolean end;
    

    public Lab(String experimentType, Incubator incubator, Pipette pipette) {

        this.timeMultiplier = 1;
        this.hoursPassed = 0;
        this.experimentType = experimentType;
        this.initExperiment();
        this.incubator = incubator;
        this.pipette = pipette;
        this.end = false;

    }

    public void initExperiment() {
        if (this.experimentType == "freecoli") {
            this.experiment = new Freecoli();
        } else if (this.experimentType == "electrocoli") {

        } else if (this.experimentType == "heatcoli") {
            
        } 
    }



    public void draw(PApplet app) {
        app.background(255, 255, 255);
        if (this.end == false) {
            this.incubator.draw(app);
            this.pipette.draw(app, this.experiment, this);
            app.textSize(18);
            app.fill(230, 230, 230);
            app.rect(15, 15, 40, 40);
            app.rect(75, 15, 40, 40);
            app.rect(133, 15, 40, 40);
            app.fill(0, 0, 0);
            app.text("1x", 25, 40);
            app.text("2x", 85, 40);
            app.text("5x", 145, 40);
            app.textSize(20);
            app.text(Integer.toString(this.hoursPassed) + " Hours Passed", 205, 45);

            if (app.frameCount % 300 == 0) {
                this.hoursPassed += 1;
            }

            if (this.experimentType == "freecoli") {
                this.experiment.draw(app);
            }
        } else {
            app.textSize(42);
            app.text("You successfully transformed E. coli!", 250, 440);
        }

    }

    public void multiplierx1Click() {
        this.timeMultiplier = 1;
    }

    public void multiplierx2Click() {
        this.timeMultiplier = 2;
    }

    public void multiplierx5Click() {
        this.timeMultiplier = 5;
    }
    
}
