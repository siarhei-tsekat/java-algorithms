package string;

import java.util.Arrays;

public class RemoveVowelsFromString {
    public static void main(String[] args) {
        System.out.println(removeVowels("leetcodeisacommunityforcoders"));
    }

    public static String removeVowels(String s) {
        char[] arr = new char[]{'a', 'e', 'i', 'o', 'u'};
        char[] result = new char[s.length()];
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!contains(s.charAt(i), arr)) {
                result[counter++] = s.charAt(i);
            }
        }
        return new String(Arrays.copyOfRange(result, 0, counter));
    }

    private static boolean contains(char target, char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true;
            }
        }
        return false;
    }
}
