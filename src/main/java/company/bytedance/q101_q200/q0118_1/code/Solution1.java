package company.bytedance.q101_q200.q0118_1.code;

import java.util.ArrayList;
import java.util.List;

/**
 *输入: 5
 * 输出:
 * [
 *     	     [1],
 *    	 	[1,1],
 *   	   [1,2,1],
 *   	  [1,3,3,1],
 *  	 [1,4,6,4,1]
 * ]
 *
 */
public class Solution1 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        //给定的numRows为0时直接返回空集合即可
        if (numRows == 0) {
            return triangle;
        }

        //因为杨辉三角的第一行总是1，所以先新建一个list，并将1加入该list中
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        //从第二行开始，新建表示当前行的list，拿到当前行的前一行的list
        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            //一行中的第一个元素
            row.add(1);

            //针对每一行，都是上一行的相邻的两个元素相加得到两个1中间的数
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            //一行中的最后一个元素
            row.add(1);

            //最后将“整行添加到大集合中”
            triangle.add(row);
        }
        return triangle;
    }
}