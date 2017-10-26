package slidepuzzle;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.*;
import java.awt.GridLayout;
import javax.swing.*;

    public class Meny extends JPanel{
        JLabel menyn = new JLabel();
        JButton shuffle = new JButton("Blanda");
        JButton cancel = new JButton("Avsluta");

    public Meny() {
        setSize(400,200);
        setLayout(new BorderLayout());
        
        
        menyn.setLayout(new GridLayout(1, 2));
        menyn.add(shuffle);
        menyn.add(cancel);
        add(menyn, CENTER);
        
    }
        
        
        
}
