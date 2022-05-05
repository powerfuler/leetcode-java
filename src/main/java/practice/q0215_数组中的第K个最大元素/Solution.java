package practice.q0215_数组中的第K个最大元素;

import java.util.PriorityQueue;

/**
 * 小根堆实现
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int n : nums) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }

    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k,(n1, n2) -> n1 - n2);
        for (int n : nums) {
            int size = minHeap.size();
            Integer peek = minHeap.peek();
            if(size >= k){
                if(peek < n){
                    minHeap.poll();
                    minHeap.add(n);
                }
            }else {
                minHeap.add(n);
            }
        }
        return minHeap.poll();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1, 5, 6};
        int kthLargest = new Solution().findKthLargest1(nums1, 2);
        System.out.println(kthLargest);
    }
}