package org.gundam.arrays;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'equalizeArray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int equalizeArray(List<Integer> arr) {
    // Write your code here
        // 5
        // 3 3 2 1 3
        // (3,3) (2,1) (1,1)

        // 4
        // 1 2 2 3
        // (1,1) (2,2) (3,1)

        Map<Integer,Integer> duplicateCountMap = new HashMap<>();
        for(Integer num:arr){
            if(duplicateCountMap.get(num) ==  null)
             duplicateCountMap.put(num,1);
            else{
                int count = duplicateCountMap.get(num);
                duplicateCountMap.put(num,++count);
            }
        }
        int maxduplicates = Collections.max(duplicateCountMap.values());
        return arr.size() - maxduplicates;
    }

}

public class EqualizeArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("equalizearry"));


        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
