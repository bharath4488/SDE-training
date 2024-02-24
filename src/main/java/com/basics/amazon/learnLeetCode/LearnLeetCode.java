package com.basics.amazon.learnLeetCode;

import com.basics.amazon.learnLeetCode.problems.array.AllAnagramsInSubArray;
import com.basics.amazon.learnLeetCode.problems.array.MaxSumArraySum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LearnLeetCode {
    public static void main(String[] args){

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(MaxSumArraySum.solve(nums));

        Map<Integer, String> map1 = new HashMap<Integer, String>();
        Map<Integer, String> map2 = new HashMap<Integer, String>();

        map1.put(0, "s");
        map2.put(0, "s");
        System.out.println(AllAnagramsInSubArray.solve("cbaebabacd", "abc"));
    }
}
