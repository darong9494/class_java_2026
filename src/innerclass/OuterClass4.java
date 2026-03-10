package innerclass;
// 익명 내부 클래스 사용해보기
public class OuterClass4 {
    // 1.
    Runnable runnable; // 인터페이스
    //1.
    public OuterClass4() {
        // 인터페이스를 구현 익명 클래스로 생성시킬 수 있다.
        // 내부에서 추상 메소드를 일반 메소드로 재정의해서 마치 실제 클래스처럼 구현해서 사용할 수 있다.
        new Runnable() {
            @Override
            public void run() {
                // ... 하는일 적을수 있다.
            }
        };
    } // end of 생성자

    // 2.
    // 멤버 변수 선언과 동시에 인터페이스를 구현 클래스로 동시에 초기화
    Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
        }
    };
}
