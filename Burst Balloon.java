
Burst Balloons
Problem Statment: Given n balloons, indexed from 0 to n-1. 
Each balloon is painted with a number on it represented by array nums. 
You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 
Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
Find the maximum coins you can collect by bursting the balloons wisely.
Note:
You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
  
  
Solution: Variant 1:
public int maxCoins(int[] A){

	int N=A.length;

	int[][] DP = new int[N+1][N+1];


	for(int d=0;d<=N-1;d++){
		for(int i=0;i+d<N;i++){
			int j=i+d;

			for(int k=i;k<=j;k++){
				int v=A[k]*(i-1>=0?A[i-1]:1)*(j+1<N?A[j+1]:1);
				int L=(i>=k-1?DP[i][k-1]:0);
				int R=(k+1<=j?DP[k+1][j]:0);
				DP[i][j]=Math.max(DP[i][k],v+L+R);
			}
		}
	}

	return DP[1][N];
}
Variant 2:
public int maxCoins(int[] A){
	int N=A.length;
	int[][] dp = new int[N][N];

	for(int L=N-1;L>=0;L--){
		for(int R=L;R<N;R++){

			int ans=0;
			for(int i=L;i<=R;i++){
				int val = A[i]*(L-1>0:A[L-1]:1)*(R+1<N:A[R+1]:1);
				int L = (i-1>=L:dp[L][i-1]:0);
				int R = (i+1<=R:dp[i+1][R]:0);
				ans=Math.max(ans,val+L+R);
			}
			dp[L][R]=ans;
		}
	}
	if(n==0) return 0;
	return dp[0][N-1];

}
