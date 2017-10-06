package me.bkkn.Minesweeper.view.panel;

import me.bkkn.Minesweeper.controller.game.MyMouseListener;
import me.bkkn.Minesweeper.model.Game;
import me.bkkn.Minesweeper.model.Model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;

public class GamePanel extends JPanel {
    private Image mina;
    private Image dot;

    Model model = Game.model;

    public GamePanel() {
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new myMouse2());
        try {
            dot = ImageIO.read(new File("dot.png"));
            mina = ImageIO.read(new File("Мина.png"));
            one = ImageIO.read(new File("one.png"));
            two = ImageIO.read(new File("two.png"));
            three = ImageIO.read(new File("three.png"));
            four = ImageIO.read(new File("four.png"));
            five = ImageIO.read(new File("five.png"));
            six = ImageIO.read(new File("six.png"));
            seven = ImageIO.read(new File("seven.png"));
            eight = ImageIO.read(new File("eight.png"));
            endg = ImageIO.read(new File("Конец.png"));
            vin = ImageIO.read(new File("Флаг.png"));
        } catch (Exception localException1) {
            System.out.println(localException1.getMessage());
        }
    }

    private Image one;
    private Image two;
    private Image three;
    private Image four;
    private Image five;
    private Image six;
    private Image seven;
    private Image eight;
    private Image endg;
    private Image vin;

    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        for (int i = 0; i < model.getWidth(); i++) {
            for (int j = 0; j < model.getHeight(); j++) {
                if (model.getField()[1][i][j] == 0) {
                    gr.drawImage(dot, 10 + j * 20, 10 + i * 20, 20, 20, null);
                } else if (model.getField()[0][i][j] == 1) {
                    gr.drawImage(one, 10 + j * 20, 10 + i * 20, 20, 20, null);
                } else if (model.getField()[0][i][j] == 2) {
                    gr.drawImage(two, 10 + j * 20, 10 + i * 20, 20, 20, null);
                } else if (model.getField()[0][i][j] == 3) {
                    gr.drawImage(three, 10 + j * 20, 10 + i * 20, 20, 20, null);
                } else if (model.getField()[0][i][j] == 4) {
                    gr.drawImage(four, 10 + j * 20, 10 + i * 20, 20, 20, null);
                } else if (model.getField()[0][i][j] == 5) {
                    gr.drawImage(five, 10 + j * 20, 10 + i * 20, 20, 20, null);
                } else if (model.getField()[0][i][j] == 6) {
                    gr.drawImage(six, 10 + j * 20, 10 + i * 20, 20, 20, null);
                } else if (model.getField()[0][i][j] == 7) {
                    gr.drawImage(seven, 10 + j * 20, 10 + i * 20, 20, 20, null);
                } else if (model.getField()[0][i][j] == 8) {
                    gr.drawImage(eight, 10 + j * 20, 10 + i * 20, 20, 20, null);
                } else if (model.getField()[0][i][j] == -1) gr.drawImage(mina, 10 + j * 20, 10 + i * 20, 20, 20, null);
            }
        }
        for (int i = 0; i <= model.getWidth(); i++) {
            for (int j = 0; j <= model.getHeight(); j++) {
                gr.drawLine(10, 10 + i * 20, 10 + j * 20, 10 + i * 20);
                gr.drawLine(10 + j * 20, 10, 10 + j * 20, 10 + i * 20);
            }
        }
        if (model.vin == 2)
            gr.drawImage(endg, 0, 0, 200, 100, null);
        if (model.vin == 1)
            gr.drawImage(vin, 0, 0, 200, 200, null);
    }

    public class myMouse2
            implements MouseMotionListener {
        public myMouse2() {
        }

        public void mouseDragged(MouseEvent e) {
        }

        public void mouseMoved(MouseEvent e) {
        }
    }
}