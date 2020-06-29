/*
Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
Greedy Works here! the below solution beats 99.87% */

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int y=nums.length;
        if(y<=1) return y;
        int max=0;
        int c=1;
        for(int i=1;i<y;i++){
            if(nums[i-1]<nums[i]) c++;
            else c=1;
            max=Math.max(max,c);
        }
        return max;
    }
}
