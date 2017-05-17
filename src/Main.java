
import javax.swing.JFrame;

public class Main {


    public static void main(String[] args) {

        JFrame ob = new JFrame();
        Gameplay gameplay = new Gameplay();
        ob.setSize(1024, 576);
        ob.setLocationRelativeTo(null);
        ob.setResizable(false);
        ob.setVisible(true);
        ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ob.add(gameplay);
        
    }
    
}
