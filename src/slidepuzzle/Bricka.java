package slidepuzzle;

import javax.swing.*;
    public class Bricka extends JLabel{
    String[][] brickor;

    public Bricka() {
        int a = 1;
        brickor = new String[4][4];
        for (String[] strings : brickor) {
            for (String string : strings) {
                string = "" + ++a;
            }
        }
        
        
    }
        
        
}
