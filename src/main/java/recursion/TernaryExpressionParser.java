package recursion;

/***
 * Given a string representing arbitrarily nested ternary expressions,
 * calculate the result of the expression. You can always assume that
 * the given expression is valid and only consists of digits 0-9, ?, :, T and F
 * (T and F represent True and False respectively).
 */

public class TernaryExpressionParser {
    public static void main(String[] args) {

        System.out.println("2 -> " + new Solution().parseTernary("T?2:3"));
        System.out.println("3 -> " + new Solution().parseTernary("F?2:3"));
        System.out.println("4 -> " + new Solution().parseTernary("F?1:T?4:5"));
        System.out.println("F -> " + new Solution().parseTernary("T?T?F:5:3"));
        System.out.println("4 -> " + new Solution().parseTernary("F?T:F?T?1:2:F?3:4"));
        System.out.println("5 -> " + new Solution().parseTernary("F?T?F?7:F?F?F?3:F?F?0:1:0:6:1:0:5"));
        System.out.println("F -> " + new Solution().parseTernary("F?F?9:T?F?F?F?F?F?9:9:2:6:6:F:0:F"));
    }
}

class Solution {
    String str;
    int index = 0;

    public String parseTernary(String ex) {
        this.str = ex;
        return ternary();
    }

    private String ternary() {
        return str.charAt(index) == 'T' ? getLeft() : getRight();
    }

    private String getLeft() {
        index += 2;
        if (!isExpression()) return str.charAt(index) + "";
        else return ternary();
    }

    private String getRight() {
        skip();
        index += 2;
        if (!isExpression()) return str.charAt(index) + "";
        else return ternary();
    }

    private void skip() {
        index += 2;
        if(isExpression()) {
            skip();
            skip();
        }
    }

    private boolean isExpression() {
        return index + 1 < str.length() && str.charAt(index + 1) == '?';
    }
}