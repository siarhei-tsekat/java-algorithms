package backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        restoreIpAddresses("25525511135");
    }

    public  static List<String> restoreIpAddresses(String s) {
        func(s, 0, new StringBuilder(), 0);
        return res;
    }

    public static void func(String s, int start, StringBuilder sb, int dot) {
        if (start >= s.length()) {
            if (dot == 4)
                res.add(sb.substring(0, sb.length() - 1));
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (isValid(s, start, i) && dot <= 4) {

                String ns = s.substring(start, start + i);
                sb.append(ns);
                sb.append(".");

                func(s, start + i, sb, dot + 1);

                for (int j = 0; j < ns.length() + 1; j++) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }

    public static boolean isValid(String s, int start, int end) {
        if (start + end <= s.length()) {
            String v = s.substring(start, start + end);
            return check2(v) && check(Integer.valueOf(v));
        }
        return false;
    }

    public static  boolean check2(String value) {
        if (value.startsWith("0")) {
            return value.length() == 1;
        } else return true;
    }

    public static boolean check(int value) {
        return value <= 255;
    }
}
