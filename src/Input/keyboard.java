package src.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyboard implements KeyListener{
    private keyboard Keyboard;
    public static boolean right;
    public static boolean left;
    public keyboard(){
        this.right = false;
        this.left =false;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //cambiar el sprite para que gire
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.right = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.left = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.left = false;
        }
    }
}
