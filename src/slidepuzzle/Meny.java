package slidepuzzle;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Meny extends JPanel{
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
    JComboBox combo1 = new JComboBox();
    JComboBox combo2 = new JComboBox();
    JPanel textPanel = new JPanel();
    JLabel text1 = new JLabel("Nybörjare         ");
    JLabel text2 = new JLabel("Erfaren");
    JLabel text3 = new JLabel("Expert");
    JLabel text4 = new JLabel("Custom");
    JButton shuffle = new JButton("Blanda");
    JButton cancel = new JButton("Avsluta");

    public Meny() {
        setLayout(new GridLayout(3, 1));
        topPanel.setLayout(new BorderLayout());
        bg.add(radio1);
        bg.add(radio2);
        bg.add(radio3);
        bg.add(radio4);
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
        
        
        midPanel.setLayout(new GridLayout(3, 2));
        boxText1.setHorizontalAlignment(SwingConstants.CENTER);
        boxText1.setVerticalAlignment(SwingConstants.BOTTOM);
        boxText2.setHorizontalAlignment(SwingConstants.CENTER);
        boxText2.setVerticalAlignment(SwingConstants.BOTTOM);
        midPanel.setVisible(false);
        
        midPanel.add(boxText1);
        midPanel.add(boxText2);
        midPanel.add(combo1);
        midPanel.add(combo2);
        
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
        
        shuffle.addActionListener((ActionEvent ae) -> {
            Program.spelplan.shuffle();
        });
    }
}
