package org.gundam.hashmaps;


import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class RansomResult {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
    // Write your code here

        Map<String, AtomicInteger> magazineMap = new HashMap<>();
        Map<String,AtomicInteger> notesMap = new HashMap<>();
        boolean noteFound = true;
        for(String word:magazine){
            magazineMap.computeIfAbsent(word,k->new AtomicInteger(1)).getAndIncrement();
        }
        for(String word:note){
            notesMap.computeIfAbsent(word,k->new AtomicInteger(1)).getAndIncrement();
        }

        for(String word:note){
           if((magazineMap.get(word) == null )|| (notesMap.get(word).intValue() < magazineMap.get(word).intValue())){
                noteFound = false;
                break;
           }
        }
        if(noteFound)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

}

public class RansomNotes {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        RansomResult.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}
