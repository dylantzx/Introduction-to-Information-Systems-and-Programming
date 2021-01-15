package com.example.problemset1a;

// ATTENTION
// just edit this file
// you need not edit Main.java

import java.util.*;

public class IteratingExamples {

    public static void main(String[] args) {

        String ans="";

        IteratingExamples iteratingexamples = new IteratingExamples();
        List< Integer > integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        integers.add(9);
        integers.add(10);
        String ans1 = "" + iteratingexamples.Act2Iterator(integers);
        ans = "Iterator Sum = " + ans1;

        System.out.println(ans);
    }

    public static int Act2Iterator(List<Integer> integers) {
        int sum = 0;
        // Insert code here to sum up input using an Iterator ...
        for (int i = 0; i <integers.size(); i++){
            sum+=integers.get(i);
        }
        return sum;
    }

    public static int Act2ForEach(List<Integer> integers) {
        int sum = 0;
        // Insert code here to sum up input using an Iterator ...
        for (int i:integers){
            sum+=i;
        }
        return sum;

    }


}
