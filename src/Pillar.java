
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Pillar {
    
    private int num1 = (int)(Math.random()*380);
    private int num2 = num1 + (int)(100 + Math.random()*40);
    int speed = 5;
     int pos = 1020;

    public void draw(Graphics g){
        
        g.setColor(Color.yellow);
        g.fillRect(pos, 0, 70, num1);

        g.fillRect(pos,num2 , 70, 520-num2);
        
        pos-=speed;
    }
    
    public Rectangle getTop(){
        return new Rectangle (pos, 0, 70, num1);
    }
    
    public Rectangle getBottom(){
        return new Rectangle (pos,num2 , 70, 520-num2);
    }
}
