package hello.itemservice.calc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static java.util.Arrays.sort;

@Slf4j
@Transactional
@SpringBootTest
public class lottoTest {
    private final static Integer[] originalNum = new Integer[6];

    @Test
    Integer[] 로또1등번호() {
        int tmp = 0;
        for (int i = 0; i < originalNum.length; i++) {
            originalNum[i] = (int) ((Math.random() * 45) + 1);
            for (int j = 0; j < i; j++) {
                if (originalNum[i] == originalNum[j]) {
                    i--;
                }
            }
        }
        sort(originalNum);
        return originalNum;
    }

    private final static Integer[] lottoResult = new Integer[6];

    @Test
    public Integer[] lottoResult() {
        int tmp = 0;
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
            log.info("{}", lottoResult[i]);
        }
        return lottoResult;
    }

    private Integer[] purchaseNum = new Integer[6];

    @Test
    Integer[] 로또구매번호() {
        int tmp = 0;
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


    @Test
    void 당첨번호확인() {
        Integer[] oriNum = 로또1등번호();

        Integer cnt = 0;

        while (true) {
            cnt++;
            Integer[] purNum = 로또구매번호();
            boolean equals = Arrays.equals(oriNum, purNum);
            log.info("구매 = {}", cnt);
            log.info("pur = {}, ok? = {}", purNum, equals);
            if (equals == true) {
                break;
            }
        }
    }
}