package src.math;

public class Vector2D {

    private double x,y;

    public Vector2D(double x,double y){
        this.x = x;
        this.y = y;
    }
   //Sobrecarga de metodos
    public Vector2D(){
        x = 0;
        y = 0;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setY(double y){
        this.y = y;
    }

    public void setX(double x){
        this.x = x;
    }

}
