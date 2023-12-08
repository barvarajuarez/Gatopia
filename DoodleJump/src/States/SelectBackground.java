package src.States;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;

import graphics.AudioPlayer;
import graphics.Assets;

public class SelectBackground extends State {

    private Button background1;
    private Button background2;
    private Button background3;
    private Button background4;
    public static BufferedImage back;

    private AudioPlayer select = new AudioPlayer(Assets.select);

    public SelectBackground() {

        ActionButton back0 = new ActionButton() {
            public void doAction() {
                back = Assets.background0;
                select.Play(0);
                State.ChangeState(new MenuState());

            }
        };

        ActionButton back1 = new ActionButton() {
            public void doAction() {
                back = Assets.background3;
                select.Play(0);
                State.ChangeState(new MenuState());
            }
        };

        ActionButton back2 = new ActionButton() {
            public void doAction() {
                back = Assets.background2;
                select.Play(0);
                State.ChangeState(new MenuState());
            }
        };

        ActionButton back3 = new ActionButton() {
            public void doAction() {
                back = Assets.background1;
                select.Play(0);
                State.ChangeState(new MenuState());
            }
        };

        background1 = new Button(Assets.buttonOut, Assets.buttonIn, 380, 230, 70, 70, "Fondo1", back0);
        background2 = new Button(Assets.buttonOut, Assets.buttonIn, 40, 480, 70, 70, "Fondo4", back3);
        background3 = new Button(Assets.buttonOut, Assets.buttonIn, 380, 480, 70, 70, "Fondo3", back2);
        background4 = new Button(Assets.buttonOut, Assets.buttonIn, 40, 230, 70, 70, "Fondo2", back1);
    }

    @Override
    public void update() {
        background1.update();
        background2.update();
        background3.update();
        background4.update();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 500, 600);
        //f1 250 370 // f2 40 250// f3 350 450 // f4 40 450
        g.drawImage(Assets.background0, 250, 0, 250, 300, null);
        g.drawImage(Assets.background1, 0, 300, 250, 300, null);
        g.drawImage(Assets.background2, 250, 300, 250, 300, null);
        g.drawImage(Assets.background3, 0, 0, 250, 300, null);
        
        background1.draw(g);
        background2.draw(g);
        background3.draw(g);
        background4.draw(g);
    }
}