import javax.swing.*;
import java.awt.*;
class OnFrame extends JFrame {
    public OnFrame(){
        Container con = getContentPane();
        OnPanel first = new OnPanel();
        con.add(first);
        setTitle("Введите данные");
        setBounds(0,0,440,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}

