package slidepuzzle;

import java.awt.BorderLayout;
import javax.swing.*;

    public class Program extends JFrame{
        Spelplan spelplan = new Spelplan(4,4);
        Meny meny = new Meny();
        
    public void Komponenter(){
        setLayout(new BorderLayout());
        setVisible(true);
        
        setSize(400,400);
        setLocationRelativeTo(null);

        add(spelplan, BorderLayout.CENTER);
        add(meny, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}