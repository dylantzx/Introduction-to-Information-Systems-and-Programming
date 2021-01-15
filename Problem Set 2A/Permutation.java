package com.example.problemset2a;

import java.util.ArrayList;

public class Permutation {
        private final String in;
        private int len = 0;
        private int count = 0;
        private String temp;
        private char tmp = 0;
        private ArrayList<String> a = new ArrayList<String>();

        Permutation(final String str){
            in = str;
            // additional initialization if needed
            len = in.length();
            temp = str;
        }

        public String swapChar(String str, int i, int j){
            char[] strArray = str.toCharArray();
            tmp = strArray[i];
            strArray[i] = strArray[j];
            strArray[j] = tmp;
            return String.valueOf(strArray);
        }

        public void permute(){
            // produce the permuted sequence of 'in' and store in 'a', recursively
            if (count == len-1) {
                a.add(temp);
                System.out.println("count when adding to a: " + count);
            }
            else{
                for (int s=count; s<len; s++){
                    // First case: Swapping the first character by itself
                    // Other cases: Swap the other character with the next character
                    // In order traversal
                    temp = swapChar(temp, count, s);
                    System.out.println("count is: " + count + ", s is: " + s + ", temp is: " + temp);
                    count++;
                    System.out.println("Count before permute is: " + count);
                    permute();
                    System.out.println("count after permute is: " + count + ", s is: " + s + ", temp is: " + temp);

                    // Backtracking
                    count--;
                    System.out.println("\n*********Backtracking*********");
                    System.out.println("count is now: " + count);
                    temp = swapChar(temp, count, s);
                    System.out.println("count during swap is: " + count + ", s is: " + s + ", temp is: " + temp);
                    System.out.println("*********Backtracked*********\n");

                    if (a.contains(temp)){
                        continue;
                    }
                    a.add(temp);

                }

            }

        }

        public ArrayList<String> getA(){
            return a;
        }
}

class TestPermutation {
    public static void main(String[] args) {
        ArrayList<String> v;

        Permutation p = new Permutation("hat");
        p.permute();
        v = p.getA();
        System.out.println(v);

    }
}

//////////////////////////////////////////////////////////////////////
//                              hat
//                        /      |      \
//                       /       |       \
//                      /        |        \
//                    hat       aht        tah
//                   /   \     /   \      /   \
//                  hat hta   aht ath   tah  tha
//
//////////////////////////////////////////////////////////////////////
