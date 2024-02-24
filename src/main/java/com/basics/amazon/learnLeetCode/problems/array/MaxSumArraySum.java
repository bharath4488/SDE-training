package com.basics.amazon.learnLeetCode.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumArraySum {
    public static int solve(int[] nums) {

        int[] tempNums = new int[nums.length];
        tempNums[0] = nums[0];
        int sol = nums[0];

        for (int i = 1; i < nums.length; i++) {
            tempNums[i] = Math.max(tempNums[i-1] + nums[i], nums[i]);
        }

        for (int num: tempNums) {
            if (sol < num) sol = num;
        }
        return sol;
    }
}
