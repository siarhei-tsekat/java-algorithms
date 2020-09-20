package tmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Soluttion {

    public List<String> commonChars(String[] A) {
        List<String> commonChars = new ArrayList<>();

        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);

        for(String str : A) {
            int[] cnt = new int[26];

            str.chars().forEach(c -> ++cnt[c - 'a']);

            for(int i =0; i< 26; i++) {
                count[i] = Math.min(count[i], cnt[i]);
            }
        }

        for(int i =0; i< 26; i++) {
            while(count[i]-- > 0) commonChars.add(Character.toString((char)(i + 'a'))); // character index to string
        }

        return commonChars;
    }
}
class  R {
    public static void main(String[] args) {
        System.out.println(new Soluttion().commonChars(new String[]{"bbbbb","label","robler"}));;
    }
}
