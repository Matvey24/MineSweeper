package me.bkkn.Minesweeper.controller.menu;

import me.bkkn.Minesweeper.model.Model;
import me.bkkn.Minesweeper.view.window.GameWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnOkBtnListner implements ActionListener {

    private JTextArea shirtext;
    private JTextArea vistext;
    private JTextArea mintext;
    private Model model;

    public OnOkBtnListner(Model model, JTextArea shirtext, JTextArea vistext, JTextArea mintext) {
        this.model = model;
        this.shirtext = shirtext;
        this.vistext = vistext;
        this.mintext = mintext;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            model.setWidth(  Integer.parseInt(vistext.getText()) );
            model.setHeight( Integer.parseInt(shirtext.getText()) );
            model.setMines(  Integer.parseInt(mintext.getText()) );
        } catch (Exception e) {
            model.setWidth(5);
            model.setHeight(5);
            model.setMines(5);
        }

        model.setGameWindow(new GameWindow());
    }
}
