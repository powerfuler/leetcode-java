package q071_080.q071_2.code;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 *
 */
public class Solution1 {

    public String simplifyPath(String path) {
        // 双端队列
        Deque<String> queue = new LinkedList<>();
        // 分割字符
        String[] res = path.split("/");
        for (int i = 0; i < res.length; i++) {
            String s = res[i];
            if (s.equals(".") || s.equals("")) {
                continue;
            } else if (s.equals("..")) {
                if (!queue.isEmpty()) {
                    queue.pollLast();
                }
            } else {
                queue.offer(s);
            }
        }
        // 拼接
        StringBuilder sb = new StringBuilder("/");
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
            if (!queue.isEmpty()) {
                sb.append("/");
            }
        }
        // 判空
        return sb.toString().equals("") ? "/" : sb.toString();
    }

    public static void main(String[] args) {
//        String s = new Solution1().simplifyPath("/home/");
        String s = new Solution1().simplifyPath("/home//foo/");
        System.out.println(s);
    }
}
