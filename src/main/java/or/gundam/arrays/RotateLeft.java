package or.gundam.arrays;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class RotateLeftResult {

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here

        int[] resultArray = new int[a.size()];
        var length = a.size();
        for (int i = 0; i < length; i++) {
            var resultIndex = (length - d) + i;
            if (resultIndex >= length) {
                resultArray[resultIndex - length] = a.get(i);
            } else {
                resultArray[resultIndex] = a.get(i);
            }
        }
        return Arrays.stream(resultArray).boxed().toList();

    }

}

public class RotateLeft
{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("rotateLeft"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");


        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = RotateLeftResult.rotLeft(a, d);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
