package design.searchAutocompleteSystem.workableState;

import java.util.*;
import java.util.stream.Collectors;

public class AutocompleteSystem {

    public static int wordId = 0;

    static HashMap<String, Integer> stringIndex = new HashMap<>();
    static HashMap<Integer, Sentence> mapIndexString = new HashMap<>();

    {
        wordId = 0;
        mapIndexString = new HashMap<>();
        stringIndex = new HashMap<>();
    }

    Trie trie = new Trie();

    StringBuilder word = new StringBuilder();

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            trie.addWord(sentences[i], times[i], wordId++);
        }
    }

    public List<String> input(char c) {
        List<Sentence> res = null;

        if (c == '#') {
            trie.addInputedWord(word.toString(), getId(word.toString()));
            word = new StringBuilder();
            return Collections.emptyList();
        } else {
            word.append(c);
            res = trie.search(word.toString());
        }

        if (res.isEmpty()) return Collections.emptyList();

        List<String> collect = res.stream()
                .sorted(Sentence::compare)
                .limit(3)
                .map(s -> s.str)
                .collect(Collectors.toList());
        return collect;
    }

    private Integer getId(String word) {
        Integer indexOrDefault = stringIndex.getOrDefault(word, wordId++);
        stringIndex.put(word, indexOrDefault);
        return indexOrDefault;
    }
}

class Trie {
    TrieNode root = new TrieNode();

    public void addInputedWord(String sentence, int wordId) {
        TrieNode node = this.root;
        char[] chars = sentence.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!node.contains(chars[i])) {
                node.put(chars[i], new TrieNode(), wordId);
            }
            node.add(wordId);
            node = node.get(chars[i]);
        }
        node.add(wordId);
        node.setEnd();
        node.setTime(node.getTime() + 1);
        node.setAllWord(sentence);

        AutocompleteSystem.mapIndexString.put(wordId, new Sentence(sentence, node.getTime()));
        AutocompleteSystem.stringIndex.put(sentence, wordId);
    }

    public void addWord(String sentence, int time, int wordId) {
        TrieNode node = this.root;
        char[] chars = sentence.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!node.contains(chars[i])) {
                node.put(chars[i], new TrieNode(), wordId);
            }
            node.add(wordId);
            node = node.get(chars[i]);
        }
        node.add(wordId);
        node.setEnd();
        node.setTime(time);
        node.setAllWord(sentence);

        AutocompleteSystem.mapIndexString.put(wordId, new Sentence(sentence, time));
        AutocompleteSystem.stringIndex.put(sentence, wordId);
    }

    public List<Sentence> search(String str) {
        TrieNode node = this.root;
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (!node.contains(chars[i])) {
                return Collections.emptyList();
            }

            node = node.get(chars[i]);
        }

        List<Sentence> res = new ArrayList<>();

        for (Integer index : node.indexes) {
            res.add(AutocompleteSystem.mapIndexString.get(index));
        }

        return res;
    }
}

class Sentence {
    public int times;
    public String str;

    public Sentence(String word, int time) {
        this.str = word;
        this.times = time;
    }

    public int compare(Sentence that) {
        if (that.times < this.times) return -1;
        else if (that.times > this.times) return 1;
        else return this.str.compareTo(that.str);
    }
}

class TrieNode {
    TrieNode[] letters = new TrieNode[27];
    public Set<Integer> indexes = new HashSet<>();
    private boolean end;
    private int time;
    private String allWord;

    public boolean contains(char ch) {
        if (ch == ' ') return letters[26] != null;
        return letters[ch - 'a'] != null;
    }

    public void put(char ch, TrieNode node, int wordId) {
        indexes.add(wordId);
        if (ch == ' ') letters[26] = node;
        else letters[ch - 'a'] = node;
    }

    public TrieNode get(char ch) {
        if (ch == ' ') return letters[26];
        return letters[ch - 'a'];
    }

    public void setEnd() {
        this.end = true;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setAllWord(String sentence) {
        this.allWord = sentence;
    }

    public boolean isEnd() {
        return this.end;
    }

    public List<Sentence> getAllWords() {
        List<Sentence> res = new ArrayList<>();

        func(this, res);

        return res;
    }

    private void func(TrieNode letter, List<Sentence> res) {

        if (letter.isEnd()) res.add(new Sentence(letter.allWord, letter.time));

        for (int i = 0; i < letter.letters.length; i++) {
            if (letter.letters[i] != null) {
                func(letter.letters[i], res);
            }
        }
    }

    public int getTime() {
        return this.time;
    }

    public void add(int wordId) {
        indexes.add(wordId);
    }
}
