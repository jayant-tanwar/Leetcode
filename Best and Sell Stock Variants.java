This document contains the following problems:
1.
2.
3.Best Time to Buy and Sell Stock III
4.
5.


Problem 3: Best Time to Buy and Sell Stock III

Problem Statement: Say you have an array for which the ith
element is the the price of a given sotck on day i.
Design an algorithm to find the maximum profit. You may
complete at most two transactions.
Note: You may not engage in mulitple transactions at the same
time (i.e, you must sell the sotck before you buy again)

Example 1:
[3,3,5,0,0,3,1,4] 
Answer = 6
Buy on day 4 (price=0) and sell on day 6 (price=3),
profit = 3-0 =3. Then buy on day 7 (price = 1) and sell
on day 8 (price = 4), profit 4-1 = 3.

it is not difficult to get the DP recusrive formula

dp[k][i] = max(dp[k][i-1], prices[i]- prices[j] + dp[k-1][j-1]_
for j in range[0,i-1]

for k transaction on the ith day,
if we do not trade then the profit is same as the previous
day dp[k][i-1], and if we had bought a share on jth day
and sold it on the ith day then the profit would be
prices[i]- prices[j]+ dp[k-1][j-1]

Therefore the staight forward implementation is:
public int MaxProfitDp(int[] prices){
  
  if(prices.length==0) return 0;
  int[][] dp = new int[3][prices.length];
  
  for(int k = 1; k <= 2; k++){
      for(int i = 1; i< prices.length ;i++){
          int min = prices[0];
          for(int j=1;j<=i; j++){
              min = Math.min ( min, prices[j] - dp[k-1][j-1]);
          }
          dp[k][i] = Math.max(dp[k][i-1], prices[i] - min);
    }
   }
       
       return dp[2][prices.length-1];
       
}
           
