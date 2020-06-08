package string;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb") + " = 3");
        System.out.println(lengthOfLongestSubstring("bbbbb") + " = 1");
        System.out.println(lengthOfLongestSubstring("pwwkew") + " = 3");
        System.out.println(lengthOfLongestSubstring("dvdf") + " = 3");
        System.out.println(lengthOfLongestSubstring("asdfghiopglkxcvy") + " = 11");
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128];

        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
