package com.example.problemset1a;

public class Fibonacci {

    public static String fibonacci(int n) {
        int f_0 = 0, f_1 = 1;
        int ans;
        String answer = f_0 + "," + f_1;
//        System.out.println(answer);
        for (int i=2; i<n; i++){
            ans = f_0 + f_1;
            f_0 = f_1;
            f_1 = ans;
            answer = answer + "," + ans;
//            System.out.println(ans);
        }
        System.out.println(answer);
        return answer;
    }
}