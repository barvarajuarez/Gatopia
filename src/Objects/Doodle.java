package src.Objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import graphics.Assets;
import src.Input.keyboard;
import src.math.Vector2D;

public class Doodle extends gameObjects {
    boolean facingRight; 
    private double dy;

    public Doodle(Vector2D position, BufferedImage texture) {
        super(position, texture);
        this.dy = 0;
    }

    public void setDy(double dy){
        this.dy = dy;
    }

    public double getDy(){return this.dy;}

    @Override
    public void update() {
        if (keyboard.right) {
            facingRight = true;
            position.setX(position.getX() + 3d);
        } else if (keyboard.left) {
            facingRight = false;
            position.setX(position.getX() - 3d);
        }
        dy += 0.08;
        setDy(dy);
        position.setY(position.getY() + dy);
        // Verificar si el objeto está fuera del límite derecho
        if (position.getX() > 500) {
            position.setX(0);  // Cambiar al otro lado
        } else if (position.getX() < 0) {
        position.setX(500);  // Cambiar al otro lado
}
    }


    @Override
    public void draw(Graphics g) {
        if (facingRight) {
            // Invertir horizontalmente la imagen de doodle
            g.drawImage(texture, (int)getPosition().getX()+75 ,(int)getPosition().getY(), -75, 75, null);
        } else {
            // Dibujar la imagen de doodle normalmente
            g.drawImage(texture, (int)getPosition().getX() ,(int)getPosition().getY(), 75, 75, null);
        }
    }
}
