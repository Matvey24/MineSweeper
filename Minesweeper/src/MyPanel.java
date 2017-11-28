import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.io.File;

class MyPanel extends JPanel {
    private MyPanel pan;
    private Model mnd = new Model();
    private Game gm = new Game();
    private JLabel vis;
    private JLabel shir;
    private JLabel mins;
    private JButton restart;
    private Image mina, dot, one, two, three, four, five, six, seven, eight, endg, vin;

    public MyPanel() {
        addMouseListener(new myMouse1());
        addMouseMotionListener(new myMouse2());
        try {
            dot = ImageIO.read(new File("./dot.png"));
            mina = ImageIO.read(new File("./Мина.png"));
            one = ImageIO.read(new File("./one.png"));
            two = ImageIO.read(new File("./two.png"));
            three = ImageIO.read(new File("./three.png"));
            four = ImageIO.read(new File("./four.png"));
            five = ImageIO.read(new File("./five.png"));
            six = ImageIO.read(new File("./six.png"));
            seven = ImageIO.read(new File("./seven.png"));
            eight = ImageIO.read(new File("./eight.png"));
            endg = ImageIO.read(new File("./Конец.png"));
            vin = ImageIO.read(new File("./Флаг.png"));
        } catch (Exception e) {
        }
        setLayout(null);
        vis = new JLabel("Высота: " + mnd.getHeights());
        shir = new JLabel("Ширина: " + mnd.getLenghts());
        mins = new JLabel("Мин: " + mnd.getMins());
        vis.setForeground(Color.BLACK);
        shir.setForeground(Color.BLACK);
        mins.setForeground(Color.BLACK);
        Font labFont = new Font("arial", 0, 15);
        vis.setFont(labFont);
        shir.setFont(labFont);
        mins.setFont(labFont);
        vis.setBounds(105, 5, 100, 15);
        shir.setBounds(205, 5, 100, 15);
        mins.setBounds(305, 5, 100, 15);
        add(vis);
        add(shir);
        add(mins);
        restart = new JButton("Рестарт");
        restart.setForeground(Color.BLACK);
        restart.setFont(new Font("serif", 0, 15));
        restart.setBounds(5, 0, 100, 20);
        restart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mnd.setIn(false);
                mnd.setVin(0);
                gm.restart();
                repaint();
            }
        });
        add(restart);
    }

    public class myMouse1 implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            int a = 0;
            mnd.setBtn(e.getButton());
            int MouseX = (int) (e.getX() - 5) / 20;
            int MouseY = (int) (e.getY() - 30) / 20;
            if (mnd.getBtn() == 1 && mnd.place[1][MouseY][MouseX] == 0) {
                if (mnd.getVin() == 0) {
                    if (mnd.isIn() == false) {
                        mnd.setIn(true);
                        gm.start(MouseX, MouseY);
                    }

                    mnd.place[1][MouseY][MouseX] = 1;

                    gm.RegulateMassiv();

                    for (int i = 0; i < mnd.getHeights(); i++) {
                        for (int j = 0; j < mnd.getLenghts(); j++) {
                            if (mnd.place[1][i][j] == 0 && mnd.place[0][i][j] != -1) a--;
                        }
                    }
                    if (a == 0) mnd.setVin(1);
                    if (mnd.getVin() == 0) {
                        repaint();
                    }
                    if (mnd.place[0][MouseY][MouseX] == -1) {
                        mnd.setVin(2);
                    }
                    if (mnd.getVin() == 2) {
                        for (int i = 0; i < mnd.getHeights(); i++) {
                            for (int j = 0; j < mnd.getLenghts(); j++) {
                                if (mnd.place[0][i][j] == -1) mnd.place[1][i][j] = 1;
                            }
                        }
                        repaint();
                    }
                }
                if (mnd.getVin() == 1) {
                    repaint();
                }
            } else if (mnd.getBtn() == 3 && mnd.place[1][MouseY][MouseX] == 0 && mnd.getVin() == 0) {
                mnd.place[1][MouseY][MouseX] = 2;
                mnd.setFlag(mnd.getFlag() - 1);
                mins.setText("Мин:" + mnd.getFlag());
                repaint();
            } else if (mnd.getBtn() == 3 && mnd.place[1][MouseY][MouseX] == 2 && mnd.getVin() == 0) {
                mnd.place[1][MouseY][MouseX] = 0;
                mnd.setFlag(mnd.getFlag() + 1);
                mins.setText("Мин:" + mnd.getFlag());
                repaint();
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

    public class myMouse2 implements MouseMotionListener {
        public void mouseDragged(MouseEvent e) {

        }

        public void mouseMoved(MouseEvent e) {
        }
    }

    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        for (int i = 0; i < mnd.getHeights(); i++) {
            for (int j = 0; j < mnd.getLenghts(); j++) {
                if(mnd.place[1][i][j] == 2)gr.drawImage(vin, 5 + j * 20, 30 + i * 20, 20, 20, null);
                else if (mnd.place[1][i][j] == 0) gr.drawImage(dot, 5 + j * 20, 30 + i * 20, 20, 20, null);
                else if (mnd.place[0][i][j] == 1) gr.drawImage(one, 5 + j * 20, 30 + i * 20, 20, 20, null);
                else if (mnd.place[0][i][j] == 2) gr.drawImage(two, 5 + j * 20, 30 + i * 20, 20, 20, null);
                else if (mnd.place[0][i][j] == 3) gr.drawImage(three, 5 + j * 20, 30 + i * 20, 20, 20, null);
                else if (mnd.place[0][i][j] == 4) gr.drawImage(four, 5 + j * 20, 30 + i * 20, 20, 20, null);
                else if (mnd.place[0][i][j] == 5) gr.drawImage(five, 5 + j * 20, 30 + i * 20, 20, 20, null);
                else if (mnd.place[0][i][j] == 6) gr.drawImage(six, 5 + j * 20, 30 + i * 20, 20, 20, null);
                else if (mnd.place[0][i][j] == 7) gr.drawImage(seven, 5 + j * 20, 30 + i * 20, 20, 20, null);
                else if (mnd.place[0][i][j] == 8) gr.drawImage(eight, 5 + j * 20, 30 + i * 20, 20, 20, null);
                else if (mnd.place[0][i][j] == -1) gr.drawImage(mina, 5 + j * 20, 30 + i * 20, 20, 20, null);
            }
        }
        for (int i = 0; i <= mnd.getHeights(); i++) {
            for (int j = 0; j <= mnd.getLenghts(); j++) {
                gr.drawLine(5, 30 + i * 20, 5 + j * 20, 30 + i * 20);
                gr.drawLine(5 + j * 20, 30, 5 + j * 20, 30 + i * 20);
            }
        }
        if (mnd.getVin() == 2) gr.drawImage(endg, 5, 30, mnd.getLenghts() * 10, mnd.getHeights() * 5, null);
        if (mnd.getVin() == 1) gr.drawImage(vin, 5, 30, mnd.getLenghts() * 5, mnd.getHeights() * 5, null);
    }
}
