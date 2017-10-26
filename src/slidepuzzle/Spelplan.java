package slidepuzzle;

import java.awt.GridLayout;
import javax.swing.*;

public class Spelplan extends JPanel {

    String[][] bricka;

    Spelplan(int rows, int cols) {
        setSize(400, 200);
        setLayout(new GridLayout(rows, cols));

        int a = 1;
        bricka = new String[4][4];
        for (String[] strings : bricka) {
            for (String string : strings) {
                string = "" + ++a;
            }
        }
    }
}