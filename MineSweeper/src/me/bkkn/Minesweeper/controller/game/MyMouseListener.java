package me.bkkn.Minesweeper.controller.game;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import static me.bkkn.Minesweeper.model.Game.model;

public class MyMouseListener implements MouseListener{
    public MyMouseListener() {
    }

    public void mouseClicked(MouseEvent e) {
        if (!model.in) {
            model.in = true;
            model.generateField((e.getY() - 10) / 20, (e.getX() - 10) / 20);
        }
        if (model.getField()[0][((e.getY() - 10) / 20)][((e.getX() - 10) / 20)] == -1) {
            model.vin = 2;
        }
        model.getField()[1][((e.getY() - 10) / 20)][((e.getX() - 10) / 20)] = 1;
        model.updateField(model.getWidth(), model.getHeight());
        int iter = 0;
        for (int i = 0; i < iter; i++) {
            for (int j = 0; j < model.getHeight(); j++) {
                if (model.getField()[0][i][j] == -1) iter++;
                if ((model.getField()[1][i][j] == 0) && (model.getField()[0][i][j] != -1)) iter--;
            }
        }
        if (iter == model.getMines())
            model.vin = 1;
        if (model.vin == 0) {
            model.getGamePanel().repaint();
        } else if ((!model.endg) && (model.vin == 2)) {
            model.endg = true;
            for (int i = 0; i < iter; i++) {
                for (int j = 0; j < model.getHeight(); j++) {
                    if (model.getField()[0][i][j] == -1)
                        model.getField()[1][i][j] = 1;
                }
            }
            model.getGamePanel().repaint();
        }
        if ((model.vin == 1) && (!model.endg)) {
            model.endg = true;
            model.getGamePanel().repaint();
        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
