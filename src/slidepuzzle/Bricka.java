package slidepuzzle;

import java.awt.Color;
import java.awt.Font;
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
        setFont(new Font("SansSerif", Font.BOLD, 30));
        setForeground(Color.BLACK);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        setBackground(Color.PINK);
        setOpaque(true);
    }

}
