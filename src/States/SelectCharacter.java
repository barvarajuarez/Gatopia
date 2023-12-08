package src.States;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import graphics.AudioPlayer;
import graphics.Assets;

public class SelectCharacter extends State {

    private Button character1;
    private Button character2;
    public static BufferedImage player;

    private AudioPlayer select = new AudioPlayer(Assets.select);

    public SelectCharacter() {

        ActionButton char1 = new ActionButton() {
            public void doAction() {
                player = Assets.doodle;
                select.setVolume(0.9d);
                select.Play(0);
                State.ChangeState(new MenuState());
            }
        };

        ActionButton char2 = new ActionButton() {
            public void doAction() {
                player = Assets.doodle2;
                select.Play(0);
                State.ChangeState(new MenuState());
            }
        };

        character1 = new Button(Assets.buttonOut, Assets.buttonIn, 300, 450, 150, 50, "Mauzanamiau", char1);
        character2 = new Button(Assets.buttonOut, Assets.buttonIn, 40, 450, 150, 50, "Mangomiche", char2);
    }

    @Override
    public void update() {
        character1.update();
        character2.update();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(Assets.CharacterSelect,0,0,500,600,null);
        g.drawImage(Assets.doodle2,30,260,200,200,null);
        g.drawImage(Assets.doodle,300,300,150,150,null);

        character1.draw(g);
        character2.draw(g);
    }
}
