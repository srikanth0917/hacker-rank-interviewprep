package org.gundam.arrays;

import java.io.*;
import java.util.*;

public class MinimumSwaps {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {

        // 7 1 3 2 4 5 6
        // 6 1 3 2 4 5 7
        // 5 1 3 2 4 6 7
        // 4 1 3 2 5 6 7
        // 2 1 3 4 5 6 7
        // 1 2 3 4 5 6 7

        var i = 0;
        var minimumSwaps = 0;
        while (i < arr.length) {

            if (arr[i] != i + 1) {
                var value = arr[i];
                arr[i] = arr[value - 1];
                arr[value - 1] = value;
                minimumSwaps++;
            } else {
                i++;
            }


        }
        return minimumSwaps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("minimumswaps"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
