package src.States;

import java.awt.image.BufferedImage;
import java.util.Random;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import graphics.Assets;
import graphics.AudioPlayer;
import src.Objects.Doodle;
import src.Objects.Platform;
import src.math.Vector2D;

public class GameOver extends State {

    private Button Restart;
    private Button MainMenu;
    private Doodle doodleDeath;

    public GameOver() {

        if(SelectCharacter.player == null)  doodleDeath = new Doodle(new Vector2D(250,0),Assets.doodle);
        else doodleDeath = new Doodle(new Vector2D(250,20),SelectCharacter.player);

        ActionButton restart = new ActionButton() {
            public void doAction() {
                State.ChangeState(new GameState());
            }
        };

        ActionButton mainMenu = new ActionButton() {
            public void doAction() {
                State.ChangeState(new MenuState());
            }
        };

        Restart = new Button(Assets.buttonOut, Assets.buttonIn, 300, 450, 170, 50, "Reiniciar", restart);
        MainMenu = new Button(Assets.buttonOut, Assets.buttonIn, 40, 450, 170, 50, "Menu Principal", mainMenu);
    }

    @Override
    public void update() {
        Restart.update();
        MainMenu.update();
        doodleDeath.update();
    }

    @Override
    public void draw(Graphics g) {
        if(SelectBackground.back == null) g.drawImage(Assets.background0, 0, 0, 500, 600, null);
        else g.drawImage(SelectBackground.back, 0, 0, 500, 600, null);

        doodleDeath.draw(g);
        Restart.draw(g);
        MainMenu.draw(g);

        drawScore(g);
    }

    private void drawScore(Graphics g){
        Vector2D position = new Vector2D(125,100); 
        String toString = Integer.toString(GameState.score);

        String mensaje = "Tu puntuacion fue:";
        g.setColor(Color.WHITE);
    // Establecer la tipografía del texto (por ejemplo, Arial con estilo negrita y tamaño 14)
        Font font = new Font("Sans", Font.BOLD, 25);
        g.setFont(font);

        g.drawString(mensaje, (int) position.getX(), (int) position.getY());

        position.setY(position.getY() + 20);
        position.setX(position.getX() + 90);

        for(int i = 0; i < toString.length(); i++){
            g.drawImage(Assets.bango[Integer.parseInt(toString.substring(i, i+1))],(int) position.getX() ,(int)position.getY(),20,20, null);
            position.setX(position.getX()+20);
        }
    }

}