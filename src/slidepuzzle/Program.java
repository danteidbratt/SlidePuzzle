package slidepuzzle;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

    public class Program extends JFrame{
        Spelplan spelplan;
        Meny meny;
        
    public Program(){
        setVisible(true);
        setSize(400,400);
        setLocationRelativeTo(null);


        spelplan = new Spelplan(4,4);
        meny = new Meny();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
    }
     
    public void Komponenter(){
        add(spelplan, BorderLayout.CENTER);
        add(meny, BorderLayout.SOUTH);
    }
        
}
