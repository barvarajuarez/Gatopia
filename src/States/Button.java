package src.States;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import graphics.Assets;

import java.awt.color.*;

import src.Input.Mouse;
import src.math.Vector2D;

public class Button {
    private BufferedImage mouseOutImg;
    private BufferedImage mouseInImg;
    private boolean mouseIn;
    private Rectangle boundingBox;
    private String text;
    private ActionButton action;


    public Button(BufferedImage mouseOutImage, BufferedImage mouseInImage, int x, int y, int width, int height, String text, ActionButton action) {
        boundingBox = new Rectangle(x, y, width, height);
        mouseOutImg = mouseOutImage;
        mouseInImg = mouseInImage;
        this.text = text;
        this.action = action;
    }

    public void update(){
        //retorna verdadero si las coordenadas estan dentro de la caja
        if(boundingBox.contains(Mouse.mouseX,Mouse.mouseY)){
            mouseIn = true;
        }else{
            mouseIn = false;
        }
        //accion de el boton
        if(mouseIn && Mouse.HLB){
            action.doAction();
        }
    }
    
    public void draw(Graphics g) {
        if (mouseIn) {
            g.drawImage(mouseInImg, boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height, null);
        } else {
            g.drawImage(mouseOutImg, boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height, null);
        }
    
        g.setFont(new Font("Consolas", Font.BOLD, 20));
        g.setColor(Color.BLACK);
    
        int textX = boundingBox.x + (boundingBox.width - g.getFontMetrics().stringWidth(text)) / 2;
        int textY = boundingBox.y + (boundingBox.height + g.getFontMetrics().getHeight()) / 2;
    
        g.drawString(text, textX, textY);
    }
}
