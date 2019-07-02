import java.lang.reflect.Array;
import java.util.Arrays;

public class BinaryHeap {
    /**
     * 上浮调整
     * @param array
     */
    public  static  void upAdjust(int array[]){
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1)/2;
        // 用temp保存叶子节点值
        int temp = array[childIndex];

        if(childIndex > 0 && temp > parentIndex){
            // 无需单项交换
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * 下沉调整
     * @param array
     * @param parentIndex
     * @param length
     */
    public static void downAdjust(int array[], int parentIndex,int length){
        // temp 保存父节点值, 用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while(childIndex < array.length){
            // 如果有右子节点且右子节点的值小于左子节点,
            if(childIndex + 1 < length && array[childIndex + 1] < array[childIndex]){
                childIndex ++;
            }
            // 如果父节点小于任何一个子节点
            if (temp <= array[childIndex]){
                break;
            }
            // 无需单项交换
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    public static void buildHeap(int[] array){
        // 从最后一个非叶子节点开始, 依次向下调整
        for (int i = array.length / 2; i > 0; i--){
            downAdjust(array, i, array.length - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        upAdjust(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        buildHeap(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
