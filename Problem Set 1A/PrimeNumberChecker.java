package com.example.problemset1a;

public class PrimeNumberChecker {

    public static void main(String [] args){
        int ans = isPrime(14);
        System.out.println(ans);
    }
    public static int isPrime(int num) {
        // Insert code here to sum up input using an Iterator ...
        for (int n = 2; n < num; n++) {
            if (num % n == 0) { return 0;}
        }
        return 1;
    }
    }


