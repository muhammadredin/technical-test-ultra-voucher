package io.github.muhammadredin;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] words = {"cook", "save", "taste", "aves", "vase", "state", "map"};
        ArrayList<ArrayList<String>> anagram = new ArrayList<>();

        for (String word : words) {
            boolean isNewAnagram = true;

            for (ArrayList<String> strings : anagram) {
                ArrayList<Integer> asciiArray1 = bubbleSort(toAsciiArray(strings.get(0)));
                ArrayList<Integer> asciiArray2 = bubbleSort(toAsciiArray(word));
                if (asciiArray1.equals(asciiArray2)) {
                    strings.add(word);
                    isNewAnagram = false;
                }
            }

            if (isNewAnagram) {
                ArrayList<String> newAnagram = new ArrayList<>();
                newAnagram.add(word);
                anagram.add(newAnagram);
            }
        }
        System.out.println(anagram);

    }

    public static ArrayList<Integer> toAsciiArray(String word) {
        ArrayList<Integer> ascii = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            ascii.add((int) word.charAt(i));
        }

        return ascii;
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> ascii) {
        while (true) {
            boolean swap = false;

            for (int i = 0; i < ascii.size() - 1; i++) {
                if (ascii.get(i) > ascii.get(i + 1)) {
                    int temp = ascii.get(i);
                    ascii.set(i, ascii.get(i + 1));
                    ascii.set(i + 1, temp);
                    swap = true;
                }
            }

            if (!swap) {
                break;
            }
        }
        return ascii;
    }
}