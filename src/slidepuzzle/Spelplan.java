package slidepuzzle;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

public class Spelplan extends JPanel {

    Bricka[][] brickor;

    Spelplan(int rows, int cols) {
        brickor = new Bricka[rows][cols];
        
        setSize(400, 400);
        setLayout(new GridLayout(rows, cols, 5, 5));
        setBackground(Color.BLACK);
        
        int a = 1;
        
        for (Bricka[] rad : brickor) {
            for (Bricka bricka : rad) {
                add(bricka = new Bricka(a++));
            }
        }
    }
}