package src.States;

import java.awt.Graphics;

import graphics.Assets;
import graphics.MusicPlayer;
import graphics.AudioPlayer;
import java.awt.image.BufferedImage;

public class MenuState extends State{

    private Button start;
    private Button changeChar;
    private Button changeBack;

    private AudioPlayer Ost = new AudioPlayer(Assets.BackgroundMusic);
    private MusicPlayer musicPlayer = new MusicPlayer(Ost);
    private Thread musicThread = new Thread(musicPlayer);

    public MenuState(){

        ActionButton play = new ActionButton() {
    
            public void doAction(){
                musicPlayer.stop();
                State.ChangeState(new GameState());
            }
            
        };

        ActionButton selectChar = new ActionButton() {
            public void doAction(){
                State.ChangeState(new SelectCharacter());
            }   
        };

        ActionButton selectBack = new ActionButton() {
            public void doAction(){
                State.ChangeState(new SelectBackground());
            }   
        };


        start = new Button(Assets.buttonOut, Assets.buttonIn, 140, 250, 200, 50, "Jugar",play);
        changeChar = new Button(Assets.buttonOut, Assets.buttonIn, 140, 350, 200, 50, "Cambiar personaje",selectChar);
        changeBack = new Button(Assets.buttonOut, Assets.buttonIn, 140, 450, 200, 50, "Cambiar escenario",selectBack);
        musicThread.start();
    }

    @Override
    public void update() {
        start.update();
        changeChar.update();
        changeBack.update();
    }

    @Override
    public void draw(Graphics g) {
        //Socio lo extraño
        if(SelectBackground.back == null) g.drawImage(Assets.background0, 0, 0, 500, 600, null);
        else g.drawImage(SelectBackground.back, 0, 0, 500, 600, null);

        g.drawImage(Assets.tittle,50,-50,400,350,null);
        start.draw(g);
        changeChar.draw(g);
        changeBack.draw(g);
    }
    
}
