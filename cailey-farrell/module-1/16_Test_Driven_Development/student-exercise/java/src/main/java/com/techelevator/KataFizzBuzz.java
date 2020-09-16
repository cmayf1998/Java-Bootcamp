package com.techelevator;

import java.lang.reflect.Array;

public class KataFizzBuzz {

    public String fizzBuzz(int convertToFizzBuzz) {
        String resultIf3 = "Fizz"; //if divisible by 3
        String resultIf5 = "Buzz"; //if divisible by 5
        String resultIfNeither3Or5 = Integer.toString(convertToFizzBuzz);
        String resultIfEmpty = "";

//Part 1:
//        if (convertToFizzBuzz % 3 != 0 || convertToFizzBuzz % 5 !=0) {
//            return resultIfNeither3Or5;
//        }

       if (convertToFizzBuzz > 100 || convertToFizzBuzz < 0) {
           return resultIfEmpty;
       }

       if (convertToFizzBuzz == 0) {
           return resultIfEmpty;
       }

        if (convertToFizzBuzz %  3 == 0 && convertToFizzBuzz % 5 == 0) {
            return resultIf3 + resultIf5;
        }

        if (convertToFizzBuzz % 3 == 0) {
            return resultIf3;
        }

        if (convertToFizzBuzz % 5 == 0) {
            return resultIf5;
        }

        //Part 2:
       if (Integer.toString(convertToFizzBuzz).contains("3") == true && Integer.toString(convertToFizzBuzz).contains("5") == true ) {
           return resultIf3 + resultIf5;
       }

        if (Integer.toString(convertToFizzBuzz).contains("3") == true) {
            return resultIf3;
        }

        if (Integer.toString(convertToFizzBuzz).contains("5") == true) {
            return resultIf5;
        }


       /* String[] array = new String[2];
        String.valueOf(convertToFizzBuzz) = array;

        for (int i = 0; i < String.valueOf(convertToFizzBuzz).length(); i++){
            if (String.valueOf(convertToFizzBuzz) =

            }
        }*/


        return String.valueOf(convertToFizzBuzz);
    }
}

