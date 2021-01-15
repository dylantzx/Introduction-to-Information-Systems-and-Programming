package com.example.problemset1b;

import java.util.HashMap;
import java.util.Map;

public class AlphabetGenerator {
    /**
     * Given a numeric base, return a char[] that maps every digit that is
     * representable in that base to a lower-case char.
     * 
     * This method will try to weight each character of the alphabet
     * proportional to their occurrence in words in a training set.
     * 
     * This method should do the following to generate an alphabet:
     *   1. Count the occurrence of each character a-z in trainingData.
     *   2. Compute the probability of each character a-z by taking
     *      (occurrence / total_num_characters).
     *   3. The output generated in step (2) is a PDF of the characters in the
     *      training set. Convert this PDF into a CDF for each character.
     *   4. Multiply the CDF value of each character by the base we are
     *      converting into.
     *   5. For each index 0 <= i < base,
     *      output[i] = (the first character whose CDF * base is > i)
     * 
     * A concrete example:
     * 	 0. Input = {"aaaaa..." (302 "a"s), "bbbbb..." (500 "b"s),
     *               "ccccc..." (198 "c"s)}, base = 93
     *   1. Count(a) = 302, Count(b) = 500, Count(c) = 198
     *   2. Pr(a) = 302 / 1000 = .302, Pr(b) = 500 / 1000 = .5,
     *      Pr(c) = 198 / 1000 = .198
     *   3. CDF(a) = .302, CDF(b) = .802, CDF(c) = 1
     *   4. CDF(a) * base = 28.086, CDF(b) * base = 74.586, CDF(c) * base = 93
     *   5. Output = {"a", "a", ... (29 As, indexes 0-28),
     *                "b", "b", ... (46 Bs, indexes 29-74),
     *                "c", "c", ... (18 Cs, indexes 75-92)}
     * 
     * The letters should occur in lexicographically ascending order in the
     * returned array.
     *   - {"a", "b", "c", "c", "d"} is a valid output.
     *   - {"b", "c", "c", "d", "a"} is not.
     *   
     * If base >= 0, the returned array should have length equal to the size of
     * the base.
     * 
     * If base < 0, return null.
     * 
     * If a String of trainingData has any characters outside the range a-z,
     * ignore those characters and continue.
     * 
     * @param base A numeric base to get an alphabet for.
     * @param trainingData The training data from which to generate frequency
     *                     counts. This array is not mutated.
     * @return A char[] that maps every digit of the base to a char that the
     *         digit should be translated into.
     */
    public static char[] generateFrequencyAlphabet(int base, String[] trainingData) {
        if (base < 0 ) return null;
        Map<Character,Integer> dict = new HashMap<>();
        Map<Character, Double> PDF = new HashMap<>();
        Map<Character, Double> CDF = new HashMap<>();
        char[] stringtochar;
        char[] output = new char[base];
        double sum = 0;
        // Get Frequency count of each letter
        // First For loop is to get strings and convert to char array
        for (int i =0; i< trainingData.length; i++){
            stringtochar = trainingData[i].toCharArray();
            // Check if char is a lowercase letter
            for (int j =0; j < stringtochar.length; j++){
                char ch = stringtochar[j];
                if (Character.isLetter(ch) && Character.isLowerCase(ch)){
                    char lowerch = ch;
                    if (dict.containsKey(lowerch)){
                        dict.put(lowerch, dict.get(lowerch)+1);
                    }
                    else dict.put(lowerch, 1);
                }
            }
        }
        // Sum up the total number of characters
        for (int k : dict.values()) {sum+=k;}
        // Calculate the PDF for each letter
        for (char a : dict.keySet()){
            PDF.put(a, (dict.get(a)/sum));
        }
        // Convert to CDF by adding previous values to current value eg. CDF(b) = Pr(a) + Pr(b)
        double value =0;
        for (char b : PDF.keySet()){
            CDF.put(b, PDF.get(b)+value);
            value += PDF.get(b);
        }
//        System.out.println(PDF);
//        System.out.println(CDF);

        int counter = 0;

        // Output will contain the letter that fulfils CDF*base -i >0.0001 (replaced i with counter since I do not want i to start from 0 every time i go to a new char)
        for (char c : CDF.keySet()){
            for (int q=0; q<base ;q++){
                if (CDF.get(c)*base - counter > 0.0001){
                    output[counter] = c;
                    counter++;
                    if (counter == base-1){ return output; }
                }
            }
//            System.out.println(counter);
        }

        return output;
    }
}
