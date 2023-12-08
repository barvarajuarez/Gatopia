package src.Input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//Saber que boton de el mouse presiono y sus coordenadas
//inicialmente se usa implements MouseInputListener pero no
//necesitamos todos sus métodos por lo tanto
//extend permite heredar los métodos
public class Mouse extends MouseAdapter{

    public static int mouseX,mouseY;
    public static boolean HLB; //hold left button

    public void mousePressed(MouseEvent e){
        if(e.getButton() == MouseEvent.BUTTON1){
            HLB = true;
        }
    }

    public void mouseReleased(MouseEvent e){
        if(e.getButton() == MouseEvent.BUTTON1){
            HLB = false;
        }
    }

    public void mouseDragged(MouseEvent e){
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public void mouseMoved(MouseEvent e){
        mouseX = e.getX();
        mouseY = e.getY();
    }
}
