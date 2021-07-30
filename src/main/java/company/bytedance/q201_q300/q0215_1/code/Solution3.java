package company.bytedance.q201_q300.q0215_1.code;

import java.util.PriorityQueue;

/**
 * 利用大根堆实现 o(n*log(k))
 *
 * 使用PriorityQueue方式
 */
public class Solution3 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }


    public int findKthLargest1(int[] nums, int k) {
        int len = nums.length;
        // 默认情况下PriorityQueue使用自然排序法，最小元素先出列
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k + 1);

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                // 此时有 k+1 个元素，弹出堆顶元素
                minHeap.poll();
            }
        }
        // 最后小顶堆只剩 k 个元素，返回堆顶元素
        return minHeap.peek();
    }


    public int findKthLargest2(int[] nums, int k) {
        // 创建一个小顶堆（优先队列模拟）
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        // 在堆中维护当前最大k个元素
        for (int i = 0; i < nums.length; i++) {
            if (heap.size() < k) {
                heap.add(nums[i]);
            } else if (heap.element() < nums[i]) {
                heap.poll();
                heap.add(nums[i]);
            }
        }
        return heap.poll();
    }
}


