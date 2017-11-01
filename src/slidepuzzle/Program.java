package slidepuzzle;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Program extends JFrame {

    private final JButton newGame = new JButton("Nytt Spel");
    private final JButton shuffle = new JButton("Blanda");
    private final JButton cancel = new JButton("Avsluta");

    private Spelplan spelplan = new Spelplan(4, 4);
    private final Meny meny = new Meny(newGame, shuffle, cancel);

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
        cancel.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });
    }
}