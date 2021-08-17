package q051_060.q056_1.code;


import java.util.*;

/**
 * 先根据start进行排序之后merge o(n*log(n))
 */
public class Solution1 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        int[] currInterval = intervals[0];
        List<int[]> resArr = new ArrayList<>();
        resArr.add(currInterval);

        for (int[] interval : intervals) {
            int currEnd = currInterval[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];

            if (currEnd >= nextBegin) {
                currInterval[1] = Math.max(currEnd, nextEnd);
            } else {
                currInterval = interval;
                resArr.add(currInterval);
            }
        }
        return resArr.toArray(new int[resArr.size()][]);
    }

    public static void main(String[] args) {
        int[][] merge = new Solution1().merge(new int[][]{{1, 3}, {10, 18}, {8, 10}, {2, 6}});
        for (int i = 0; i < merge.length; i++) {
            System.out.println(Arrays.stream(merge[i]).toArray());
        }
    }
}
