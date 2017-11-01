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

    public Spelplan(int rows, int cols) {
        xLength = cols;
        yLength = rows;
        setBasics();
    }

    private void setBasics() {
        brickor = new Bricka[yLength + 2][xLength + 2];
        setSize(340, 340);
        setLayout(new GridLayout(yLength, xLength, 5, 5));
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));

        for (Bricka[] rad : brickor) {
            for (int j = 0; j < rad.length; j++) {
                rad[j] = new Bricka();
            }
        }
        placeTiles();
    }

    private void placeTiles() {
        int a = 0;
        for (int i = 1; i < brickor.length - 1; i++) {
            for (int j = 1; j < brickor[i].length - 1; j++) {
                brickor[i][j].setText(String.valueOf(++a));
                if(i % 2 == 0){
                    if (j % 2 == 0) {
                        brickor[i][j].setPermanentColor(Color.WHITE);
//                        brickor[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
                    } else {
                        brickor[i][j].setPermanentColor(Color.GRAY);
//                        brickor[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                    }
                } else {
                    if (j % 2 == 1) {
                        brickor[i][j].setPermanentColor(Color.WHITE);
//                        brickor[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
                    } else {
                        brickor[i][j].setPermanentColor(Color.GRAY);
//                        brickor[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                    }
                }
                if ((j == brickor[i].length - 2) && (i == brickor.length - 2)) {
                    brickor[i][j].setBackground(Color.BLACK);
                    brickor[i][j].setText(String.valueOf(xLength*yLength));
                    brickor[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
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
                            updatePuzzle();
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

    public void shuffle() {
        int a = (int) Math.pow(yLength * xLength, 2);
        for (int i = 0; i <= a; i++) {
            while (!isMovable()) {
                this.clickedY = (int) (Math.random() * yLength + 1);
                this.clickedX = (int) (Math.random() * xLength + 1);
            }
            slide();
        }
        updatePuzzle();
    }

    private boolean isMovable() {
        return ((clickedX < emptyX || clickedX > emptyX) && (clickedY == emptyY))
                || ((clickedY < emptyY || clickedY > emptyY) && (clickedX == emptyX));
    }

    private void slide() {
        Bricka[] tempBrickor = new Bricka[Math.abs(clickedY-emptyY + clickedX-emptyX)];
        int direction = 1;
        int step = 1;
        
        if ((clickedY-emptyY + clickedX-emptyX) > 0) {
            direction = -1;
            step = -1;
        }
        
        int counter = 0;
        if (clickedX == emptyX) {
            for (int i = clickedY; i != emptyY;) {
                tempBrickor[counter] = brickor[i][emptyX];
                if (clickedY > emptyY)
                    i--;
                else
                    i++;
                counter++;
            }
        } else {
            for (int i = clickedX; i != emptyX;) {
                tempBrickor[counter] = brickor[emptyY][i];
                if (clickedX > emptyX)
                    i--;
                else
                    i++;
                counter++;
            }
        }
        
        brickor[clickedY][clickedX] = brickor[emptyY][emptyX];
        if (clickedX == emptyX) {
            for (Bricka b : tempBrickor) {
                brickor[clickedY+direction][emptyX] = b;
                direction += step;
            }
        } else {
            for (Bricka b : tempBrickor) {
                brickor[emptyY][clickedX+direction] = b;
                direction += step;
            }
        }
        emptyX = clickedX;
        emptyY = clickedY;
    }
    
    private void updatePuzzle() {
        removeAll();
        for (int i = 1; i < brickor.length - 1; i++) {
            for (int j = 1; j < brickor[i].length - 1; j++) {
                add(brickor[i][j]);
            }
        }
        revalidate();
        repaint();
    }

    private boolean isSolved() {
        int x = 0;
        for (int i = 1; i < brickor.length - 1; i++) {
            for (int j = 1; j < brickor[i].length - 1 ; j++) {
                if (!brickor[i][j].getText().equals(String.valueOf(++x)))
                    return false;
            }
        }
        return true;
    }
}