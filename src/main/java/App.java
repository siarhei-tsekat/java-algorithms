public class App {
    public static void main(String[] args) {
        System.out.println("2 -> " + new Solution().wordsTyping(new String[]{"a", "bcd", "e"}, 3, 6));
//        System.out.println("10 -> " + new Solution().wordsTyping(new String[]{"f", "p", "a"}, 8, 7));
//        System.out.println("2 -> " + new Solution().wordsTyping(new String[]{"a", "bcd", "e"}, 4, 6));
    }
}


class Solution {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int len = s.length();

        int[] map = new int[len];

        for (int i = 1; i < len; i++) {
            map[i] = s.charAt(i) == ' ' ? 1 : map[i - 1] - 1;
        }
        int cnt = 0;
        for (int i = 0; i < rows; i++) {
            cnt += cols;
            cnt += map[cnt % len];
        }
        return cnt / len;
    }
}