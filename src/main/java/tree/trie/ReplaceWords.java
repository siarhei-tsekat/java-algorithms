package tree.trie;

import java.util.Arrays;
import java.util.List;

public class ReplaceWords {

    public static void main(String[] args) {
        System.out.println(replaceWords(Arrays.asList("cat", "bat", "rat"),"the cattle was rattled by the battery"));
    }

    public static String replaceWords(List<String> dict, String sentence) {
        TrieStorage trie = new TrieStorage();

        for (String strFromDict : dict) {
            trie.insert(strFromDict);
        }

        StringBuilder sb = new StringBuilder();

        for (String wordFromSentence : sentence.split(" ")) {
            if (sb.length() > 0)
                sb.append(" ");
            TNode cur = trie.searchPrefixFor(wordFromSentence);
            sb.append(cur.isEnd ? cur.word : wordFromSentence);
        }
        return sb.toString();
    }


}

class TrieStorage {
    TNode root;

    public TrieStorage() {
        root = new TNode();
    }

    public void insert(String word) {
        TNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.contains(ch)) {
                node.put(ch, new TNode());
            }
            node = node.get(ch);
        }
        node.word = word;
        node.setEnd();
    }

    public TNode searchPrefixFor(String word) {
        TNode node = this.root;
        for (char letter : word.toCharArray()) {
            if (!node.contains(letter) || node.isEnd) {
                break;
            }
            node = node.get(letter);
        }
        return node;
    }
}

class TNode {
    String word;
    TNode[] arr = new TNode[26];
    boolean isEnd;

    public boolean contains(char ch) {
        return arr[ch - 'a'] != null;
    }

    public void put(char ch, TNode tNode) {
        arr[ch - 'a'] = tNode;
    }

    public TNode get(char ch) {
        return arr[ch - 'a'];
    }

    public void setEnd() {
        this.isEnd = true;
    }
}
