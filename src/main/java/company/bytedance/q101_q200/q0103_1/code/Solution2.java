package company.bytedance.q101_q200.q0103_1.code;

import utils.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, list, 0);
        return list;
    }

    private void dfs(TreeNode root, List<List<Integer>> list, int floor) {
        if (root == null) return;
        if (floor == list.size()) list.add(new LinkedList<Integer>());
        LinkedList subList = (LinkedList) list.get(floor);
        if (floor % 2 == 1) subList.addFirst(root.val);
        else subList.addLast(root.val);
        dfs(root.left, list, floor + 1);
        dfs(root.right, list, floor + 1);
    }
}