package innerclass.swing.ch11;

import java.util.Arrays;
import java.util.Random;

/**
 * [책임, 역할] 로또 번호 생성 전달 전담 클래스
 * SRP(Single Responsibility Principle) - 단일 책임 원칙 (5가지 원칙)
 * : 클래스는 하나의 책임만 가져야 한다.
 * - 즉 이 클래스는 오직 로또 번호 생성만 담당한다.
 */
public class LottoRandomNumber {
    static final int LOTTO_NUMBER_COUNT = 6;

    public int[] createNumber() {
        // [1][2][3][4][5][6]
        // 1. 이중 for, while (set), 셔플 {1, 2, 3, ~45}
        int[] lottoWinNum = new int[LOTTO_NUMBER_COUNT];
        Random random = new Random();
        for (int i = 0; i < lottoWinNum.length; i++) {
            // 1~45 사이의 랜덤 숫자 생성
            lottoWinNum[i] = random.nextInt(45) + 1;

            // 앞에서 이미 뽑은 숫자들과 중복 비교
            for (int j = 0; j < i; j++) {
                if(lottoWinNum[j] == lottoWinNum[i]) {
                    //        j = 0            [1]
                    //        i = 1            [2]
                    // 중복 발견 시점 i 값을 되돌려서 같은 자리를 다시 뽑게함
                    i--;
                    break; // 중복 발견시 즉시 안쪽 for 탈출
                }
            }
        }

        // 오름차순 정렬
        Arrays.sort(lottoWinNum); // 오름차순 정렬이 기본값

        // todo 반드시 수정
        return lottoWinNum;
    } // end of createNumber

    public static void main(String[] args) {
        LottoRandomNumber randomNumber = new LottoRandomNumber();
        int[] result = randomNumber.createNumber();
        // 무조건 처음부터 끝까지 반복시켜야 할때 많이 사용함
        for(int num : result) {
            System.out.println(num);
        }
    }
}
