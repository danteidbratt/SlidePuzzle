package slidepuzzle;

import java.awt.Color;
import javax.swing.*;

public class Bricka extends JLabel {
    
    private int siffra = 0;

    public Bricka(int siffra) {
        this.siffra = siffra;
        setBasics();
    }
    
    private void setBasics(){
        this.setText(String.valueOf(this.siffra));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        setBackground(Color.RED);
        setOpaque(true);
    }
    
}