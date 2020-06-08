package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterPermutations {
    private static int count = 0;

    public static int numTilePossibilities(String tiles) {
        char[] ch = tiles.toCharArray();
        Arrays.sort(ch);
        boolean[] visited = new boolean[tiles.length()];
        List<Character> list = new ArrayList<>();
        dfs(ch,0, visited, list);
        return count;
    }

    public static void dfs(char[] ch, int start, boolean[] visited, List<Character> list) {

        if (!list.isEmpty() && list.size() <= ch.length) {
            count++;
        }
        for (int i = start; i < ch.length; i++) {

            if (!visited[i]) {
                list.add(ch[i]);

                visited[i] = true;

                dfs(ch, start + 1, visited, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }

    }
}

