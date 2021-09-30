package main;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

public class Freecoli extends Experiment {

    List<Step> steps;
    

    public Freecoli() {
        // this.steps = steps;
        // this.incubator = incubator;
        super();
    }

    public void setup() {

    }

    

    public void draw(PApplet app) {
        if (this.itemsToDraw.size() > 0) {
            for (DraggableObject o : this.itemsToDraw) {
                o.draw(app);
            }
        }
    }
}
