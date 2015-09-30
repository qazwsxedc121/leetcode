import java.util.*;

public class WordSearchII {
    private class Trie{
        public Trie[] subNodes;
        public boolean isLeaf;
        public String path;
        public Trie(){
            subNodes = new Trie[26];
            isLeaf = false;
            path = "";
        }
    }
    private Trie build(List<String> words, String path){
        Trie root = new Trie();
        root.path = path;
        Map<Integer, List<String>> words26 = new HashMap<Integer, List<String>>();
        for(String s : words){
            if(s.equals("")){
                root.isLeaf = true;
                continue;
            }
            int cw = s.charAt(0) - 'a';
            if(!words26.containsKey(cw)){
                words26.put(cw, new ArrayList<String>());
            }
            words26.get(cw).add(s.substring(1));
        }
        for(int cw : words26.keySet()){
            root.subNodes[cw] = build(words26.get(cw), path + ((char)(cw + 'a')));
        }
        return root;
    }
    private boolean dfs(char[][] board, int ay, int ax, Trie root){
        if(root == null) return false;
        int m = board.length;
        int n = board[0].length;
        char boardc = board[ay][ax];
        board[ay][ax] = '.';
        if(ay > 0 && board[ay-1][ax] != '.'){
            int cw = board[ay-1][ax] - 'a';
            dfs(board, ay-1, ax, root.subNodes[cw]);
        }
        if(ay < m - 1 && board[ay+1][ax] != '.'){
            int cw = board[ay+1][ax] - 'a';
            dfs(board, ay+1, ax, root.subNodes[cw]);
        }
        if(ax > 0 && board[ay][ax-1] != '.'){
            int cw = board[ay][ax-1] - 'a';
            dfs(board, ay, ax-1, root.subNodes[cw]);
        }
        if(ax < n - 1 && board[ay][ax+1] != '.'){
            int cw = board[ay][ax+1] - 'a';
            dfs(board, ay, ax+1, root.subNodes[cw]);
        }
        board[ay][ax] = boardc;
        if(root.isLeaf){
            resSet.add(root.path);
        }
        return true;
    }
    public Set<String> resSet;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> wordl = new ArrayList<String>();
        int nw = words.length;
        for(int i = 0; i < nw; i += 1){
            wordl.add(words[i]);
        }
        Trie root = build(wordl, "");
        List<String> res = new ArrayList<String>();
        resSet = new HashSet<String>();
        int n = board.length;
        if(n == 0) return res;
        int m = board[0].length;
        if(m == 0) return res;
        for(int i = 0; i < m; i += 1){
            for(int j = 0; j < n; j += 1){
                dfs(board, i, j, root);
            }
        }
        for(String s: resSet){
            res.add(s);
        }
        return res;
    }
    public static void test(){
        char[][] board = new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = new String[]{"oath","pea","eat","rain"};
        WordSearchII w = new WordSearchII();
        System.out.println(w.findWords(board,words));
    }
}
