package company.bytedance.q101_q200.q0128_1.code;

import java.util.HashMap;
import java.util.Map;

class Solution3 {
    // roots 用来记录一个连通区域的代表元素
    private Map<Integer, Integer> roots = new HashMap<>();
    
    // counts 用来记录一个连通区域的元素个数
    private Map<Integer, Integer> counts = new HashMap<>();
    
    private int find(int a) {
        if (roots.get(a) == a)  {
            return a;
        }
        
        int root = find(roots.get(a));
        
        // 路径压缩
        roots.put(a, root);
        
        return root;
    }
    
    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA != rootB) {
            roots.put(rootA, rootB);
            
            // 两个连通区域合并，更新整个区域的元素个数
            counts.put(rootB, counts.get(rootA) + counts.get(rootB));
        }
    }
    
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (roots.containsKey(nums[i])) {
                continue;
            }
            
            roots.put(nums[i], nums[i]);
            counts.put(nums[i], 1);
            
            // 查看相邻元素是否存在连通区块
            if (roots.containsKey(nums[i] - 1) && roots.containsKey(nums[i] + 1)) {
                int root = find(roots.get(nums[i] - 1));
                
                // 左右都存在连通区域，合并这三个区域
                union(nums[i], root);
                union(root, roots.get(nums[i] + 1));
            } else if (roots.containsKey(nums[i] - 1)) {
                int root = find(roots.get(nums[i] - 1));
                
                // 左边存在连通区域，合并这这两个区域
                union(nums[i], root);
            } else if (roots.containsKey(nums[i] + 1)) {
                int root = find(roots.get(nums[i] + 1));
                
                // 右边存在连通区域，合并这这两个区域
                union(nums[i], root);
            }
        }
        
        int result = 1;
        
        // 遍历所有连通区块，找到包含元素最多的区块
        for (int i : counts.keySet()) {
            result = Math.max(result, counts.get(i));
        }
        
        return result;
    }
}