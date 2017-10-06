package me.bkkn.Minesweeper.model;

import me.bkkn.Minesweeper.view.window.MenuWindow;

public class Game {

    static public Model model = new Model();

    public static void main(String[] args) {
        showMenuWindow();
    }

    private static void showMenuWindow() {
        model.setMenuWindow(new MenuWindow());
    }
}