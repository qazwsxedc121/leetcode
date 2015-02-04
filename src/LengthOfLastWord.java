/**
 * User: guoxc
 * Date: 15-2-4
 * Time: 21:34
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s){
        char[] array = s.toCharArray();
        int lastSpace = -1;
        int res = 0;
        for(int i = 0; i < array.length; i += 1){
            if(array[i] == ' '){
                if(i - lastSpace - 1 > 0)
                    res = i - lastSpace - 1;
                lastSpace = i;
            }
        }
        if(lastSpace != array.length - 1){
            res = array.length - lastSpace - 1;
        }
        return res;
    }
    public static void test(){
        LengthOfLastWord instance = new LengthOfLastWord();
        System.out.println(instance.lengthOfLastWord("Hello World"));
        System.out.println(instance.lengthOfLastWord("Hello World "));
        System.out.println(instance.lengthOfLastWord("b a  "));
    }
}
