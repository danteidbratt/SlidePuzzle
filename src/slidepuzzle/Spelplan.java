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
        xLength = cols;
        yLength = rows;
        setBasics();
    }

    private void setBasics() {
        brickor = new Bricka[yLength + 2][xLength + 2];

        setSize(400, 400);
        setLayout(new GridLayout(yLength, xLength, 5, 5));
        setBackground(Color.BLACK);

        for (int i = 0; i < brickor.length; i++) {
            for (int j = 0; j < brickor[i].length; j++) {
                brickor[i][j] = new Bricka();
            }
        }
        placeTiles();
    }

    public void placeTiles() {
        int a = 0;
        for (int i = 1; i < brickor.length - 1; i++) {
            for (int j = 1; j < brickor[i].length - 1; j++) {
                brickor[i][j].setText(String.valueOf(++a));
                if(i % 2 == 0){
                    if(j % 2 == 0)
                        brickor[i][j].setPermanentColor(Color.MAGENTA);
                    else
                        brickor[i][j].setPermanentColor(Color.GREEN);
                } else {
                    if(j % 2 == 1)
                        brickor[i][j].setPermanentColor(Color.MAGENTA);
                    else
                        brickor[i][j].setPermanentColor(Color.GREEN);
                }
                if ((j == brickor[i].length - 2) && (i == brickor.length - 2)) {
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
                            bricka.setBackground(bricka.getPermanentColor());
                        if (isMovable()) {
                            slide();
                            move();
                            if (isSolved()) {
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
        revalidate();
        repaint();
    }

    public void shuffle() {
        int a = (int) Math.pow(yLength * xLength * 1.5, 2);
        for (int i = 0; i <= a; i++) {
            while (!isMovable()) {
                this.clickedY = (int) (Math.random() * yLength + 1);
                this.clickedX = (int) (Math.random() * xLength + 1);
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
    }

    public boolean isSolved() {
        int x = 0;
        for (int i = 1; i < brickor.length - 1; i++) {
            for (int j = 1; j < brickor[i].length - 1; j++) {
                if (!brickor[i][j].getText().equals(String.valueOf(++x))) {
                    return false;
                }
                if (x > xLength * yLength - 2) {
                    return true;
                }
            }
        }
        return false;
    }
}