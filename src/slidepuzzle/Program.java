package slidepuzzle;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Program extends JFrame {

    JButton shuffle = new JButton("Nytt Spel");

    public Spelplan spelplan = new Spelplan(4, 4);
    public Meny meny = new Meny(shuffle);

    public void Komponenter() {
        setLayout(new BorderLayout());
        setVisible(true);
        setTitle("SlidePuzzle");
        setSize(600, 400);
        setLocationRelativeTo(null);

        add(spelplan, BorderLayout.CENTER);
        add(meny, BorderLayout.WEST);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        shuffle.addActionListener((ActionEvent ae) -> {
            remove(spelplan);
            spelplan = new Spelplan(meny.getRader(), meny.getKollumner());
            setSize(meny.getKollumner() * 100 + 200, meny.getRader() * 100);
            setLocationRelativeTo(null);
            add(spelplan);
            revalidate();
            repaint();
            spelplan.shuffle();
        });
    }
}