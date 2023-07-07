package org.gundam.warmup;

import java.io.*;


class ValleyResult {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
    // Write your code here
        var inTheValley = false;
        var upStepCount=0;
        var downStepCount=0;
        var valleyCount=0;
        for(int i=0;i<path.length();i++) {
            char step = path.charAt(i);
            switch (step) {
                case 'U':
                    upStepCount++;
                    break;
                case 'D':
                    downStepCount++;
                    break;
            }
            if (upStepCount == downStepCount) {
                if (inTheValley) {
                    valleyCount++;
                    inTheValley = false;
                }
            }
            if (downStepCount > upStepCount) {
                inTheValley = true;
            }
        }
        return valleyCount;
    }

}

public class ValleyCount {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("result"));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = ValleyResult.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}