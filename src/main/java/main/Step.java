package main;

import processing.core.PImage;

public class Step {

    PImage asset;
    String stepType; // just in case steps involve more than just dragging something. I imagine clicking on something is a step (e.g. opening a fridge)
    // and then also moving something - can't currently see steps outside these two tyoes

    // for steps that involve moving stuff
    int finalX;
    int finalY;
    int moneyCost;
    int timeCost;
    
}
