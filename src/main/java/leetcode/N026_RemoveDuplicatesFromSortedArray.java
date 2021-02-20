package leetcode;

/**
 * Created by langji on 06/11/2019.
 */
public class N026_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        // make the copy as less as possible
        if (nums.length <= 1) return nums.length;

        int slow = 0, quick = 1;
        for (int i = 0; i < nums.length-1; ++i) {
            if (nums[slow] != nums[quick]) {
                ++slow;
                if (slow != quick) nums[slow] = nums[quick];
                ++quick;
            } else {
                quick++;
            }
        }

        return slow+1;
    }
}
