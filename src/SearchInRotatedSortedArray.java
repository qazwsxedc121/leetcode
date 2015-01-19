/**
 * User: guoxc
 * Date: 15-1-19
 * Time: 9:08
 */
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target){
        int l = 0;
        int r = A.length;
        while(true){
            if(l >= r) return -1;
            int mid = (l + r - 1) / 2;
            if(mid == l){
                if(A[mid] == target) return mid;
                else if(A[r-1] == target) return r-1;
                else return -1;
            }
            int a = A[l];
            int b = A[mid];
            int c = A[r - 1];

            if(a < c){//sorted
                if(target == b){
                    return mid;
                }else if(target < b){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }else if(b > a){// left sorted c < a < b
                if(b == target){
                    return mid;
                }else if(target < b && target >= a){
                    r = mid;
                }else if(target > b || target < a){
                    l = mid + 1;
                }
            }else{// right sorted b < c < a
                if(b == target){
                    return mid;
                }else if(target > b && target <= c){
                    l = mid + 1;
                }else if(target < b || target > c){
                    r = mid;
                }
            }
        }
    }
    public static void test(){
        SearchInRotatedSortedArray instance = new SearchInRotatedSortedArray();
        int[] A = new int[]{4,5,6,7,0,1,2};
        int[] B = new int[]{3,1};
//        System.out.println(instance.search(A,4));
//        System.out.println(instance.search(A,3));
        System.out.println(instance.search(B,1));
    }
}
