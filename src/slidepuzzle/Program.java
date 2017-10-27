package slidepuzzle;

import java.awt.BorderLayout;
import javax.swing.*;

public class Program extends JFrame{

    public static Spelplan spelplan = new Spelplan(4,4);
    public static Meny meny = new Meny();
        
    public void Komponenter(){
        setLayout(new BorderLayout());
        setVisible(true);
        
        setSize(600,400);
        setLocationRelativeTo(null);

        add(spelplan, BorderLayout.CENTER);
        add(meny, BorderLayout.WEST);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}