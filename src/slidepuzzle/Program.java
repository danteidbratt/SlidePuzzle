package slidepuzzle;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Program extends JFrame {

    JButton newGame = new JButton("Nytt Spel");
    JButton shuffle = new JButton("Blanda");

    public Spelplan spelplan = new Spelplan(4, 4);
    public Meny meny = new Meny(newGame, shuffle);

    public void Komponenter() {
        setLayout(new BorderLayout());
        setTitle("SlidePuzzle");
        setVisible(true);
        setSize(490, 340);
        setLocationRelativeTo(null);

        add(spelplan, BorderLayout.CENTER);
        add(meny, BorderLayout.WEST);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        newGame.addActionListener((ActionEvent ae) -> {
            remove(spelplan);
            spelplan = new Spelplan(meny.getRader(), meny.getKollumner());
            setSize(meny.getKollumner() * 85 + 150, meny.getRader() * 85);
            setLocationRelativeTo(null);
            add(spelplan);
            revalidate();
            repaint();
        });
        shuffle.addActionListener((e) -> {
            spelplan.shuffle();
        });
    }
}