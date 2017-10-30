package slidepuzzle;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class Bricka extends JLabel {
    
    private Color permanentColor;

    public Bricka() {
        setBasics();
    }

    private void setBasics() {
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        setFont(new Font("SansSerif", Font.BOLD, 30));
        setForeground(Color.BLACK);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        setOpaque(true);
    }
    
    public void setPermanentColor(Color permanentColor){
        this.setBackground(permanentColor);
        this.permanentColor = permanentColor;
    }
    
    public Color getPermanentColor(){
        return permanentColor;
    }
}