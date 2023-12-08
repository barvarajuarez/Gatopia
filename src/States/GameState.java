package src.States;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.util.Random;

import graphics.Assets;
import graphics.MusicPlayer;
import graphics.AudioPlayer;
import src.Objects.Doodle;
import src.Objects.Platform;
import src.math.Vector2D;

//lógica de el juego
public class GameState extends State {
    //Sere la gata bajo la lluviaaaaaaaaaaaaaa
    private int h = 300;
    private int limit = 200;
    private int N_platform = 6;
    private Platform[] platforms; 
    public static int score;

    private Doodle doodle;

    private AudioPlayer Jump = new AudioPlayer(Assets.Jump);
    private AudioPlayer Ost = new AudioPlayer(Assets.GameplayMusic);
    private AudioPlayer die = new AudioPlayer(Assets.Falling);

    private MusicPlayer musicPlayer = new MusicPlayer(Ost);
    private Thread musicThread = new Thread(musicPlayer);

    public GameState(){
        score = 0;
        if(SelectCharacter.player == null)  doodle = new Doodle(new Vector2D(100,100),Assets.doodle);
        else doodle = new Doodle(new Vector2D(100,100),SelectCharacter.player);

        platforms = new Platform[15];

        Random random = new Random();
        double x,y;
        
        for (int i = 0; i < 15; i++) {
            x =  random.nextInt(500);// Posición x aleatoria dentro de un rango
            y =  random.nextInt(600);
            
              // Posición y aleatoria dentro de un rango
            if(random.nextInt(15) < 3) platforms[i] = new Platform(new Vector2D(x,y),Assets.platform,2);
            else platforms[i] = new Platform(new Vector2D(x,y),Assets.platform,1);
        }

        if(score == 0) platforms[0].setPosition(new Vector2D(100d,400d));
        Ost.setVolume(0.2);
        musicThread.start();
    }


    public void addScore(int high){
        score += high;//hopes
    }


    @Override
    public void update() {
        //cada 200 puntos aumentan las plataformas
        doodle.update();

        if (doodle.getPosition().getY() < h) {
            for (int i = 0; i < N_platform; i++) {
                // Restaurar la posición del Doodle a la altura h
                doodle.getPosition().setY(h);

                // Mover la plataforma hacia arriba
                
                platforms[i].getPosition().setY(platforms[i].getPosition().getY() - (int) doodle.getDy());

                // Verificar si la plataforma ha salido de la pantalla y reiniciar su posición
                if (platforms[i].getPosition().getY() > 600) {
                    platforms[i].getPosition().setY(0); 
                    platforms[i].getPosition().setX(new Random().nextInt(400));
                }
            }
        }

        for (int i = 0; i < N_platform; i++) {
            // Verificar si el Doodle colisiona con la plataforma actual
            if (checkCollision(doodle, platforms[i])) {
                if(platforms[i].getType()==1){
                    addScore(10);
                    // Lógica de colisión con la plataforma
                    Jump.Play(0);
                    doodle.setDy(-7);
                }else{
                    addScore(15);
                    Jump.Play(0);//boing
                    doodle.setDy(-12);
                }
                
            }
        }

        if(score >= limit){
            N_platform += 1;
            limit += 200;
            if(score >= 1800){
                N_platform = N_platform;
            }
        }


        if (doodle.getPosition().getY() > 600) {
            //detener el hilo de la musica
            musicPlayer.stop();
            die.setVolume(0.3d);
            //AHHHHHHH D:
            die.Play(0);
            State.ChangeState(new GameOver());
        }
    }

    private boolean checkCollision(Doodle doodle, Platform platformPosition) {
        // Lógica de colisión
        return doodle.getPosition().getX() < platformPosition.getPosition().getX() + 50 && doodle.getPosition().getX() + 50 > platformPosition.getPosition().getX() &&
        doodle.getPosition().getY() < platformPosition.getPosition().getY()  &&
        doodle.getPosition().getY() + 70 > platformPosition.getPosition().getY() && doodle.getDy() > 0;
    }

    @Override
    public void draw(Graphics g){
        if(SelectBackground.back == null) g.drawImage(Assets.background0, 0, 0, 500, 600, null);
        else g.drawImage(SelectBackground.back, 0, 0, 500, 600, null);
        doodle.draw(g);

        for (int i = 0; i < N_platform; i++) {
            if(platforms[i].getType() == 1)
            g.drawImage(Assets.platform,(int)platforms[i].getPosition().getX(),(int)platforms[i].getPosition().getY(),50,20,null);
            else g.drawImage(Assets.platform2,(int)platforms[i].getPosition().getX(),(int)platforms[i].getPosition().getY(),50,50,null); 
        }

        drawScore(g);
    }

    private void drawScore(Graphics g){
        Vector2D position = new Vector2D(400,25); 
        String toString = Integer.toString(score);
        //son las 3 de la mañana y estoy en tu ventana 
        for(int i = 0; i < toString.length(); i++){
            g.drawImage(Assets.bango[Integer.parseInt(toString.substring(i, i+1))],(int) position.getX() ,(int)position.getY(),20,20, null);
            position.setX(position.getX()+20);
        }
    }

}
