package me.bkkn.Minesweeper.view.window;

import me.bkkn.Minesweeper.view.panel.GamePanel;

import javax.swing.*;
import java.awt.*;

import static me.bkkn.Minesweeper.model.Game.model;

public class GameWindow extends JFrame {

    public GameWindow() {
        model.setGamePanel(new GamePanel());
        Container cont = getContentPane();
        cont.add(model.getGamePanel());
        setTitle("Да, это сапер на Java");
        setBounds(0, 0, 28 + model.getWidth() * 20, 50 + model.getWidth() * 20);
        setDefaultCloseOperation(3);
        setResizable(true);
        setVisible(true);
        setFocusable(true);
    }
}