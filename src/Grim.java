import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 贪心算法(Grim Algorithum)
 *
 */
public class Grim {
    final static int INF = Integer.MAX_VALUE;

    public  static int[] prim(int[][] matrix){
    List <Integer> reachedVertixList = new ArrayList<>();

    // choose point 0 as initial point (将点0设置为起始点)
        reachedVertixList.add(0);
        // create minimum creating tree array and set the first element to -1 (创建最小生成树并将第一个元素设置为-1)
            int[] parents = new int[matrix.length];
            parents[0] = -1;

        // side weight 边位权重
            int weight;

        // source point index
            int fromIndex = 0;
        // target point index
            int toIndex = 0;

            while (reachedVertixList.size() < matrix.length){
                weight = INF;
                // Search the nearest side from current attached point
                for(Integer vertexIndex : reachedVertixList){
                    for(int i = 0; i < matrix.length; i++){
                        if (!reachedVertixList.contains(i)){
                            if (matrix[vertexIndex][i] < weight){
                                fromIndex = vertexIndex;
                                toIndex = i;
                                weight = matrix[vertexIndex][i];
                            }
                        }
                    }
                }
                // confirm the point with least weight
                    reachedVertixList.add(toIndex);

                // add into the minimum creating tree
                parents[toIndex] = fromIndex;
            }
        return parents;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 4, 3, INF, INF},
                {4, 0, 8, 7, INF},
                {3, 8, 0, INF, 1},
                {INF, 7, INF, 0, 9},
                {INF, INF, 1, 9, 0}
        };
                int[] parents = prim(matrix);
        System.out.println(Arrays.toString(parents));

        int[][] matrix2 = new int[][]{
                {3, 7, 1, INF, INF, 9, 4},
                {9, 3, 4, INF, 2, 1, INF},
                {2, 9, 0, 1, 7, INF, 3},
                {3, 7, 4, 5, 6, 9, INF},
                {2, 3, 7, 4, INF, 1, 6},
                {3, 3, 2, 1, 7, INF, 9}
        };
        int[] parents2 = prim(matrix2);
        System.out.println(Arrays.toString(parents2));
    }
}
