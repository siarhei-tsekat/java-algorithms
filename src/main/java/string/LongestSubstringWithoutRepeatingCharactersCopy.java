package string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharactersCopy {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb") + " = 3");
        System.out.println(lengthOfLongestSubstring("bbbbb") + " = 1");
        System.out.println(lengthOfLongestSubstring("pwwkew") + " = 3");
        System.out.println(lengthOfLongestSubstring("dvdf") + " = 3");
        System.out.println(lengthOfLongestSubstring("asdfghiopglkxcvy") + " = 11");
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i))) {
                set.remove(s.charAt(j++));
                --i;
                res = Math.max(res, i - j + 1);
            } else {
                res = Math.max(res, i - j + 1);
            }
        }
        return res;
    }
}
