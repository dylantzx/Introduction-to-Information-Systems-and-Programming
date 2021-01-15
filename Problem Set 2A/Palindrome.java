package com.example.problemset2a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Palindrome {
    Palindrome(char[] S){ isPalindrome(S);}
    public static boolean isPalindrome (char[] S) {
        if (S.length == 0 || S.length == 1) return true;
        else if (S[0] == S[S.length-1]) {
            char[] newS = Arrays.copyOfRange(S, 1 , S.length-1);
            // System.out.println(newS);
            return isPalindrome(newS);
        }
        else return false;
    }
}

class Test{

    public static void main (String [] args){
        char[] str = {'a','b','b','a'};
        Palindrome p = new Palindrome(str);

    }

}

/* ATTENTION
The method isPalindrome() returns true if the input string is a palindrome, and false otherwise.
It is NOT NECESSARY to do any System.out.println() of "abba is a palindrome" etc.
*/


