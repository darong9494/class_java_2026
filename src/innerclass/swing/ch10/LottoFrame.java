package innerclass.swing.ch10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LottoFrame extends JFrame implements ActionListener {

    private JButton button1;
    private JPanel panel1;
    private JLabel jLabel;
    private LottoRandomNumber lottoRandomNumber;
    private int init_x = 200;
    private int init_y = 200;
    private JPanel circle;

    public LottoFrame() {
        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData() {
        setTitle("Lotto Game");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1 = new JButton("Game start");
        panel1 = new JPanel();
        jLabel = new JLabel("Game Start 버튼을 눌러주세요", JLabel.CENTER);

        lottoRandomNumber = new LottoRandomNumber();
    }

    private void setInitLayout() {
        setLayout(new BorderLayout());
        add(button1, BorderLayout.NORTH);
        button1.setSize(100, 100);
        setVisible(true);
        add(jLabel, BorderLayout.CENTER);
        jLabel.setFont(new Font("맑은 고딕", Font.BOLD, 50));

    }

    static class Circle extends JPanel {
        int[] numbers;

        public Circle(int[] numbers) {
            this.numbers = numbers;
        }

        public void paint(Graphics g) {
            int x = 50;
            g.setFont(new Font("맑은고딕", Font.BOLD,15));
            for (int i = 0; i < numbers.length; i++) {
                if(numbers[i] <= 10){
                    g.setColor(Color.YELLOW);
                } else if (numbers[i]<=20) {
                    g.setColor(Color.BLUE);
                } else if (numbers[i] <= 30) {
                    g.setColor(Color.RED);
                } else if (numbers[i] <= 40) {
                    g.setColor(Color.GRAY);
                } else if(numbers[i] <=45){
                    g.setColor(Color.GREEN);
                }

                g.fillOval(x, 100, 50, 50);
                g.setColor(Color.BLACK);
                g.drawString(String.valueOf(numbers[i]), x + 20, 130);

                System.out.println(numbers[i]);
                x += 70;
            }
        }
    }

    private void addEventListener() {
        button1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jLabel.setText("");
        int[] lottoNumber = lottoRandomNumber.getNumber();
        circle = new Circle(lottoNumber);
        add(circle);
        setVisible(true);
        revalidate();
        repaint();

    }

    // main
    public static void main(String[] args) {
        new LottoFrame();
    } // end of main
}
