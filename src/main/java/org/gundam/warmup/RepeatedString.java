package org.gundam.warmup;

import java.io.*;

class RepeatStringResult {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
        // Write your code here
        // best solution with less execution time
        StringBuilder sb = new StringBuilder(s);
        var count = sb.chars().filter(c -> c == 'a').count();
        var totalOccurrances = 1L;
        var lastCharCount = 0;
        if(s.length() == 1 && s.charAt(0) == 'a')
            return n;
        totalOccurrances = n / (s.length());
        var remainingCharsLength = n % (s.length());
        lastCharCount += s.chars().limit(remainingCharsLength).filter(c -> c == 'a').count();
        return ((count * totalOccurrances) + lastCharCount);
        /*
         * below code takes more time
         * Functionally works but not effective with time
         */
        
       /* while (true) {

            if (sb.length() >= n) {
                break;
            } else if ((totalStringLength + s.length()) >= n) {
                 remainingCharslength = (int) n - totalStringLength;
                lastCharCount += s.chars().limit(remainingCharslength).filter(c -> c == 'a').count();
                break;

            } else {
                totalStringLength += s.length();
                totalOccurrances++;
            }
        }
        return ((count * totalOccurrances) + lastCharCount);*/
    }

}

public class RepeatedString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("RepeatedString"));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = RepeatStringResult.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}