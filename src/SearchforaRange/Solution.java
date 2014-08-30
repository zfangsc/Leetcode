package SearchforaRange;

/**
 * Author: fangzhou
 * Date:   8/30/14.
 */
public class Solution {
    public int[] searchRange(int[] A, int target) {
        if(A.length == 0) {
            return new int[]{-1, -1};
        }
        int ind = binarySearch(A, target, 0, A.length-1, 0);
        int[] result = new int[]{ind, ind};
        if(ind == -1) {
            return result;
        }
        int first = binarySearch(A, target, 0, ind-1, -1);  // for floor
        int second = binarySearch(A, target, ind+1, A.length-1, 1); // for ceiling
        result[0] = first == -1 ? result[0] : first;
        result[1] = second == -1 ? result[1] : second;
        return result;
    }

    // if normal == 0 => normal binary search;    normal == -1 => find floor;   normal == 1 => find ceiling
    private int binarySearch(int[] A, int target, int i, int j, int normal) {
        while(i <= j) {
            int mid = i+(j-i)/2;
            if(A[mid] == target) {
                if(normal == -1) {
                    if(mid-1 >= i && A[mid-1] == target) {
                        return binarySearch(A, target, i, mid-1, normal);
                    }
                }
                if(normal == 1) {
                    if(mid+1 <= j && A[mid+1] == target) {
                        return binarySearch(A, target, mid+1, j, normal);
                    }
                }
                return mid;
            } else if(A[mid] < target) {
                i = mid+1;
            } else {
                j = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = new int[] {1,1,1,1,1,1,2,3,4,4,5,5,5,6,7,8,8,8,8};
        s.searchRange(a, 8);
    }
}
