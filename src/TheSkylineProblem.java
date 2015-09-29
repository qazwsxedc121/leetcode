import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/discuss/48638/java-570ms-430ms-divide-conquer-solution-with-explanation
 */
public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        return getSkyline(buildings, 0, buildings.length-1);
    }
    private ArrayList<int[]> getSkyline(int[][] buildings, int lo, int hi){
        ArrayList<int[]> result=new ArrayList<>();
        if(lo>hi)   return result;
        if(lo==hi){
            result.add(new int[]{buildings[lo][0], buildings[lo][2]});
            result.add(new int[]{buildings[lo][1], 0});
            return result;
        }
        int mid=(lo+hi)/2;
        ArrayList<int[]> left=getSkyline(buildings, lo, mid);
        ArrayList<int[]> right=getSkyline(buildings, mid+1, hi);
        int leftMax=0, rightMax=0, max=0;
        for(int i=0, j=0; i<left.size()||j<right.size(); ){
            int currentMax=0;
            if(i<left.size()&&j<right.size()&&left.get(i)[0]==right.get(j)[0]){
                leftMax=left.get(i)[1];
                rightMax=right.get(j)[1];
                currentMax=Math.max(leftMax, rightMax);
                if(currentMax!=max){
                    result.add(new int[]{left.get(i)[0], currentMax});
                    max=currentMax;
                }
                i++;
                j++;
            }
            else if(j>=right.size()||i<left.size()&&j<right.size()&&left.get(i)[0]<right.get(j)[0]){
                leftMax=left.get(i)[1];
                currentMax=Math.max(leftMax, rightMax);
                if(currentMax!=max){
                    result.add(new int[]{left.get(i)[0], currentMax});
                    max=currentMax;
                }
                i++;
            }
            else if(i>=left.size()||i<left.size()&&j<right.size()&&left.get(i)[0]>right.get(j)[0]){
                rightMax=right.get(j)[1];
                currentMax=Math.max(leftMax, rightMax);
                if(currentMax!=max){
                    result.add(new int[]{right.get(j)[0], currentMax});
                    max=currentMax;
                }
                j++;
            }
        }
        return result;
    }
}
