package com.example.problemset1a;

import java.util.HashMap;

public class Pset1{
    public static void main (String[] args) {

        System.out.println(Pset1.isAllCharacterUnique("abcdefghijklmnopqrstuvABC"));
        System.out.println(Pset1.isAllCharacterUnique("abcdefgghijklmnopqrstuvABC"));

        System.out.println(Pset1.isPermutation("@ab", "a@b"));
        System.out.println(Pset1.isPermutation("abcd", "bcdA"));

    }
    public static boolean isAllCharacterUnique(String sIn) {
        char[] ch = sIn.toCharArray();
        // Use HashMap with character as String Key and num times as integer value
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        for (char i : ch) {
            if (dict.containsKey(i)) {
                return false;
            }
            else { dict.put(i, 1);}
        }
        return true;
    }

    public static boolean isPermutation(String sIn1, String sIn2) {
        char[] ch1 = sIn1.toCharArray();
        char[] ch2 = sIn2.toCharArray();
        HashMap<Character, Integer> dict1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> dict2 = new HashMap<Character, Integer>();
        for (char j : ch1) {
            if (dict1.containsKey(j)) {
                dict1.put(j, dict1.get(j)+1);
            }
            else { dict1.put(j, 1);}
        }
        for (char k : ch2) {
            if (dict2.containsKey(k)) {
                dict2.put(k, dict2.get(k)+1);
            }
            else { dict2.put(k, 1);}
        }
        return dict1.equals(dict2);
    }


}
