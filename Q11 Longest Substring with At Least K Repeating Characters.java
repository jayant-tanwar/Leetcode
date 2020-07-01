/*
This is kinda hard man.
Longest Substring with At Least K Repeating Characters
Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

Example 1:
  s="aaabb" , k=3
  output: 3
  The longest substring is "aaa", as 'a' is repeated 3 times.
  
 Example 2:
  s="ababbc", k=2
  output: 5
  The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
*/


class Solution{
    
    public int longestSubstring(String s,int k){
        if(s.length()== || k>s.length()) return 0;
        
        int max=0;
        for(int i=1;i<27;i++) max=Math.max(max,ld(s,k,i)); 
        return max;
        }
       
      public int ld(String s, int k ,int uniquebound){
      
          int[] chars=new int[26];
          int start=0;
          int end=0;
          int UniqueCharsCount=0;
          int CharsAppearKTimes=0;
          int max=0;
          
          while(end<s.length()){
              char ch=s.charAt(end);
              end++;
              if(chars[ch-'a']==0) UniqueCharsCount++;
              chars[ch-'a']++;
              if(chars[ch-'a']==k) CharsAppearKTimes++;
              
              while(UniqueCharsCount>uniquebound){
                  char sch=s.charAt(start);
                  if(chars[sch-'a']==1) UniqueCharsCount--;
                  if(chars[sch-'a']==k) CharsAppearKTimes--;
                  chars[sch-'a']--;
                  start++;
                 }
              
              if(UniqueCharsCount==CharsAppearKTimes){
                max=Math.max(max,end-start);}
                
              }
             
             return max;
             
             
        }
       
          
          
          
          
          

