package com.misc.HackerRank.medium1;

import java.io.*;
import java.util.*;

public class ClimbingTheLeaderboard {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        List<Integer> finalOutput = new ArrayList<>();

        //Step 1: convert the list "ranked" to set, to remove the duplicates
        Set<Integer> rankedSet = new HashSet<>(ranked);
        //Step 2: convert the set again to list to sort it in descending order (set does not maintain order)
        ranked = new ArrayList<>(rankedSet);
        //Step 3: sort the list in descending order
        ranked.sort(Collections.reverseOrder());

        for (Integer playerScore : player) {
            finalOutput.add(binarySearch(ranked, playerScore)+1);
        }

        return finalOutput;
    }

    //Binary Search with return of "end"
    public static int binarySearch(List<Integer> searchList, int searchInt){
        int start = 0;
        int end = searchList.size()-1;//Note: the -1 here

        while(start<=end){
            int mid = start + (end - start)/2;

            if(searchInt == searchList.get(mid)){
                return mid;
            } else if(searchInt > searchList.get(mid)){
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }
        return end + 1;
    }


    public static void main(String[] args) throws IOException {
        List<Integer> ranked = Arrays.asList(100, 100, 50, 40, 40, 20, 10);
        List<Integer> player = Arrays.asList(5, 25, 50, 120);

        List<Integer> output = climbingLeaderboard(ranked, player);

        //Expected Output: [6, 4, 2, 1]
        System.out.println(output);
    }
}

