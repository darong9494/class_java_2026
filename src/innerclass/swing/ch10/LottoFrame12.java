package innerclass.swing.ch10;

import innerclass.swing.ex.LottoGame1;

import javax.swing.*;
import java.awt.*;

public class LottoFrame12 extends JFrame {
    private JButton button1;
    private JLabel label1;

    public LottoFrame12() {
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
        setVisible(true);
    }

    private void initData() {
        setSize(600, 600);
        setTitle("Lotto Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1 = new JButton("Game Start");
        label1 = new JLabel("Game");

    }

    // 테스트 코드
    public static void main(String[] args) {
        new LottoGame1();
    }
}
