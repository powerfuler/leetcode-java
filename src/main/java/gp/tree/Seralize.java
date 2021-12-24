package gp.tree;

import utils.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Seralize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "{}";
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        // [1,2,3,null,null,4,5,null,null,null,null]
        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);
            if (node == null) {
                continue;
            }
            list.add(node.left);
            list.add(node.right);
        }
        // [1,2,3,null,null,4,5]
        while (list.get(list.size() - 1) == null) {
            list.remove(list.size() - 1);
        }
        StringBuilder sb = new StringBuilder("{");
        sb.append(list.get(0).val);
        // {1,2,3,#,#,4,5}
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append("," + list.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("{}")) {
            return null;
        }
        // String[] data 1 2 3 # # 4 5
        String[] datas = data.substring(1, data.length() - 1).split(",");
        boolean isLeft = true;
        List<TreeNode> queue = new ArrayList<>();
        TreeNode node = new TreeNode(Integer.parseInt(datas[0]));
        queue.add(node);
        int index = 0;
        for (int i = 1; i < datas.length; i++) {
            if (!datas[i].equals("#")) {
                TreeNode node1 = new TreeNode(Integer.parseInt(datas[i]));
                if (isLeft) {
                    queue.get(index).left = node1;
                } else {
                    queue.get(index).right = node1;
                }
                queue.add(node1);
            }
            
            if (!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        }
        return queue.get(0);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
