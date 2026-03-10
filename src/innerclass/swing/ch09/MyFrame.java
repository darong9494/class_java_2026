package innerclass.swing.ch09;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements KeyListener {

    private JLabel backgroundMap;
    private JLabel player;
    int player_x = 200;
    int player_y = 200;

    public MyFrame() {
        initData();
        setInitLayout();
        addEventListener();

    }

    private void initData() {

        setTitle("이미지 사용 연습");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 배경 이미지 설정
        ImageIcon backgroundIcon = new ImageIcon("images/backgroundMap.png");
        backgroundMap = new JLabel(backgroundIcon);
        backgroundMap.setSize(1000, 600);
        backgroundMap.setLocation(0, 0);

        // 플레이어 설정
        ImageIcon playerIcon1 = new ImageIcon("images/playerL.png");
        player = new JLabel(playerIcon1);
        player.setSize(100, 100);
        player.setLocation(player_x, player_y);

    }

    private void setInitLayout() {

        setLayout(null);
        backgroundMap.add(player);
        add(backgroundMap);
        setVisible(true);

    }

    private void addEventListener() {
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //count++;

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.setLocation(player_x -= 10, player_y);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.setLocation(player_x, player_y -= 10);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.setLocation(player_x += 10, player_y);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.setLocation(player_x, player_y += 10);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        new MyFrame();
    }
}

