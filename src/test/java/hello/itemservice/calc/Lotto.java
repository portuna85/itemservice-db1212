package hello.itemservice.calc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.util.Arrays.sort;

@Slf4j
public class Lotto {
    private final static Integer[] lottoResult = new Integer[6];

    @Test
    public Integer[] lottoResult() {

        for (int i = 0; i < lottoResult.length; i++) {
            lottoResult[i] = (int) ((Math.random() * 45) + 1);
            for (int j = 0; j < i; j++) {
                if (lottoResult[i] == lottoResult[j]) {
                    i--;
                }

            }
        }
        sort(lottoResult);
        for (int i = 0; i < lottoResult.length; i++) {
            System.out.println("이번주 1등 번호 = " + lottoResult[i]);
        }
        return lottoResult;
    }

    private Integer[] purchaseNum = new Integer[6];

    Integer[] purchaseLotto() {
        for (int i = 0; i < purchaseNum.length; i++) {
            purchaseNum[i] = (int) ((Math.random() * 45) + 1);
            for (int j = 0; j < i; j++) {
                if (purchaseNum[i] == purchaseNum[j]) {
                    i--;
                }
            }
        }
        sort(purchaseNum);
        return purchaseNum;
    }


    void resultCheck() {
        Integer[] oriNum = lottoResult();

        Integer cnt = 0;

        while (true) {
            cnt++;
            Integer[] purNum = purchaseLotto();
            boolean equals = Arrays.equals(oriNum, purNum);
            if (equals == true) {
                break;
            }
        }
    }
}