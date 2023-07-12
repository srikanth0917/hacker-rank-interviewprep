package org.gundam.arrays;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class NewYearResult {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
    // Write your code here

        var minimumBribes = 0;
        for (var i = 0; i < q.size(); i++) {
            if (q.get(i) - 2 > i + 1) {
                System.out.println("Too chaotic");
                return;
            }
            for (var j = i - 1; j >= q.get(i) - 2 && j >= 0; j--) {
                if (q.get(j) > q.get(i)) minimumBribes++;
            }
        }
        System.out.println(minimumBribes);
    }

}

public class NewYearChaos {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
              //  int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                NewYearResult.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
