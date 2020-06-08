package backtracking;

import java.util.ArrayList;
import java.util.List;

class LetterCasePermutation {
    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
    }

    public static List<String> letterCasePermutation(String s) {

        List<String> list = new ArrayList<>();
        func(s.toCharArray(), 0, list, new StringBuilder());
        return list;
    }

    public static void func(char[] arr, int start, List<String> list, StringBuilder sb) {
        if (start == arr.length) {
            list.add(sb.toString());
            return;
        }

        char ch = arr[start];

        if (Character.isDigit(ch)) {
            sb.append(ch);
            func(arr, start + 1, list, sb);
            sb.deleteCharAt(start);
        } else {
            sb.append(Character.toUpperCase(ch));
            func(arr, start + 1, list, sb);
            sb.deleteCharAt(start);
            sb.append(Character.toLowerCase(ch));
            func(arr, start + 1, list, sb);
            sb.deleteCharAt(start);
        }

    }
}
