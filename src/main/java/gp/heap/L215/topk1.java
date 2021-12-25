package gp.heap.L215;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution1 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });

        for (int i : nums) {
            maxHeap.add(i);
        }

        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        return maxHeap.poll();
    }
}