import java.lang.reflect.Array;

/**
 * 旋转二分查找
 */

public class RotatedBinaryTree {
    public static int rotatedBinaryTree(int[] array, int target) {
        int start = 0;
        int end = array.length;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if(array[mid] == target){
                return target;
            }
            // Case A: Rotation Point at left side of the median
            if(array[mid] > array[start]){
                // left element <= target < median
                if(array[start] <= target && target < array [mid]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // Case B: Rotation Point at right side of the median
            else{
                // median <= target < right
                if(array[mid] <= target && target < array[end]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return  -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{12, 14, 20, 26, 30, 2, 5, 7, 9};
        int a = rotatedBinaryTree(array, 20);
        System.out.println(a);
    }
}
