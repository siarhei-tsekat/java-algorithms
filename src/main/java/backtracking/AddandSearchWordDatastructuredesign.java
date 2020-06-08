package backtracking;

class AddandSearchWordDatastructuredesign {
    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();

        dictionary.addWord("jessica");
        dictionary.addWord("mike");
        dictionary.addWord("a");
        dictionary.addWord("a");

        System.out.println("mike exist: " + dictionary.search("mike"));
        System.out.println("jessica exist: " + dictionary.search("jessica"));
        System.out.println("jessi exist: " + dictionary.search("jessi"));
        System.out.println("jes..ca exist: " + dictionary.search("jes..ca"));
        System.out.println("a exist: " + dictionary.search("a"));
        System.out.println(".a exist: " + dictionary.search(".a"));
        System.out.println("a. exist: " + dictionary.search("a."));
    }
}

class WordDictionary {
    private Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.add(word);
    }

    public boolean search(String word) {
        return trie.searchWithDot(word);
    }
}

class Trie {
    Node root = new Node();

    public void add(String word) {
        Node node = this.root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.contains(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node node = this.root;
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (node.contains(arr[i])) {
                node = node.get(arr[i]);
            } else return false;
        }
        return node != null && node.isEnd();
    }

    public boolean searchWithDot(String word) {
        Node node = this.root;
        char[] chars = word.toCharArray();
        return func(chars, 0, node);
    }

    private boolean func(char[] chars, int i, Node node) {

        if (i == chars.length) return node.isEnd();

        if (chars[i] == '.') {
            for (Node nod : node.getAll()) {
                if (nod != null)
                    if (func(chars, i + 1, nod)) return true;
            }
            return false;
        } else if (node.contains(chars[i])) {
            return func(chars, i + 1, node.get(chars[i]));
        } else return false;
    }
}

class Node {
    Node[] letters = new Node[26];
    private boolean isEnd;

    public boolean contains(char ch) {
        return letters[ch - 'a'] != null;
    }

    public void put(char ch, Node node) {
        letters[ch - 'a'] = node;
    }

    public Node get(char ch) {
        return letters[ch - 'a'];
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd() {
        this.isEnd = true;
    }

    public Node[] getAll() {
        return letters;
    }
}


