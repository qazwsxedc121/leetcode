/**
 * User: guoxc
 * Date: 15-2-14
 * Time: 9:34
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] A, int target){
        int l = 0;
        int r = A.length - 1;
        int mid = (l + r) / 2;
        while(l <= r){
            while(l < A.length - 1 && A[l + 1] == A[l] && l >= mid){
                l += 1;
            }
            while(r > 1 && A[r - 1] == A[r] && r <= mid){
                r -= 1;
            }
            if(A[mid] == target || A[l] == target || A[r] == target){
                return true;
            }else{
                int mid_l = mid;
                int mid_r = mid;
                while(mid_l >= l && A[mid_l] == A[mid]){
                    mid_l -= 1;
                }
                mid_l += 1;
                while(mid_r <= r && A[mid_r] == A[mid]){
                    mid_r += 1;
                }
                mid_r -= 1;
                if(mid_l == l && mid_r == r){
                    return false;
                }else if(mid_l == l){
                    l = mid_r + 1;
                }else if(mid_r == r){
                    r = mid_l - 1;
                }else{
                    if(A[l] > A[mid]){
                        if(target < A[mid] || target > A[l]){
                            r = mid_l - 1;
                        }else{
                            l = mid_r + 1;
                        }
                    }else{
                        if(target < A[mid] && target > A[l]){
                            r = mid_l - 1;
                        }else{
                            l = mid_r + 1;
                        }
                    }
                }
                mid = (l + r) / 2;
            }
        }
        return false;
    }
    public static void test(){
        SearchInRotatedSortedArrayII s = new SearchInRotatedSortedArrayII();
//        System.out.println(s.search(new int[]{1,1,2,3,3,3,3,3,3,1,1}, 2));
//        System.out.println(s.search(new int[]{1}, 0));
//        System.out.println(s.search(new int[]{0,1,2,2}, 0));
        System.out.println(s.search(new int[]{1,1,3,1}, 3));
    }
}
