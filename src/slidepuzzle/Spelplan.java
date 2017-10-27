package slidepuzzle;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Spelplan extends JPanel {

    Bricka[][] brickor;
    int xLength;
    int yLength;
    
    int xtom;
    int ytom;

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
        
        for (int i = 0; i < brickor.length; i++) {
            for (int j = 0; j < brickor.length; j++) {
                brickor[i][j] = new Bricka(0);
            }
        }

        int a = 1;
        for (int i = 1; i < brickor.length - 1; i++) {
            for (int j = 1; j < brickor[i].length - 1; j++) {
                brickor[i][j].setText(String.valueOf(a++));
                if(a-1== 16){
                    brickor[i][j].setBackground(Color.BLACK);
                    brickor[i][j].setText("");
                    xtom = j;
                    ytom = i;
                }
                brickor[i][j].addMouseListener(brickor[i][j].muslyss);
                
                add(brickor[i][j]);
            }

        }
    }

    static void shuffle() {

    }
    MouseAdapter Neigbhourlyss = new MouseAdapter(){
            
    };
}
