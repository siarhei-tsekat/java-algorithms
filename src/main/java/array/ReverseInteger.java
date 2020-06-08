package array;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println("Expected: 123. Actual: " + reverse(321));
        System.out.println("Expected: -123. Actual: " + reverse(-321));
        System.out.println("Expected: 21. Actual: " + reverse(120));
        System.out.println("Expected: 0. Actual: " + reverse(0));
    }

    public static int reverse(int x) {
        String s = new StringBuilder().append(Math.abs(x)).reverse().toString();
        try {
            return x < 0 ? Integer.parseInt(s) * -1 : Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }
}
