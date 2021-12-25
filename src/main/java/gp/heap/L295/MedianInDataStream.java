package gp.heap.L295;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        int count = nums.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(count, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(count);
        int[] answer = new int[count];
        int number = nums[0];
        answer[0] = number;
        for (int i = 1; i < count; i++) {
            if (nums[i] > number) {
                minHeap.add(nums[i]);
            } else {
                maxHeap.add(nums[i]);
            }
            if (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(number);
                    number = minHeap.poll();
                } else {
                    minHeap.add(number);
                    number = maxHeap.poll();
                }
            } else {
                if (maxHeap.size() - minHeap.size() == 1 && maxHeap.peek() < number) {
                    minHeap.add(number);
                    number = maxHeap.poll();
                }
            }
            answer[i] = number;
        }
        return answer;
    }
}

//maxHeap number   minHeap
