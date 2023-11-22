package com.company;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Exercise {

    public static void exercise(int bottlesNum, int numOfTest) {
        int days = 0;
        Random random = new Random(new Date().getTime());
        int oneTime = numOfTest;
        int bottles = bottlesNum;
        while (oneTime > 0 &&  bottles > 1) {
            days++;
            if(oneTime > bottles) {
                break;
            }

            int[] results = new int[oneTime];

            int tmp = bottles / oneTime;
            for (int j = 0; j < oneTime - 1; j++) {
                results[j] = tmp;
            }
            results[oneTime - 1] = bottles - ((oneTime - 1) * tmp);

//            int poisoned = oneTime - 1;
            int poisoned = random.nextInt(oneTime);
            System.out.println("groups: " + Arrays.toString(results));
            System.out.println("poisoned: " + poisoned);
            bottles = results[poisoned];

            oneTime--;
            System.out.println("tests: " + oneTime);
        }
        System.out.println("days: " + days * 7);
    }
}
