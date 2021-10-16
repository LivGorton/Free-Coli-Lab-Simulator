package main;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

public class Experiment {

    List<Step> steps;
    ArrayList<DraggableObject> itemsToDraw;
    ArrayList<StaticObject> staticItems;
    ArrayList<ArrayList<Object>> validPipettes;
    List<Object> gameEndingPippete;
    int gameEndingPippeteAmount;
    

    public Experiment() {
        this.itemsToDraw = new ArrayList<>();
        this.gameEndingPippete = new ArrayList<>();
        this.staticItems = new ArrayList<>();
        this.gameEndingPippeteAmount = 0;
    }

    public void draw(PApplet app) {
        
    }

    public void addItemToDraw(DraggableObject object) {
        this.itemsToDraw.add(object);
    }

    public boolean validatePipette(Object o1, Object o2) {
        for (int i = 0; i < validPipettes.size(); i++) {
            if (o1 == validPipettes.get(i).get(0) && o2 == validPipettes.get(i).get(1)) {
                return true;
            }
        }

        return false;
    }

    public boolean isGameEndingPipette(Object o1, Object o2, int amount) {
        // System.out.println(gameEndingPippete.get(0));
        // System.out.println(gameEndingPippete.get(1));
        // System.out.println(o1);
        // System.out.println(o2);
        // System.out.println(gameEndingPippete);
        // System.out.println(o1 == gameEndingPippete.get(0));
        // System.out.println();
        if (o1 == gameEndingPippete.get(0) && o2 == gameEndingPippete.get(1) && amount == gameEndingPippeteAmount) { 
            return true;
        }
        return false;
    }

    
}
