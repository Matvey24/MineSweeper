package me.bkkn.Minesweeper.view.window;
import me.bkkn.Minesweeper.view.panel.MenuPanel;
import java.awt.Container;
import javax.swing.JFrame;

import static me.bkkn.Minesweeper.model.Game.model;

public class MenuWindow extends JFrame
{
  public MenuWindow()
  {
    Container con = getContentPane();
    model.setMenuPanel(new MenuPanel());
    con.add(model.getMenuPanel());
    setTitle("Введите данные");
    setBounds(0, 0, 440, 200);
    setDefaultCloseOperation(3);
    setResizable(false);
    setVisible(true);
  }
}
