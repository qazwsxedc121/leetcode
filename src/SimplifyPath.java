public class SimplifyPath {
    public String simplifyPath(String path){
        String[] paths = path.split("/");
        String[] stack = new String[paths.length];
        if(path.length() == 0) return "/";
        int p = 0;
        for(int i = 1; i < paths.length; i += 1){
            if(paths[i].equals(".") || paths[i].equals(""))
                continue;
            if(p == 0){
                if(!paths[i].equals("..")) {
                    stack[p] = paths[i];
                    p += 1;
                }
            }else{
                if(!stack[p-1].equals("..") && paths[i].equals("..")){
                    p -= 1;
                }else{
                    stack[p] = paths[i];
                    p += 1;
                }
            }
        }
        String res = "";
        if(p == 0) return "/";
        for(int i = 0; i < p; i += 1){
            res += "/" + stack[i];
        }
        return res;
    }
    public static void test(){
        SimplifyPath instance = new SimplifyPath();
        System.out.println(instance.simplifyPath("/a/./b/../../c/"));
    }
}
