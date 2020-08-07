/*
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
       
          
   
  Solution 2: A Better Solution, it is recursive, but is it divide and conquer?
    In every time of DC, at least 1 character, let us say 'a', is chosen to divide the string,
    then all substrings in following recursive calls do not have the character 'a'. Therefore,
  the number of levels are limited to at most 26, because after that you run out of characters.
    Each level is O(N). 
    (On leetcode this beats 100% 0-ms solution)
  
    class Solution {
    public int longestSubstring(String s, int k) {
        char[] strn=s.toCharArray();
        return longestSubstring(strn,0,s.length()-1,k);      
      }
   

    private int longestSubstring(char[] strn,int start, int end, int frequency){
        int N=end-start+1;
        int s=start;
        int e=end;
        int k=frequency;
    
        if(s==e && k==1) return 1;
        if(N<k) return 0;
        
        int[] FrequencyArray=new int[26];
        for(int i=s;i<=e;i++){
            char ch=strn[i];
            int index=ch-'a';
            FrequencyArray[index]+=1;
        }
        
        boolean Condition_Satisfied=true;
        
        for(int i=s;i<=e;i++){
            char ch=strn[i];
            int index=ch-'a';
            if(FrequencyArray[index]<k){
                Condition_Satisfied=false;
            }
        }
        
        if(Condition_Satisfied==true){
            return N;
        }
        
        int Res=0;
        int i=s;
        int j=s;
        
        while(j<=e){
            char ch=strn[j];
            int f=FrequencyArray[ch-'a'];
            if(f<k){
                Res=Math.max(Res,longestSubstring(strn,i,j-1,k));
                i=j+1;
            }
            j=j+1;
        }
        
        return Math.max(Res,longestSubstring(strn,i,e,k));

    }
}
          
          
          

