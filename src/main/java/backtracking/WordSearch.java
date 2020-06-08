package backtracking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/***
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 */


class Runner {
    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "oathf", "eat", "rain"};

        WordSearch wordSearch = new WordSearch();
        List<String> result = wordSearch.findWords(board, words);
        System.out.println("Expected: " + "oath" + " " + "eat" + " " + "oathf");
        System.out.println("Actual: " + result);
    }
}

public class WordSearch {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    TrieStorage trie = new TrieStorage();
    HashSet<String> set = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            trie.addWord(words[i]);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (trie.anyWordStartsWith(board[i][j])) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(board[i][j]);
                    visited(i, j);
                    func(trie, board, i, j, sb, res);
                    set.clear();
                }
            }
        }
        return res.stream().collect(Collectors.toList());
    }

    private void func(TrieStorage trie, char[][] board, int row, int col, StringBuilder sb, Set<String> res) {
        if (trie.containsWord(sb.toString())) res.add(sb.toString());

        for (int i = 0; i < 4; i++) {
            int newR = directions[i][0] + row;
            int newC = directions[i][1] + col;

            if (valid(board, newR, newC) && !isVisited(newR, newC)) {
                visited(newR, newC);
                sb.append(board[newR][newC]);

                if (trie.contains(sb.toString())) func(trie, board, newR, newC, sb, res);

                unVisit(newR, newC);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private void unVisit(int newR, int newC) {
        set.remove("" + newR + newC);
    }

    private void visited(int newR, int newC) {
        set.add("" + newR + newC);
    }

    private boolean isVisited(int newR, int newC) {
        return set.contains("" + newR + newC);
    }

    private boolean valid(char[][] board, int row, int col) {
        return !(row < 0 || row >= board.length || col < 0 || col >= board[row].length);
    }
}

class TrieStorage {

    TrieNode root = new TrieNode();

    public void addWord(String word) {
        TrieNode node = this.root;
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (!node.contains(chars[i])) {
                node.put(chars[i], new TrieNode());
            }
            node = node.get(chars[i]);
        }
        node.setEnd();
    }

    public boolean anyWordStartsWith(char ch) {
        return root.contains(ch);
    }

    public boolean containsWord(String word) {
        TrieNode node = this.root;
        char[] chars = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            if (node.contains(chars[i])) {
                node = node.get(chars[i]);
            } else return false;
        }
        return node.isEnd();
    }

    public boolean contains(String word) {
        TrieNode node = this.root;
        char[] chars = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            if (node.contains(chars[i])) {
                node = node.get(chars[i]);
            } else return false;
        }
        return true;
    }

    class TrieNode {

        TrieNode[] letters = new TrieNode[26];
        private boolean isEnd;

        public boolean contains(char ch) {
            return letters[ch - 'a'] != null;
        }

        public void put(char ch, TrieNode node) {
            letters[ch - 'a'] = node;
        }

        public TrieNode get(char ch) {
            return letters[ch - 'a'];
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd() {
            return this.isEnd;
        }
    }
}

