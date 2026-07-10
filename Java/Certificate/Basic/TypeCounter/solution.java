import java.io.*;
import java.util.*;

class Result {
    /*
     * Complete the 'typeCounter' function below.
     *
     * The function accepts STRING sentence as parameter.
     */
    public static void typeCounter(String sentence) {
        int stringCount = 0;
        int integerCount = 0;
        int doubleCount = 0;

        if (sentence != null && !sentence.trim().isEmpty()) {
            // split by any consecutive whitespace characters
            String[] tokens = sentence.trim().split("\\s+");

            for (String token : tokens) {
                if (token.matches("\\d+")) {
                    integerCount++; // 1. check if entirely digits
                } else if (token.matches("\\d+\\.\\d+") || token.matches("\\.\\d+") || token.matches("\\d+\\.")) {
                    doubleCount++; // 2. check the valid decimal format to be a double
                } else {
                    stringCount++; // 3. else defaults to a string
                }
            }
        }

        // print the results as requested
        System.out.println("string " + stringCount);
        System.out.println("integer " + integerCount);
        System.out.println("double " + doubleCount);    }
}
