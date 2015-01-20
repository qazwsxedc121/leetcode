/**
 * Created by Administrator on 2015/1/19.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target){
        int l = 0;
        int r = A.length - 1;
        while(true){
            if(target < A[l]){
                return l;
            }else if(target > A[r]){
                return r + 1;
            }else if(target == A[l]){
                return l;
            }else if(target == A[r]){
                return r;
            }

            // A[l] < target < A[r]
            int mid = (l + r) / 2;
            if(mid == l){//r - l = 1
                return r;
            }
            if(A[mid] == target){
                return mid;
            }else if(target < A[mid]){
                r = mid - 1;
            }else{
                l = mid + 1;
            }


        }
    }
    public static void test(){
        SearchInsertPosition instance = new SearchInsertPosition();
        int[] A = new int[]{1,3,5,6};
        System.out.println(instance.searchInsert(A,5));
        System.out.println(instance.searchInsert(A,2));
        System.out.println(instance.searchInsert(A,7));
        System.out.println(instance.searchInsert(A,0));
    }
}
