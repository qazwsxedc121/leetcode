import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int L){
        List<String> res = new ArrayList<String>();
        int i = 0;
        while(true){
            int c = 0;
            int start = i;
            int wc = 0;
            while(c < L + 2 && i < words.length){
                c += words[i].length() + 1;
                wc += 1;
                i += 1;
            }
            if(c < L + 2){// not enough words to make one line
                res.add(lineLeftJustify(words, start, i, L));
                break;
            }
            wc -= 1;
            c -= words[i - 1].length() + 2;
            i -= 1;
            if(wc == 1){// one word
                res.add(lineLeftJustify(words, start, start + 1, L));
            }else{
                String line = lineFullJustify(words, start, i, L, c);
                res.add(line);
            }
        }
        return res;
    }
    private String lineLeftJustify(String[] words, int start, int end, int L){
        String res = "";
        for(int i = start; i < end; i += 1){
            res += words[i];
            if(res.length() < L){
                res += " ";
            }
        }
        while(res.length() < L){
            res += " ";
        }
        return res;
    }
    private String lineFullJustify(String[] words, int start, int end, int L, int c){
        int wc = end - start;
        int spaceToAdd = L - c + wc - 1;
        int[] spaces = new int[wc - 1];
        for(int j = 0; j < spaceToAdd; j += 1){
            spaces[j % (wc - 1)] += 1;
        }
        String line = "";
        for(int j = 0; j < wc - 1; j += 1){
            line += words[j + start];
            for(int k = 0; k < spaces[j]; k += 1){
                line += " ";
            }
        }
        line += words[wc + start - 1];
        return line;
    }
    private static String lines2str(List<String> lines){
        String res = "";
        for(int i = 0;i < lines.size(); i += 1){
            res += "|";
            res += lines.get(i);
            res += "|\n";
        }
        return res;
    }
    public static void test(){
        TextJustification instance = new TextJustification();
        System.out.println(lines2str(instance.fullJustify(new String[]{
                "This", "is", "an", "example", "of", "text", "justification."
        }, 16)));
    }
}
