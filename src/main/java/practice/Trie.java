package practice;

public class Trie {

    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {

        return false;
    }
}

class TrieNode {

}

class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println("Expected: true. Actual: " + trie.search("apple"));
        System.out.println("Expected: false. Actual: " + trie.search("app"));
        System.out.println("Expected: true. Actual: " + trie.startsWith("app"));
        trie.insert("app");
        System.out.println("Expected: true. Actual: " + trie.search("app"));
    }
}
