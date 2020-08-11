Problem Statement : Given an integer array, return the k-th smallest distance among all the pairs. 
The distance of a pair (A, B) is defined as the absolute difference between A and B.
  
  
Solution: Using Binary Search and Sliding Window
----------------------------------------------------------
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        int lo = 0;
        //lower bound of difference, may not exist
        int hi = nums[nums.length-1]-nums[0];
        //maximum possible diff
        
        while(lo<hi){
            int mid=(lo+hi)>>1;
            int c = PairsDiffSmaller(nums,mid);
            if(c<k){
                lo=mid+1;
            }
            else{
                hi=mid;
            }
        }
        return hi;

    }
    
    public int PairsDiffSmaller(int[] nums, int mid){
        int left = 0;
        int count = 0;
        
        for(int right = 0;right < nums.length; right++){
            
            while(nums[right] - nums[left]> mid){
                left = left + 1;
            }
            count= count + ( right - left ); //that is how you count the number of pairs   why not +1? because a single element is not a pair!
        }
        
        return count;
    }
}
----------------------------------------------------------

Time Complexity : O(NlogW + NlogN)
N = length of nums 
W = is equal to nums[nums.length - 1]-nums[0]
The logW factor comes from our binary search
O(N) work is done to calculate 'count'
NlogN factor comes from sorting.
  
Space Complexity: Depends on Arrays.sort(nums)
if it does not require extra space than it SC is O(1)
otherwise what ever memory it requires.
  
