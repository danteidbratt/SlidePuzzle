package slidepuzzle;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Meny extends JPanel{
    JButton shuffle = new JButton("Blanda");
    JButton cancel = new JButton("Avsluta");

    public Meny() {
        setSize(400,200);

        setLayout(new GridLayout(1, 2));
        add(shuffle);
        add(cancel);
        
        cancel.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });
        
        shuffle.addActionListener((ActionEvent ae) -> {
            Program.spelplan.shuffle(1000);
        });
    }
}
