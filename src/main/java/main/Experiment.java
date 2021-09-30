package main;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

public class Experiment {

    List<Step> steps;
    ArrayList<DraggableObject> itemsToDraw;

    public Experiment() {
        this.itemsToDraw = new ArrayList<>();
    }

    public void draw(PApplet app) {
        
    }

    public void addItemToDraw(DraggableObject object) {
        System.out.println("2");
        this.itemsToDraw.add(object);
    }
    
}
