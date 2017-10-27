package slidepuzzle;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Meny extends JPanel {

    int rader;
    int kollumner;
    String[] radArray = {"3", "4", "5", "6", "7", "8", "9"};
    String[] kolArray = {"3", "4", "5", "6", "7", "8", "9"};
    JPanel topPanel = new JPanel();
    JPanel midPanel = new JPanel();
    JPanel botPanel = new JPanel();
    JPanel radioPanel = new JPanel();
    ButtonGroup bg = new ButtonGroup();
    JRadioButton radio1 = new JRadioButton("");
    JRadioButton radio2 = new JRadioButton("");
    JRadioButton radio3 = new JRadioButton("");
    JRadioButton radio4 = new JRadioButton("");
    JLabel boxText1 = new JLabel("Rader");
    JLabel boxText2 = new JLabel("Kollumner");
    JComboBox combo1 = new JComboBox(radArray);
    JComboBox combo2 = new JComboBox(kolArray);
    JLabel empty1 = new JLabel("");
    JLabel empty2 = new JLabel("");
    JLabel empty3 = new JLabel("");
    JLabel empty4 = new JLabel("");
    JLabel empty5 = new JLabel("");
    JLabel empty6 = new JLabel("");
    JPanel textPanel = new JPanel();
    JLabel text1 = new JLabel("Nybörjare");
    JLabel text2 = new JLabel("Erfaren");
    JLabel text3 = new JLabel("Expert");
    JLabel text4 = new JLabel("Custom");
    JButton cancel = new JButton("Avsluta");

    public Meny(JButton shuffle) {
        setLayout(new GridLayout(3, 1));
        topPanel.setLayout(new BorderLayout());
        bg.add(radio1);
        bg.add(radio2);
        bg.add(radio3);
        bg.add(radio4);

        radio1.addActionListener((e) -> {
            midPanel.setVisible(false);
            rader = 3;
            kollumner = 3;
        });
        radio2.addActionListener((e) -> {
            midPanel.setVisible(false);
            rader = 4;
            kollumner = 4;
        });
        radio3.addActionListener((e) -> {
            midPanel.setVisible(false);
            rader = 5;
            kollumner = 5;
        });
        radio4.addActionListener((e) -> {
            midPanel.setVisible(true);
            combo1.setSelectedIndex(0);
            combo2.setSelectedIndex(0);
        });

        radioPanel.setLayout(new GridLayout(4, 1));
        radioPanel.add(radio1);
        radioPanel.add(radio2);
        radioPanel.add(radio3);
        radioPanel.add(radio4);
        topPanel.add(radioPanel, BorderLayout.WEST);

        textPanel.setLayout(new GridLayout(4, 1));
        textPanel.add(text1);
        textPanel.add(text2);
        textPanel.add(text3);
        textPanel.add(text4);
        topPanel.add(textPanel, BorderLayout.CENTER);

        combo1.addActionListener((e) -> {
            rader = Integer.parseInt((String) combo1.getSelectedItem());
        });
        combo2.addActionListener((e) -> {
            kollumner = Integer.parseInt((String) combo2.getSelectedItem());
        });

        midPanel.setLayout(new GridLayout(4, 2));
        boxText1.setHorizontalAlignment(SwingConstants.CENTER);
        boxText1.setVerticalAlignment(SwingConstants.BOTTOM);
        boxText2.setHorizontalAlignment(SwingConstants.CENTER);
        boxText2.setVerticalAlignment(SwingConstants.BOTTOM);
        midPanel.setVisible(false);

        midPanel.add(boxText1);
        midPanel.add(boxText2);
        midPanel.add(combo1);
        midPanel.add(combo2);
        midPanel.add(empty1);
        midPanel.add(empty2);
        midPanel.add(empty3);
        midPanel.add(empty4);

        botPanel.setLayout(new GridLayout(2, 1));
        botPanel.add(shuffle);
        botPanel.add(cancel);

        add(topPanel);
        add(midPanel);
        add(botPanel);
        setPreferredSize(new Dimension(200, 0));

        cancel.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });
    }

    public int getRader() {
        return rader;
    }

    public int getKollumner() {
        return kollumner;
    }
}
