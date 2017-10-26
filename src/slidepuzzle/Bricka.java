package slidepuzzle;

import java.awt.Color;
import javax.swing.*;

public class Bricka extends JLabel {
    
    private final int siffra;

    public Bricka(int siffra) {
        this.siffra = siffra;
        setLayout();
    }
    
    private void setLayout(){
        if(siffra == 16){
            this.setText("");
            this.setBackground(Color.BLACK);
            this.setOpaque(true);
        }
        else{
            this.setText(String.valueOf(this.siffra));
            setBackground(Color.red);
            setOpaque(true);
        }
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }
}