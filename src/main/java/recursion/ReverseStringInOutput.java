package recursion;

public class ReverseStringInOutput {
    public static void main(String[] args) {
        reverseString("Hello".toCharArray());
    }

    public static void reverseString(char[] s) {
        reverseStringHelper(s, 0);
    }

    private static void reverseStringHelper(char[] s, int index) {
        if (index < s.length) {
            reverseStringHelper(s, index + 1);
            System.out.print(s[index]);
        }
    }
}
