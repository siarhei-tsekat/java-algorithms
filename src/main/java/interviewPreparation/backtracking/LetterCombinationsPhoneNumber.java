package interviewPreparation.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * <p>
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

public class LetterCombinationsPhoneNumber {

    static Stream<Character> all = Stream.of('a','b','c','e');

    public static void main(String[] args) {
        System.out.println("[ad, ae, af, bd, be, bf, cd, ce, cf]");
        System.out.println(new Solution().letterCombinations("23"));

    }

    public static void replace(StringBuilder sb, final Character next) {
        Character prev = '.';

        if(sb.length() != 0) {
            prev = sb.charAt(sb.length() - 1);
        }

        Character finalPrev = prev;
        Character target = all.filter(el -> !el.equals(finalPrev) && !el.equals(next)).findFirst().get();

        sb.append(target);
    }

    static class Solution {
        HashMap<Character, List<String>> map = new HashMap<>();

        public Solution() {
            map.put('2', Arrays.asList("a", "b", "c"));
            map.put('3', Arrays.asList("d", "e", "f"));
            map.put('4', Arrays.asList("g", "h", "i"));
            map.put('5', Arrays.asList("j", "k", "l"));
            map.put('6', Arrays.asList("m", "n", "o"));
            map.put('7', Arrays.asList("p", "q", "r", "s"));
            map.put('8', Arrays.asList("t", "u", "v"));
            map.put('9', Arrays.asList("w", "x", "y", "z"));
        }

        public List<String> letterCombinations(String digits) {

            List<List<String>> all = new ArrayList<>();

            for (char ch : digits.toCharArray()) all.add(map.get(ch));
            return null;
        }
    }
}


