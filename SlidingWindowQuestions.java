Questions in this document:
1. Sliding Window Maximum
2. 



Question 1:
Given an array nums,there is a sliding windows of size k which is moving from the very left of the array 
to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by
one position. Return the max sliding window. Solve in linear time.
Example: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7]
Constraints:
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
1 <= k <= nums.length

Solution: 
class Solution{

		public int[] maxSlidingWindow(int[] nums,int k){
			if(k==1) return nums;

			LinkedList<Integer> L = new LinkedList<>();

			int[] A=new int[nums.length-k+1];

			int i=0;
			int j=0;

			while(j<nums.length){

				if(!L.isEmpty() && L.getFirst()<j-(k-1)){
					L.pollFirst();
				}

				while(!L.isEmpty() && nums[L.peekLast()]<nums[j]){
					nums.pollLast();
					//The idea is to put the largest number in the window
					//at the front...
				}

				L.add(j);
				if(j+1>=k){
					A[i++]=nums[L.getFirst()];
				}
				j++;

			}

			return a;
		}

  
