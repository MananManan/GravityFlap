
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Gameplay extends JPanel implements ActionListener,KeyListener {
//1024 x 576
    boolean play = false;
    boolean flip = false;
    private int score = 0;
    ArrayList<Pillar> abc = new ArrayList();
    private int playerPositionX = 200;
    private int playerPositionY = 520;
    private int initialPos = 200;
    private int speed = 0;
    private int acc = -1;
    private int t = 0;
    Timer time;
    Gameplay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        time = new Timer(20,this);
        abc.add(new Pillar());
        time.start();
    }
    
    @Override
    public void paint(Graphics g){
        
        Rectangle my = new Rectangle (playerPositionX,playerPositionY,20,20);
           
        
        
        g.setColor(Color.black);
        g.fillRect(0, 0, 1024, 576);
        
        for(Pillar e : abc){
            e.draw(g);
        }
        
        g.setColor(Color.white);
        g.fillRect(playerPositionX, playerPositionY, 20, 20);
        
        g.setColor(Color.green);
        g.setFont(new Font("serif", Font.BOLD, 30));
        g.drawString("Score : " + score, 880, 20);
        
        if(my.intersects(abc.get(0).getTop())|| my.intersects(abc.get(0).getBottom())){
            play = false;
            time.stop();
            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("GAME OVER. Press R to Restart", 500, 200);
        }
        
        g.dispose();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(play){
            t++;
            playerPositionY = initialPos - (speed*t + acc*t*t);
            if(playerPositionY >= 500) playerPositionY = 500;
            else if (playerPositionY <= 0) {
                playerPositionY = 0;
            }
           // playerPositionX += 2;
            if(playerPositionX >= 1000){
                playerPositionX = 1000;
            }
            
            if(abc.get(0).pos == 240){
               abc.add(new Pillar());
            }
            
            if(abc.get(0).pos == 125){
                score++;
            }
            
           for(Pillar e : abc){
               if(e.pos <= -70){
                   abc.remove(e);
               }
           }
           
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_J){
           // if((flip && playerPositionY == 0) || (!flip && playerPositionY == 500)){
                play = true;
                if(!flip)speed = 15;
                else speed = -15;
                initialPos = playerPositionY;
                t = 0;
           // }
        }
        if(ke.getKeyCode() == KeyEvent.VK_F){
            play = true;
            flip = !flip;
            acc *= -1;
            if(flip) speed = -10;
            else speed = 10;
            t = 0;
            initialPos = playerPositionY;
        }
        
        if(!play && ke.getKeyCode() == KeyEvent.VK_R){
            time = new Timer(20,this);
            abc.clear();
            abc.add(new Pillar());
            play = true;
            flip = false;
            score = 0;
            playerPositionX = 200;
            playerPositionY = 520;
            initialPos = 200;
            speed = 0;
            acc = -1;
            t = 0;
            time.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    
    }
    
}
