package me.bkkn.Minesweeper.view.panel;

import me.bkkn.Minesweeper.controller.menu.OnOkBtnListner;

import java.awt.Color;
import java.awt.Font;;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import static me.bkkn.Minesweeper.model.Game.model;

public class MenuPanel extends JPanel {

    private MenuPanel onpan;
    private JLabel shir;
    private JLabel vis;
    private JLabel mins;
    private JButton Ready;
    private JButton exit;
    private JTextArea shirtext;
    private JTextArea vistext;
    private JTextArea mintext;

    public MenuPanel() {
        setLayout(null);
        Font btnFont = new Font("serif", 0, 20);
        Font labFont = new Font("arial", 0, 20);
        vis = new JLabel("Высота");
        vis.setForeground(Color.BLACK);
        vis.setFont(labFont);
        vis.setBounds(10, 10, 130, 50);
        add(vis);
        shir = new JLabel("Ширина");
        shir.setForeground(Color.BLACK);
        shir.setFont(labFont);
        shir.setBounds(150, 10, 130, 50);
        add(shir);
        mins = new JLabel("Кол-во мин");
        mins.setForeground(Color.BLACK);
        mins.setFont(labFont);
        mins.setBounds(290, 10, 130, 50);
        add(mins);
        vistext = new JTextArea();
        vistext.setFont(btnFont);
        vistext.setBounds(10, 50, 130, 30);
        vistext.setForeground(Color.BLACK);
        vistext.setBackground(Color.WHITE);
        add(vistext);
        shirtext = new JTextArea();
        shirtext.setFont(btnFont);
        shirtext.setBounds(150, 50, 130, 30);
        shirtext.setForeground(Color.BLACK);
        shirtext.setBackground(Color.WHITE);
        add(shirtext);
        mintext = new JTextArea();
        mintext.setFont(btnFont);
        mintext.setBounds(290, 50, 130, 30);
        mintext.setForeground(Color.BLACK);
        mintext.setBackground(Color.WHITE);
        add(mintext);
        Ready = new JButton("Готово");
        Ready.setForeground(Color.BLACK);
        Ready.setFont(labFont);
        Ready.setBounds(50, 100, 130, 30);
        Ready.addActionListener(new OnOkBtnListner(model, shirtext, vistext, mintext));
        add(Ready);
        exit = new JButton("Выход");
        exit.setForeground(Color.BLACK);
        exit.setFont(labFont);
        exit.setBounds(250, 100, 130, 30);
        exit.addActionListener(arg0 -> System.exit(0));
        add(exit);
    }
}
