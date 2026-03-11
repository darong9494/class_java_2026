package innerclass.swing;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyFrame2 extends JFrame {
    private JLabel backgroundMap;
    private JLabel player;
    private final int MOVE_STEP = 10;
    // 이동 가능한 범위
    private final int MAX_X = 1000 - 100; // 최대크기가 900이됨
    private final int MAX_Y = 600 - 100; // 500
    //MIN_X, MIN_Y == 0
    private final int MIN_POS = 0;


    ImageIcon playerIconL = new ImageIcon("images/playerL.png");
    ImageIcon playerIconR = new ImageIcon("images/playerR.png");

    public MyFrame2() {
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
        player = new JLabel(playerIconL); // 초기 상태값
        player.setSize(100, 100);
        player.setLocation(200, 200);

    }

    private void setInitLayout() {
        setLayout(null); // 좌표 기반
        backgroundMap.add(player);
        add(backgroundMap);
        setVisible(true);
    }

    private void addEventListener() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int x = player.getX();
                int y = player.getY();

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        y -= MOVE_STEP;
                        break;
                    case KeyEvent.VK_LEFT:
                        player.setIcon(playerIconL);
                        x -= MOVE_STEP;
                        break;
                    case KeyEvent.VK_DOWN:
                        y += MOVE_STEP;
                        break;
                    case KeyEvent.VK_RIGHT:
                        player.setIcon(playerIconR);
                        x += MOVE_STEP;
                        break;
                    default:
                        return;
                }

                // 1. 오른쪽 벽 방어 (최댓값 제한)
                if (x > MAX_X) {
                    x = MAX_X; // 화면 오른쪽 끝을 넘어가려 하면, 강제로 끝값에 고정!
                }

// 2. 왼쪽 벽 방어 (최솟값 제한)
                if (x < MIN_POS) {
                    x = MIN_POS; // 화면 왼쪽 끝(0)보다 작아지려 하면, 강제로 0에 고정!
                }


// 3. 위쪽 벽 방어 (최솟값 제한)
                if (y < MIN_POS) {
                    y = MIN_POS; // y가 0보다 작아지면(화면 위로 탈출), 강제로 시작점(0)에 고정!
                }

// 4. 아래쪽 벽 방어 (최댓값 제한)
                if (y > MAX_Y) {
                    y = MAX_Y; // y가 화면 높이를 넘어가면(화면 아래로 탈출), 강제로 끝값에 고정!
                }

                if(player.getX() < 0) {
                    x = 0;
                }

                if(player.getX() > 900) {
                    x = 900;
                }

                // 배경 밖으로 나가지 않도록 범위 제한
                //                            100,  900
                //             0    ,   100
                x = Math.max(MIN_POS, Math.min(x, MAX_X)); // max 최대값 추출, min 최소값 추출
                y = Math.max(MIN_POS, Math.min(y, MAX_Y));

                player.setLocation(x,y);

            } // end of Keypressed

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        // 추천 옵션 - 필수
        setFocusable(true);
        requestFocusInWindow();


    }

    // 테스트 코드 (메인 쓰레드)
    public static void main(String[] args) {
        new MyFrame2();
    }

}
