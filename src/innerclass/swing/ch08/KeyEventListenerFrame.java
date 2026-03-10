package innerclass.swing.ch08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KeyListener 인터페이스를 구현하여 키보드 이벤트를 처리하는 클래스를 설계
 * 1. JFrame을 상속받아 창을 만들고
 * 2. KeyListener를 구현하여 '감시자' 자격을 갖춤
 */
public class KeyEventListenerFrame extends JFrame implements KeyListener {
    private final int FRAME_SIZE = 500;
    private JTextArea textArea;

    public KeyEventListenerFrame() {
        initData();
        setInitLayout();
        addEventListener();

    }
    private void initData() {
        setSize(FRAME_SIZE, FRAME_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // 사용자가 마우스 크기로 창 크기를 조절 못하게 고정하는 옵션
        textArea = new JTextArea();
    }
    private void setInitLayout() {
        setLayout(new BorderLayout()); // 전체 기본 레이아웃
        add(textArea);
        setVisible(true);
    }
    private void addEventListener() {
        // 핵심개념
        // textArea 에게 키보드 입력이 들어오면 this(나)에게 알려줘 라고 등록하는 과정
        textArea.addKeyListener(this);
    }

    // ------------------ KeyListener 추상 메소드를 일반 메소드로 재정의(구현)
    // 문자가 입력되었을 때 호출
    @Override
    public void keyTyped(KeyEvent e) {

    }
    // 키보드의 어떤 키든 눌렀을 때 호출
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println(e.getSource() + ": 주소값");
        System.out.println(e.getKeyCode() + ": 키 코드");
        // 콘솔창에 화살표가 뭐 눌러졌는지 구분해보기
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            textArea.append("← 왼쪽\n"); // \n 줄바꿈
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            textArea.append("↑ 위쪽\n");
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            textArea.append("→ 오른쪽\n");
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            textArea.append("↓ 아래쪽\n");
        }
    }
    // 어떤 키든 손을 뗐을때 호출
    @Override
    public void keyReleased(KeyEvent e) {
    }

    // 테스트코드 - 메인 스레드
    public static void main(String[] args) {
        new KeyEventListenerFrame();
    }

}

