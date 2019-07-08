import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 239. Sliding Window Maximum
 *
 *  Given an integer array num[] and a window size k,
 *  find the sling window maxium over the array
 *  Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 *  Output: [3,3,5,5,6,7]
 *
 *
 *  O(nlog(n)) solution using MaxHeap
 *
 *  Follow up: Can you solve in linear time?
 */

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];

        int[] result = new int[nums.length - k +1];

        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(k,
                Collections.reverseOrder());

        for(int i=0;i< k;i++){
            maxheap.add(nums[i]);
        }

        for(int i=k;i<nums.length;i++){
            result[i-k] = maxheap.peek();
            maxheap.remove(nums[i-k]);
            maxheap.add(nums[i]);
        }

        result[result.length-1] = maxheap.peek();

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        int[] output1 = obj.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        Arrays.stream(output1).forEach(x -> System.out.print(x + " "));
    }
}
