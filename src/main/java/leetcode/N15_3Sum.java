package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by langji on 12/01/2020.
 */
public class N15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        return threeSumByHash(nums);
    }

    private List<List<Integer>> threeSumByHash(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<List<Integer>> resultSet = new HashSet<>();
        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            for (int j = i+1; j < nums.length; ++j) {
                if (hashSet.contains(nums[j])) {
                    resultSet.add(getSortedList(nums[i], nums[j], -nums[i]-nums[j]));
                } else {
                    hashSet.add(-nums[i]-nums[j]);
                }
            }
            hashSet.clear();
        }

        return new ArrayList<>(resultSet);
    }

    private List<Integer> getSortedList(int a, int b, int c) {
        int[] nums = new int[]{a,b,c};
        Arrays.sort(nums);
        return Arrays.asList(nums[0], nums[1], nums[2]);
    }
}
