package src.Objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import src.math.Vector2D;

public class Platform extends gameObjects {
    
    private int type;

    public Platform(Vector2D position, BufferedImage texture,int type) {
        super(position, texture);
        this.type = type;
    }

    public int getType() {
        return type;
    }

    @Override
    public void update() {
        
    }

    @Override
    public void draw(Graphics g) {
        
    }
    
}
