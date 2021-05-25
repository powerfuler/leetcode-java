package q021_030.q022_括号生成;

/*
*/

import q021_030.q022_括号生成.code.Solution2;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        long t4 = System.currentTimeMillis();
        List<String> strings = new Solution2().generateParenthesis(2);
        long t5 = System.currentTimeMillis();
        System.out.println(strings);
    }
}
