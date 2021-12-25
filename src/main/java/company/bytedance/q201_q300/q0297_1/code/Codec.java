package company.bytedance.q201_q300.q0297_1.code;

import utils.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Codec {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTestData("[1,2,3,null,null,4,5]");
        String serialize = new Codec().serialize(treeNode);
        System.out.println(serialize);

        TreeNode deserialize = new Codec().deserialize(serialize);
        TreeNode.print(deserialize);

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "{}";
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);
            if (node == null) {
                continue;
            }
            list.add(node.left);
            list.add(node.right);
        }
        while (list.get(list.size() - 1) == null) {
            list.remove(list.size() - 1);
        }
        StringBuilder sb = new StringBuilder("{");
        sb.append(list.get(0).val);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) != null) {
                sb.append("," + list.get(i).val);
            } else {
                sb.append(",#");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("{}")) return null;
        String[] datas = data.substring(1, data.length() - 1).split(",");
        boolean isLeft = true;
        List<TreeNode> result = new ArrayList<>();
        TreeNode node = new TreeNode(Integer.parseInt(datas[0]));
        result.add(node);
        int index = 0;
        for (int i = 1; i < datas.length; i++) {
            if (!datas[i].equals("#")) {
                TreeNode node1 = new TreeNode(Integer.parseInt(datas[i]));
                if (isLeft) {
                    result.get(index).left = node1;
                } else {
                    result.get(index).right = node1;
                }
                result.add(node1);
            }
            if (!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        }
        return result.get(0);
    }
}