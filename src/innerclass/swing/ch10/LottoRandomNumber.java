package innerclass.swing.ch10;

import java.util.Random;

public class LottoRandomNumber {
    private int[] lotto = new int[6];
    private int temp;

    public void makeNumber() {
        Random random = new Random();

        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = random.nextInt(45) + 1;
            ;
            for (int j = 0; j < i; j++) {
                if (lotto[i] == lotto[j]) {
                    i--;
                    break;
                }
            }
        }
    }

    public void sort() {
        for (int i = 0; i < lotto.length; i++) {
            for (int j = 0; j < lotto.length; j++) {
                if (lotto[i] < lotto[j]) {
                    temp = lotto[i];
                    lotto[i] = lotto[j];
                    lotto[j] = temp;
                }
            }
        }
    }

    public int[] getNumber() {
        makeNumber();
        sort();
        return lotto;
    }
}
