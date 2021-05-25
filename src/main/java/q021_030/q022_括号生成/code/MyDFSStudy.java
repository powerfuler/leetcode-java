package q021_030.q022_括号生成.code;

import java.util.ArrayList;
import java.util.List;

/**
 * https://blog.csdn.net/qq_38737992/article/details/95635940
 *
 * 深度优先搜索(DFS) 的基本思想：
 * 从图中的某个顶点v出发，然后依次从未被访问的 v 的邻接点开始深度优先搜索，直至图中所有和 v 路径相通的顶点都被访问，然后选择另外一个没有被访问的顶点开始深度优先搜索。
 *
 * @Author syrdbt
 * @Date 2019/7/12 21:02
 */
public class MyDFSStudy {
    public List<Integer>[] map; // 存储图
    public boolean vis[]; // vis

    public MyDFSStudy(List<Integer>[] map, int n) {
        this.map = map;
        vis = new boolean[n];
    }

    public void dfs(int i) {
        System.out.print(" " + i + "-->");
        vis[i] = true;
        // 遍历邻接点
        for (int j = 0; j < map[i].size(); j++) {
            //System.out.println(map[i].get(j));
            if (vis[map[i].get(j)] == false) {
                this.dfs(map[i].get(j));
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<Integer>[] input = new ArrayList[9];
        for (int i = 0; i < 9; i++) {
            input[i] = new ArrayList<>();
        }
        input[1].add(2);
        input[2].add(1);
        input[1].add(3);
        input[3].add(1);
        input[2].add(4);
        input[4].add(2);
        input[2].add(5);
        input[5].add(2);
        input[3].add(6);
        input[6].add(3);
        input[3].add(7);
        input[7].add(3);
        input[4].add(8);
        input[8].add(4);
        input[5].add(8);
        input[8].add(5);
        input[6].add(7);
        input[7].add(6);
        MyDFSStudy myDFSStudy = new MyDFSStudy(input, 9);
        myDFSStudy.dfs(1);
    }
}