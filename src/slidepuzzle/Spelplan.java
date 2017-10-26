package slidepuzzle;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

public class Spelplan extends JPanel {


    Bricka[][] brickor;
    int xLength;
    int yLength;

    public Spelplan(int rows, int cols) {
        brickor = new Bricka[rows][cols];
        xLength = cols;
        yLength = rows;
        setBasics();
    }
    
    private void setBasics(){
        setSize(400, 400);
        setLayout(new GridLayout(yLength, xLength, 5, 5));
        setBackground(Color.BLACK);
        
        int a = 1;
        
        for (Bricka[] rad : brickor) {
            for (Bricka bricka : rad) {
                add(bricka = new Bricka(a++));
            }
        }
        System.out.println(brickor[0][0].getText());
    }
    
    
    
    
    
    
    static void shuffle() {
        
    }
}
