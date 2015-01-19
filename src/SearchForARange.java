import java.util.Arrays;

/**
 * User: guoxc
 * Date: 15-1-19
 * Time: 9:54
 */
public class SearchForARange {
    public int[] searchRange(int[] A, int target){
        return searchRangeIter(A,0,A.length-1,target);
    }
    public int[] searchRangeIter(int[] A, int l, int r, int target){
        if(target < A[l] || target > A[r]){
            return new int[]{-1,-1};
        }else if(A[l] == target && A[r] == target){
            return new int[]{l,r};
        }else if(A[l] == target && target < A[r]){
            int mid = (l + r) / 2;
            if(mid == l){
                return new int[]{l,l};
            }
            if(A[mid] == target){
                int[] res = searchRangeIter(A,mid,r,target);
                return new int[]{l,res[1]};
            }else{
                int[] res = searchRangeIter(A,l,mid,target);
                return res;
            }
        }else if(target > A[l] && target == A[r]){
            int mid = (l + r)/2;
            if(mid == l){
                return new int[]{r,r};
            }
            if(A[mid] == target){
                int[] res = searchRangeIter(A,l,mid,target);
                return new int[]{res[0],r};
            }else{
                int[] res = searchRangeIter(A,mid,r,target);
                return res;
            }
        }else{
            int mid = (l + r) / 2;
            if(mid == l){
                return new int[]{-1,-1};
            }
            if(A[mid] == target){
                int[] res1 = searchRangeIter(A,l,mid,target);
                int[] res2 = searchRangeIter(A,mid,r,target);
                return new int[]{res1[0],res2[1]};
            }else if(target < A[mid]){
                return searchRangeIter(A,l,mid,target);
            }else{
                return searchRangeIter(A,mid,r,target);
            }
        }

    }
    public static void test(){
        SearchForARange instance = new SearchForARange();
        int[] A = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(instance.searchRange(A, 8)));
    }
}
