package innerclass.swing.ex;

import javax.swing.*;
import java.awt.*;

public class CirclePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int x = 50;
        int y = 50;
        int diameter = 100;

        g2d.setColor(Color.BLUE);
        g2d.drawOval(x, y, diameter, diameter);

        g2d.setColor(Color.RED);
        g2d.fillOval(200, 50, diameter, diameter);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("자바 원 그리기");
        frame.add(new CirclePanel());
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
