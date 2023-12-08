package src.Objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import src.math.Vector2D;

public abstract class gameObjects {
    protected BufferedImage texture;
    protected Vector2D position;

    // Constructor corregido
    public gameObjects(Vector2D position, BufferedImage texture) {
        this.position = position;
        this.texture = texture;
    }

    // Métodos abstractos
    public abstract void update();
    public abstract void draw(Graphics g);

    // Métodos de acceso
    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }
}
