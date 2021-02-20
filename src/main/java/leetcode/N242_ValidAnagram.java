package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by langji on 08/01/2020.
 */
public class N242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == t) return true;
        if (s.length() != t.length()) return false;

        /*HashMap<Character, Integer> hashMap = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (hashMap.containsKey(c)) {
                hashMap.replace(c, hashMap.get(c)+1);
            } else {
                hashMap.put(c, 1);
            }
        }

        for (Character c : t.toCharArray()) {
            if (hashMap.containsKey(c)) {
                int tmp = hashMap.get(c) - 1;
                if (tmp == 0) hashMap.remove(c);
                else hashMap.replace(c, tmp);
            } else {
                return false;
            }
        }

        return hashMap.isEmpty();*/

        int[] array1 = new int[26];

        for (Character c : s.toCharArray()) {
            array1[c-'a'] ++;
        }

        for (Character c : t.toCharArray()) {
            array1[c-'a'] --;
        }

        for (int i : array1) {
            if (i != 0) return false;
        }

        return true;
    }
}
