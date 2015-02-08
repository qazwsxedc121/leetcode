public class ClimbingStairs {
    public int climbStairs(int n){
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }else{
            int a = 1;
            int b = 2;
            for(int i = 3; i <= n; i += 1){
                int c = a + b;
                a = b;
                b = c;
            }
            return b;
        }
    }
    public static void test(){
        ClimbingStairs instance = new ClimbingStairs();
        System.out.println(instance.climbStairs(4));
    }
}
