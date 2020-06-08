package array;

class IsPowerOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(3));
    }

    public static boolean isPowerOfTwo(int n) {
        return f(n);
    }

    public static boolean f(int v) {
        if (v == 2 || v == 1) return true;
        if (v < 2) return false;
        return f(v % 2);
    }
}