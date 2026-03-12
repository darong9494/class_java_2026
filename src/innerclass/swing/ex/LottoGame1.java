package innerclass.swing.ex;

import javax.swing.*;
import java.awt.*;

public class LottoGame1 extends JFrame {

    private JButton button1;
    private JLabel label1;

    private JPanel panel1;
    private final int x = 50;
    private final int y = 50;
    private final int diameter = 100;

    public LottoGame1() {
        initData();
        setInitLayout();
        addEventListener();
    }

    private void addEventListener() {


    }

    private void setInitLayout() {
        setLayout(new BorderLayout());
        add(button1, BorderLayout.NORTH);
        add(label1, BorderLayout.CENTER);



        add(label1);
        setVisible(true);
    }

    private void initData() {
        setSize(600, 600);
        setTitle("Lotto Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1 = new JButton("Game Start");
        label1 = new JLabel("될것같냐?", SwingConstants.CENTER);
        label1.setFont(new Font("맑은고딕", Font.BOLD, 50));
        label1.setForeground(Color.RED);
        add(label1, BorderLayout.CENTER);

        panel1 = new JPanel();
        panel1.add(new CirclePanel());
        panel1.setSize(400,300);
        panel1.setVisible(true);
    }

    class CirclePanel extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int x = 50;
            int y = 50;
            int diameter = 50;

            g2d.setColor(Color.RED);
            g2d.drawOval(x,y,diameter,diameter);

            g2d.setColor(Color.BLUE);
            g2d.fillOval(200,50,diameter,diameter);
        }
    }

    // 테스트코드
    public static void main(String[] args) {

        new LottoGame1();
    }
}
