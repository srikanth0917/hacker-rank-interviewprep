package org.gundam.hashmaps;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
    // Write your code here
        Map<String,Integer> anagramsMap = new HashMap<>();

        int anagramsCount = 0;


        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                StringBuilder sb = new StringBuilder(s.substring(i,j));
                char[] chars = sb.toString().toCharArray();
                Arrays.sort(chars);
                String sortedSubstring = new String(chars);
                if(anagramsMap.containsKey(sortedSubstring)){
                    anagramsCount += anagramsMap.get(sortedSubstring);
                }
                anagramsMap.put(sortedSubstring, anagramsMap.getOrDefault((sb.toString()),0)+1);
            }
        }

        System.out.println(anagramsCount);
        return anagramsCount;
    }

}

public class SherlockAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("anagrams"));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
