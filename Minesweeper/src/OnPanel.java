
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class OnPanel extends JPanel {
    private Model mnd;
    private OnPanel first;
    private JLabel shir, vis, mins;
    private JButton Ready, exit;
    private JTextArea shirtext, vistext, mintext;
    public OnPanel(){
        mnd = new Model();
        setLayout(null);
        Font btnFont = new Font("serif", 1, 20);
        Font labFont = new Font("arial", 0, 20);
        vis = new JLabel("Высота");
        vis.setForeground(Color.BLACK);
        vis.setFont(labFont);
        vis.setBounds(10,10,130,50);
        add(vis);
        shir = new JLabel("Ширина");
        shir.setForeground(Color.BLACK);
        shir.setFont(labFont);
        shir.setBounds(150,10,130,50);
        add(shir);
        mins = new JLabel("Кол-во мин");
        mins.setForeground(Color.BLACK);
        mins.setFont(labFont);
        mins.setBounds(290,10,130,50);
        add(mins);
        vistext = new JTextArea();
        vistext.setFont(btnFont);
        vistext.setBounds(10,50,130,30);
        vistext.setForeground(Color.BLACK);
        vistext.setBackground(Color.WHITE);
        add(vistext);
        shirtext = new JTextArea();
        shirtext.setFont(btnFont);
        shirtext.setBounds(150,50,130,30);
        shirtext.setForeground(Color.BLACK);
        shirtext.setBackground(Color.WHITE);
        add(shirtext);
        mintext = new JTextArea();
        mintext.setFont(btnFont);
        mintext.setBounds(290,50,130,30);
        mintext.setForeground(Color.BLACK);
        mintext.setBackground(Color.WHITE);
        add(mintext);
        Ready = new JButton("Готово");
        Ready.setForeground(Color.BLACK);
        Ready.setFont(labFont);
        Ready.setBounds(50,100,130,30);
        Ready.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                int a = 0, b = 0;
                try{
                    a = Integer.parseInt(vistext.getText());
                    if(a > 0)mnd.setHeights(a);
                }catch(Exception e){}
                try{
                    b = Integer.parseInt(shirtext.getText());
                    if(b > 0)mnd.setLenghts(b);
                }catch(Exception e){}
                try{
                    int c = Integer.parseInt(mintext.getText());
                    if(c > 0 && c < a * b - 1)mnd.setMins(c);
                }catch(Exception e){}
                mnd.start();
                MyFrame okno = new MyFrame();
            }
        });
        add(Ready);
        exit = new JButton("Выход");
        exit.setForeground(Color.BLACK);
        exit.setFont(labFont);
        exit.setBounds(250,100,130,30);
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                System.exit(0);
            }
        });
        add(exit);
    }

}
