/*Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
Formally the function should:
Return true if there exists i, j, k
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
Example 1:
Input: [1,2,3,4,5]
Output: true
Example 2:
Input: [5,4,3,2,1]
Output: false
link:https://leetcode.com/problems/increasing-triplet-subsequence/
*/

class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3) return false;
        int first=Integer.MAX_VALUE;
        int second=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=first) first=nums[i];
            else if(nums[i]<=second) second=nums[i];
            else return true;
        }
        return false;
    }
}

/*Explanation:
  LIS won't work because that is O(n^2) and O(n).
  Sorting here is meaningless.
  A brute force solution won't work either.
  The current best algorithm: There are two numbers: first and second. First is the first number of your sequence and second is the second number of your sequence,
  if the current number is smaller than the first number than change the first number to that number,
  next if the current number is greater than the first numbers but smaller the second number, than update the
  second number. Now if the current number is greater than both the first and the second than
  that means that you have found a sequence of length 3 which is increasing (strictly).
  in <= the '=' is there so that the sequence is always strictly increasing.
  first and second can be understood as:
  first = so far best candidate of end element of a one-cell subsequence to form a triplet subsequence.
  second = so far best candidate of end element of a two-cell subsequence to form a triplet subsequence
*/



Question 2:
132 Pattern!
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
Return true if there is a 132 pattern in nums, otherwise, return false.
Solution: Write it in O(N)?

  public class Solution{
            public boolean find132pattern(int[] nums) {
                int n = nums.length;
                Stack<Integer> stack = new Stack<Integer>();
                int kthelem = Integer.MIN_VALUE;
                for(int i=n-1;i>=0;i--){
                    if(nums[i]<kthelem) return true;
                    while(!stack.isEmpty() && stack.peek()<nums[i]){
                        kthelem = stack.pop();
                    }
                    stack.push(nums[i]);
                }
                return false;
            }   
  }




