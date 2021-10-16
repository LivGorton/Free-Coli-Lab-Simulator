package main;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

public class Freecoli extends Experiment {
    
    public Freecoli() {
        // this.steps = steps;
        // this.incubator = incubator;
        super();
        
    }

    public void setup() {

    }

    // @Override
    // public boolean isGameEndingPipette(Object o1, Object o2) {
       
    // }

    

    public void draw(PApplet app) {
        if (this.itemsToDraw.size() > 0) {
            for (DraggableObject o : this.itemsToDraw) {
                o.draw(app);
            }
        }
        if (this.staticItems.size() > 0) {
            for (StaticObject o : this.staticItems) {
                o.draw(app);
            }
        }
    }
}
