package array;

import java.util.HashMap;

public class FindWordsThatCanBeFormedbyCharacters {

    public static void main(String[] args) {
        String[] var = new String[]{"hello", "world", "leetcode"};
        System.out.println(countCharacters(var, "welldonehoneyr"));
    }

    public static int countCharacters(String[] words, String chars) {
        int resut = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> mapDubl = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            map.merge(chars.charAt(i), 1, ((oldV, newV) -> ++oldV));
        }

        for (int i = 0; i < words.length; i++) {
            boolean flag = true;

            for (int j = 0; j < words[i].length(); j++) {
                char key = words[i].charAt(j);
                Integer value = map.getOrDefault(key, 0);
                if (value == 0) {
                    flag = false;
                    break;
                } else {
                    int count = mapDubl.getOrDefault(key, value);
                    if (count <= 0) {
                        flag = false;
                        break;
                    } else {
                        mapDubl.put(key, count - 1);
                    }
                }
            }
            mapDubl.clear();
            if (flag) {

                resut += words[i].length();
            }
        }
        return resut;
    }
}
