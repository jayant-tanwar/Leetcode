#given an integer array, you need to find one
# continuous subarray that if you only sort this 
# subarray in ascending order, then the whole
# array will be sorted in ascending order too
# you need to find the shortest such subarray and output its length

'''
approaches
O(n3)
In the brute force approach, we consider every possible subarray that can be formed from the given array numsnums. 
For every subarray nums[i:j]nums[i:j] considered, we need to check whether this is the smallest unsorted subarray or not. 
Thus, for every such subarray considered, we find out the maximum and minimum values lying in that subarray given by maxmax and minmin respectively.
If the subarrays nums[0:i-1]nums[0:i−1] and nums[j:n-1]nums[j:n−1] are correctly sorted, then only nums[i:j]nums[i:j] could be the required subrray. 
Further, the elements in nums[0:i-1]nums[0:i−1] all need to be lesser than the minmin for satisfying the required condition. Similarly, all the elements in nums[j:n-1]nums[j:n−1] need to be larger than maxmax. We check for these conditions for every possible ii and jj selected


O(n2)
selection sort idea
nums[i] and nums[j] where i<j<n,
if nums[i]>nums[j] then note the positions of i and j
the extreme left i and the extreme left j is the answer


O(nlogn)
just sort the thing and then check where the differecnes are

O(n)
The idea behind this method is that the correct position of the minimum element 
in the unsorted subarray helps to determine the required left 
boundary. Similarly, the correct position of the maximum element
in the unsorted subarray helps to determine the required right boundary.

Thus, firstly we need to determine when the correctly sorted array goes wrong. We keep a track of 
this by observing rising slope starting from the beginning of the array. Whenever the slope falls,
we know that the unsorted array has surely started. Thus, now we determine the minimum element found 
till the end of the array numsnums, given by minmin.
Similarly, we scan the array numsnums in the reverse order and when the slope becomes rising instead of falling, we start looking
 for the maximum element till we reach the beginning of the array, given by maxmax.

Than, we traverse over numsnums and determine the correct position of minmin and maxmax by comparing these elements with the other array elements. e.g. To determine the correct position of minmin, we know the initial portion of numsnums is already sorted. Thus, we need to find the first element which is just larger than minmin. Similarly,
 for maxmax's position, we need to find the first element which is just smaller than maxmax searching in numsnums backwards.

	T O(N)
	S O(N)
	
	code for the best approach is below
 '''

def f(nums):
	##find the first fall
	for i in range(0,len(nums)-1):
		if(nums[i]>nums[i+1]):
			#slope has fallen
			L=i

	##find the first rise from the back
	for i in range(len(nums)-1,0,-1):
		if(nums[i]<nums[i-1]):
			R=i

	##get the minimum element from [L,len(Nums)]
	minelem=float('inf')
	maxelem=float('-inf')
	mi=-1
	Mi=-1


	#from where the slope dropped
	#till the first rise found from the end
	for i in range(L,R+1):
		if(minelem>nums[i]):
			minelem=nums[i]
		if(maxelem<nums[i]):
			maxelem=nums[i]

	for i in range(0,len(nums)):
		if(nums[i]>minelem):
			mi=i

	for i in range(len(nums)-1,-1,-1):
		if(nums[i]<maxelem):
			Mi=i

	print(mi,Mi)







