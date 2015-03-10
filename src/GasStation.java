/**
 * User: guoxc
 * Date: 15-3-10
 * Time: 17:25
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] tank = new int[n];
        int c = 0;
        for(int i = 0; i < n; i += 1){
            tank[i] = gas[i] - cost[i];
            c += tank[i];
        }
        if(c < 0) return -1;
        int[] seq = new int[n];
        int g = tank[0];
        int min = g;
        int max = 0;
        int maxi = 0;
        for(int i = 1; i < n; i += 1){
            g += tank[i];
            seq[i] = g;
            if(g < min){
                min = g;
            }
            if(tank[i] - seq[i] > max){
                max = tank[i] - seq[i];
                maxi = i;
            }
        }
        return max + min >= 0 ? maxi : -1;
    }
}
