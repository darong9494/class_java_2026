package innerclass;

public class SpaceshipMain {
    public static void main(String[] args) {
        // static 정적 내부 클래스라서 바로 생성가능함
        Spaceship.Engine engine1 = new Spaceship.Engine();
        Spaceship spaceship = new Spaceship();
        spaceship.addEngine(engine1);
        spaceship.startSpaceship();

    } // end of main
}
