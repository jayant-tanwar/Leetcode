/*
Given n non-negative integers representing an elevation map where the width of each bar 1,
compute how muc water it is able to trap after raining.
Example:
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Link: https://leetcode.com/problems/trapping-rain-water/

Here I discuss two solutions,
a third solution exists but for now
we shall leave it for next iteration.
*/

///  DP  T: O(N), S: O(N)  
/*
Doing as directed in the question, for each element in the array,
we find the maximum level of water it can trap after the rain,
which is equal to the minimum of maximum height of bars on both 
the sides minus its own height

Using DP so that calculating max on both sides comes from O(n) to O(1)
*/

class Solution{
    public int trap(int[] height){
      int l=height.length;
      if(l<=1) return 0;
      
      int[] right=new int[l];
      int[] left=new int[l];
      
      left[0]=height[0];
      right[l-1]=height[l-1];
      
      for(int i=1;i<l;i++) left[i]=Math.max(left[i-1],height[i]);
      for(int i=l-2;i>=0;i--) right[i]=Math.max(right[i+1],height[i]);
      
      int water=0;
      for(int i=0;i<l;i++) water+=Math.min(left[i],right[i])-height[i];
      
      return water;
    }
    
    
    
    
 /// Second Solution: Better Solution
 /* Instead of storing the largestes bar upto an index, we
 can use stack to keep track of the bars that are bounded by longer
 bars and hence,may store water.
 O(N)
 we keep a stack and iterate over the array,we add the index of the bar.
 We add the index of the bar to the stack if bar is smaller than or equal
 to the bar at top of the stack,which means that the current bar is bounded
 by the previous bar in the tack.
 If we found a bar longer than that at the top, we are sure that the
 bar at the top of the stack is bounded by the current bar and a previous bar in the stack
 , hence, we can pop it and add resulting trapped water to ans.
 */
 
int trap(int[] height){
		    int water=0;
		    Stack<Integer> s=new Stack<Integer>();
		    for(int i=0;i<height.length;i++){
		        while(s.size()!=0 && height[s.peek()] < height[i]) {
		              int v=s.pop();
		              if(s.size()==0) break;
		              
		              int diff=i-s.peek()-1;
		              int actualheight=Math.min(height[s.peek()],height[i])-height[v];
		              water=water+(actualheight*diff);
		          }
		           s.push(i);
		     }
		    return water;
		}
