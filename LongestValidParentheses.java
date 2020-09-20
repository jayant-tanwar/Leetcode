Problem Statement: Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
Example 1:
Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:
Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
Link : https://leetcode.com/problems/longest-valid-parentheses/

Solution 1: Via DP 
T: O(N) S:O(N)

class Solution{
    public int longestValidParentheses(String s){
      int n = s.length();
      int ans = 0;
      int[] DP = new int[n];
      char[] S = s.toCharArray();
      
      for(int i=1;i<n;i++){
      
          char ch = S[i];
          if(ch==')'){
              if(i-1>=0 && S[i-1]=='('){
                  DP[i] = DP[i-1] + 2;
              }
              else if(i-DP[i-1]-1>=0 && S[i-DP[i-1]-1]=='('){
              
                  DP[i] = DP[i-2] + 2 + (i-DP[i-1]-2>=0?DP[i-DP[i-1]-2]:0);
              }
          }
      
          ans = Math.max(ans,DP[i]);
      }
      return ans;
      
    }
}




Solution 2: Without Extra Space
In this approach, we make use of two counters left and right.
First,we start traversing the string from the left towards the right.
For every '(' encountered, we increment the right counter and increment 
the left for every ')'. We calculate the length of the current valid string
and keep track of maximum length substring found so far.
If right becomes greater than left we reset left and right to 0.
Now, we start traversing the string from right to left and similar
procedure is applied.

    public int longestValidParentheses(String s){
      int n = s.length();
      int l =0;
      int r=0;
      int ans =0;
      char[] S =s.toCharArray();
      for(int i=0;i<n;i++){
          if(S[i]=='(') l++;
          else if(S[i]==')') r++;
          if(l==r) ans = Math.max(ans,2*l);
          if(l<r){
            l=0; r=0;
          }
      }
      
      for(int i=n-1;i>=0;i--){
        if(S[i]=='(') l++;
        else if(S[i] ==')') r++;
        if(l==r) ans = Math.max(ans, 2*l);
        if(l>r) {
          l=0;
          r=0;
        }
      }
      return ans;
    }


















