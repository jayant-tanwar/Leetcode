/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Algorithm:
The numbers are stored in hashSet ( set in python ) to allow O(1) lookups,
and we only attempt to build sequences from numbers that are not already part of a longer sequence.
This is accomplished by first ensuring that the number would immediately precede the current number in a sequence
is not present, as that number would necesarrily be part of a longer sequence.
*/
class Solution{
    public int longestConsective(int[] nums){
       Set<Integer> num_set=new HashSet<Integer>();
       for(int num: nums) num_set.add(num);
       int longestS=0;
       for(int num:num_set){
            if(!num_set.contains(num-1)){
                int currentNum=num;
                int currentStreak=1;
                while(num_set.contains(currentNum+1)){
                  currentNum+=1
                  currentStreak+=1;
                  }
                 
                 longestS=Math.max(longestS,currentStreak);
               }
               
        } 
        return longestS;
        
     }}
     
    /* Written in a much better way
        in python just set nums=set(nums) rest is the same...
    */
    
    class Solution{
      public int longestConsecutive(int[] nums){
          HashSet<Integer> s=new HashSet<Integer>();
          int m=0;
          for(int x:nums) s.add(x);
          for(int x:nums) if(!s.contains(x-1)){
              
              int cls=1;
              int y=x;
              while(s.contains(y+1)){
                  cls++;
                  y++;
                }
             m=Math.max(m,cls);
            }
            
            return m;
            }}
            
       
    
        
