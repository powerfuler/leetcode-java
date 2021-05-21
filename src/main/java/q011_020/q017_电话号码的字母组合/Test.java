package q011_020.q017_电话号码的字母组合;

/*
 */

import q011_020.q017_电话号码的字母组合.code.Solution2;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        long t1 = System.currentTimeMillis();
        Solution2 solution = new Solution2();
        List<String> stringList = solution.letterCombinations("273979797972");
        System.out.println(stringList);
        long t2 = System.currentTimeMillis();
        System.out.println("cost:" + (t2 - t1) + "ms,size:" + stringList.size());

    }
}
