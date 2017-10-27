package slidepuzzle;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Spelplan extends JPanel {

    int clickedX;
    int clickedY;
    int emptyX;
    int emptyY;

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

    private void setBasics() {
        brickor = new Bricka[yLength + 2][xLength + 2];

        setSize(400, 400);
        setLayout(new GridLayout(yLength, xLength, 5, 5));
        setBackground(Color.BLACK);
        
        for (Bricka[] brickor1 : brickor) {
            for (int j = 0; j < brickor.length; j++) {
                brickor1[j] = new Bricka(0);
            }
        }
        placeTiles();
    }

    public void placeTiles() {
        int a = 0;
        for (int i = 1; i < brickor.length - 1; i++) {
            for (int j = 1; j < brickor[i].length - 1; j++) {
                brickor[i][j].setText(String.valueOf(++a));
                if (a == 16) {
                    brickor[i][j].setBackground(Color.BLACK);
                    brickor[i][j].setText("");
                    emptyY = i;
                    emptyX = j;
                } else {
                    brickor[i][j].addMouseListener(ma);
                }
                add(brickor[i][j]);
            }
        }
    }
    
    
    MouseAdapter ma = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
        }
        
        @Override
        public void mousePressed(MouseEvent e) {
            for (int i = 1; i < brickor.length - 1; i++) {
                for (int j = 1; j < brickor[i].length - 1; j++) {
                    if (e.getSource() == brickor[i][j]) {
                        brickor[i][j].setBackground(Color.YELLOW);
                        clickedY = i;
                        clickedX = j;
                    }
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {

            for (Bricka[] brickas : brickor) {
                for (Bricka bricka : brickas) {
                    if (e.getSource() == bricka) {
                        bricka.setBackground(Color.RED);
                        if (isMovable()) {
                            slide();
                            move();
                            if(isSolved()){
                                JOptionPane.showMessageDialog(null, "Du vann!");
                            }
                            return;
                        }
                    }
                }
            }
        }
    };

    public void move() {
        removeAll();
        for (int i = 1; i < brickor.length - 1; i++) {
            for (int j = 1; j < brickor[i].length - 1; j++) {
                add(brickor[i][j]);
            }
        }
    }

    public void shuffle(int a) {
        for (int i = 0; i <= a; i++) {
            while (!isMovable()) {
                this.clickedY = (int) (Math.random() * 4 + 1);
                this.clickedX = (int) (Math.random() * 4 + 1);
            }
                slide();
                move();
        }
    }

    public boolean isMovable() {
        return ((clickedX == emptyX + 1 || clickedX == emptyX - 1) && (clickedY == emptyY))
                || ((clickedY == emptyY + 1 || clickedY == emptyY - 1) && (clickedX == emptyX));
    }

    public void slide() {
        Bricka tempBricka;
        tempBricka = brickor[clickedY][clickedX];
        brickor[clickedY][clickedX] = brickor[emptyY][emptyX];
        brickor[emptyY][emptyX] = tempBricka;
        emptyX = clickedX;
        emptyY = clickedY;
        revalidate();
        repaint();
    }
    
    public boolean isSolved(){
        int x = 0;
        for (int i = 1; i < brickor.length - 1; i++) {
            for (int j = 1; j < brickor[i].length - 1; j++) {
                if(!brickor[i][j].getText().equals(String.valueOf(++x)))
                    return false;
                if(x > 14)
                    return true;
            }
        }
        return false;
    }
}
