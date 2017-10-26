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
        brickor = new Bricka[yLength + 2][xLength + 2];

        setSize(400, 400);
        setLayout(new GridLayout(yLength, xLength, 5, 5));
        setBackground(Color.BLACK);

        int a = 1;

        for (int i = 1; i < brickor.length - 1; i++) {
            for (int j = 1; j < brickor[i].length - 1; j++) {
                add(brickor[i][j] = new Bricka(a++));
            }

        }
    }

    static void shuffle() {

    }
}
