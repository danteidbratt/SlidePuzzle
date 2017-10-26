package slidepuzzle;

import java.awt.GridLayout;
import javax.swing.*;

public class Spelplan extends JPanel {
    
    Spelplan(int rows, int cols) {
        setSize(400,200);
        setLayout(new GridLayout(rows, cols));
    }

}
