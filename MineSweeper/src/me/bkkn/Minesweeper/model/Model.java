package me.bkkn.Minesweeper.model;

import me.bkkn.Minesweeper.view.window.GameWindow;
import me.bkkn.Minesweeper.view.panel.GamePanel;
import me.bkkn.Minesweeper.view.window.MenuWindow;
import me.bkkn.Minesweeper.view.panel.MenuPanel;


public class Model {

    private int height;
    private int width;
    private int mines;
    private GamePanel gamePanel = null;
    private GameWindow gameWindow = null;
    private MenuWindow menuWindow = null;
    private MenuPanel menuPanel = null;
    public boolean in = false;
    public int vin = 0;
    public boolean endg = false;

    private int[][][] field;
    private boolean launchGame;

    public Model() {

        this.height = 10;
        this.width = 10;
        this.field = new int[2][height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                field[0][i][j] = 0;
                field[1][i][j] = 0;
            }
        }
    }

    public boolean isLaunchGame() {
        return launchGame;
    }

    public void setLaunchGame(boolean launchGame) {
        this.launchGame = launchGame;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getMines() {
        return mines;
    }

    public void setMines(int mines) {
        this.mines = mines;
    }

    public int[][][] getField() {
        return field;
    }

    public void setField(int[][][] field) {
        this.field = field;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public GameWindow getGameWindow() {
        return gameWindow;
    }

    public void setGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }

    public MenuWindow getMenuWindow() {
        return menuWindow;
    }

    public void setMenuWindow(MenuWindow menuWindow) {
        this.menuWindow = menuWindow;
    }

    public MenuPanel getMenuPanel() {
        return menuPanel;
    }

    public void setMenuPanel(MenuPanel menuPanel) {
        this.menuPanel = menuPanel;
    }

    public void generateField(int mouseX, int mouseY) {

        for (int i = 0; i < mines; i++) {
            int rndX = (int) (Math.random() * height);
            int rndY = (int) (Math.random() * width);
            if ((rndX == mouseX) && (rndY == mouseY)) {
                i--;
            } else if (field[0][rndX][rndY] != -1)
                field[0][rndX][rndY] = -1;
            else {
                i--;
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++)
                if (field[0][i][j] != -1) {
                    int it = 0;
                    if ((j > 0) && (i < height - 1) && (field[0][(i + 1)][(j - 1)] == -1)) it++;
                    if ((i < height - 1) && (field[0][(i + 1)][j] == -1)) it++;
                    if ((j < width - 1) && (i < height - 1) && (field[0][(i + 1)][(j + 1)] == -1)) it++;
                    if ((j > 0) && (field[0][i][(j - 1)] == -1)) it++;
                    if ((j < width - 1) && (field[0][i][(j + 1)] == -1)) it++;
                    if ((j > 0) && (i > 0) && (field[0][(i - 1)][(j - 1)] == -1)) it++;
                    if ((i > 0) && (field[0][(i - 1)][j] == -1)) it++;
                    if ((j < width - 1) && (i > 0) && (field[0][(i - 1)][(j + 1)] == -1)) it++;
                    field[0][i][j] = it;
                }
        }
    }

    public void updateField(int a, int b) {
        int c = 1;
        while (c != 0) {
            c = 0;
            for (int i = 0; i < a; i++) {
                for (int g = 0; g < b; g++) {

                    if ((getField(1, i, g) == 1) && (getField(0, i, g) == 0)) {
                        if ((i < a - 1) && (getField(0, (i + 1), g) >= 0) && (getField(0, (i + 1), g) < 9) && (getField(1, (i + 1), g) != 1)) {
                            setField(1, (i + 1), g, 1);
                            c++;
                        }
                        if ((g < b - 1) && (getField(0, i, (g + 1)) >= 0) && (getField(0, i, (g + 1)) < 9) && (getField(1, i, (g + 1)) != 1)) {
                            setField(1, i, (g + 1), 1);
                            c++;
                        }
                        if ((g > 0) && (getField(0, i, (g - 1)) >= 0) && (getField(0, i, (g - 1)) < 9) && (getField(1, i, (g - 1)) != 1)) {
                            setField(1, i, (g - 1), 1);
                            c++;
                        }
                        if ((i > 0) && (getField(0, (i - 1), g) >= 0) && (getField(0, (i - 1), g) < 9) && (getField(1, (i - 1), g) != 1)) {
                            setField(1, (i - 1), g, 1);
                            c++;
                        }
                    }
                }
            }
        }
    }


    public int getField(int i1, int i2, int i3) {
        return field[i1][i2][i3];
    }

    public void setField(int i1, int i2, int i3, int val) {
        field[i1][i2][i3] = val;
    }

//    public Game(int a, int b) {
//        Tab = new int[2][a][b];
//    }


}
