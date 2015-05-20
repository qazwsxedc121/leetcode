/**
 * Created by Administrator on 2015/5/17.
 */
public class WordDictionary {
    private static class TrieNodeX{
        public TrieNodeX[] l = new TrieNodeX[26];
        public boolean end = false;
        public void add(String word, int idx){
            if(word.length() == idx){
                end = true;
                return;
            }
            int c = word.charAt(idx) - 'a';
            if(l[c] == null){
                l[c] = new TrieNodeX();
            }
            l[c].add(word,idx+1);
        }

        public boolean search(String word, int idx){
            if(word.length() == idx){
                return end;
            }
            Character c = word.charAt(idx);
            if(c == '.'){
                for(int i = 0; i < 26; i += 1){
                    if(l[i] != null && l[i].search(word, idx + 1)){
                        return true;
                    }
                }
                return false;
            }else {
                TrieNodeX next = l[c-'a'];
                if(next == null) return false;
                return next.search(word, idx + 1);
            }
        }
    }



    public TrieNodeX root;

    public WordDictionary(){
        root = new TrieNodeX();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        root.add(word, 0);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return root.search(word, 0);
    }
}