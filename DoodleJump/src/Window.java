package src;

import graphics.*;
import src.Input.Mouse;
import src.Input.keyboard;
import src.States.GameState;
import src.States.MenuState;
import src.States.State;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;

public class Window extends JFrame implements Runnable {

    public static final int WIDTH = 500, HEIGHT = 600;
    private Canvas canvas;
    private Thread thread;
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    private GameState gameState;
    private keyboard Keyboard;
    private Mouse mouse;


    public Window(){
        setTitle("Doodle Jump");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        canvas = new Canvas();
        Keyboard = new keyboard();
        mouse = new Mouse();

        canvas.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        canvas.setMaximumSize(new Dimension(WIDTH,HEIGHT));
        canvas.setMinimumSize(new Dimension(WIDTH,HEIGHT));

        add(canvas);
        canvas.addKeyListener(Keyboard);
        canvas.addMouseListener(mouse);
        canvas.addMouseMotionListener(mouse);
        setVisible(true);
    }

    public static void main(String[] args){
        //INICIA EL THEAD
        new Window().start();
    }
//Inicializa todos los recursos necesarios
    private void init(){
        //carga todos los recursos
        Assets.init();
        State.ChangeState(new MenuState());
    }

    private void update(){
        //Actualiza siempre el estado actual
        State.getcurrentState().update();
    }

    private void draw(){
        bs = canvas.getBufferStrategy();

        if(bs == null){
            canvas.createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();
        //dibujo---------------------------------//
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        //Dibuja el estado actual
        State.getcurrentState().draw(g);
        //---------------------------------//
        g.dispose();
        bs.show();
    }

    public void run(){
        init();
        //actualiza la posición de todos los objetos de el juego y dibuja todo
        try {
            while (running) {
                update();
                draw();
                Thread.sleep(1000 / 60);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    private void stop(){
        try{
            thread.join();
            running = false;
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

