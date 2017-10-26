package slidepuzzle;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;

public class Bricka extends JLabel {
    
    private final int siffra;

    public Bricka(int siffra) {
        this.siffra = siffra;
        this.setText(String.valueOf(this.siffra));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        setBackground(Color.red);
        setOpaque(true);
    }
}