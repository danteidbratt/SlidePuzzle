package slidepuzzle;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Bricka extends JLabel {
    Bricka[][] brickor;
    private int siffra = 0;

    public Bricka(int siffra) {
        this.siffra = siffra;
        setBasics();
    }

    private void setBasics() {
        this.setText(String.valueOf(this.siffra));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        setBackground(Color.RED);
        setOpaque(true);
    }
    
}
