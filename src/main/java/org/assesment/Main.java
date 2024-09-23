package org.assesment;

import java.util.*;

public class Main {

    public static List<List<String>> groupAnagrams(String[] words) {
        List<List<String>> anagramGroups = new ArrayList<>();
        boolean[] grouped = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            if (!grouped[i]) {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(words[i]);
                char[] sortedWord = sortString(words[i]);
                for (int j = i + 1; j < words.length; j++) {
                    if (!grouped[j] && compareChars(sortedWord, sortString(words[j]))) {
                        newGroup.add(words[j]);
                        grouped[j] = true;
                    }
                }
                anagramGroups.add(newGroup);
            }
        }

        return anagramGroups;
    }

    public static boolean compareChars(char[] chars1, char[] chars2)
    {
        if(chars1.length != chars2.length)
        {
            return false;
        }
        for (int i = 0; i < chars1.length; i++) {
            if(chars1[i] != chars2[i])
            {
                return false;
            }
        }
        return true;
    }

    public static char[] sortString(String str) {
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }

        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = 0; j < chars.length - i - 1; j++) {
                if (chars[j] > chars[j + 1]) {
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }
            }
        }

        return chars;
    }
    public static void main(String[] args) {
        String[] words = {"cook", "save", "taste", "aves", "vase", "state", "map"};
        for (List<String> groupAnagram : groupAnagrams(words)) {
            System.out.println(groupAnagram);
        }
    }
}