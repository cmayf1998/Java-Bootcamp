package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KataNumbersToWords {
    public int add(String numbers) {
        List <String> numbersList = new ArrayList<String>(Arrays.asList(numbers));
        int count = 0;

        if (numbers.isEmpty()) {
            return 0;
        }

        String[] numberArray = numbers.split(",");

        for (int i = 0; i < numberArray.length; i++) {
                count += Integer.valueOf(numberArray[i]);
            }
        return count;
    }
}

