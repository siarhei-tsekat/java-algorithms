package recursion;

public class ReverseStringInPlace {
    public static void main(String[] args) {
        char[] charArray = "Hello".toCharArray();
        reverseString(charArray);
        System.out.println(new String(charArray));
    }

    public static void reverseString(char[] s) {
        recurse(s, 0, s.length - 1);
    }

    public static void recurse(char[] s, int left, int right) {
        if (left > right)
            return;
        else {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            recurse(s, left + 1, right - 1);
        }
    }
}
