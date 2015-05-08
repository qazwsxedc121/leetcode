/**
 * Created by Administrator on 2015/5/8.
 */
class TrieNode {
    // Initialize your data structure here.
    private TrieNode[] sub;
    public boolean ends;
    public TrieNode() {
        sub = new TrieNode[26];
        ends = false;
    }
    public TrieNode getSub(int i){
        return sub[i];
    }
    public void setSub(int i){
        sub[i] = new TrieNode();
        return;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i += 1){
            char c = word.charAt(i);
            if(node.getSub(c-'a') == null){
                node.setSub(c-'a');
                node = node.getSub(c-'a');
            }else {
                node = node.getSub(c-'a');
            }
        }
        node.ends = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i += 1){
            char c = word.charAt(i);
            if(node.getSub(c-'a') == null){
                return false;
            }
            node = node.getSub(c-'a');
        }
        return node.ends == true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i += 1){
            char c = prefix.charAt(i);
            if(node.getSub(c-'a') == null){
                return false;
            }
            node = node.getSub(c-'a');
        }
        return true;
    }
}