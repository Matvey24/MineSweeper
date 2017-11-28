import javax.swing.*;
import java.awt.*;
class MyFrame extends JFrame {
    private Model mnd = new Model();
    public MyFrame(){
        MyPanel pan = new MyPanel();
        Container cont = getContentPane();
        cont.add(pan);
        setTitle("Да, это сапер на Java");
        setBounds(0,0,  400 > 18 + mnd.getLenghts() * 20 ? 400 : 18 + mnd.getLenghts() * 20, 65 + mnd.getHeights() * 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setFocusable(true);
    }
}
