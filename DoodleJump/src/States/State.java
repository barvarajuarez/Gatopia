package src.States;

import java.awt.Graphics;

public abstract class State {

    //Saber si estamos en el menu o en estado de juego
    private static State currentState = null;
    public static State getcurrentState(){return currentState;}
    public static void ChangeState(State newState){
        currentState = newState;
    }

    public abstract void update();
    public abstract void draw(Graphics g);
    
}
