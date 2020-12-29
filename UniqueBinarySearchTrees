Unique Binary Search Trees
Unique Binary Search Trees II

Question: Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Solution:
G(n) = F(1,n) + F(2,n) + ... + F(n,n)
F(i,n) = G(i-1)*G(n-i)


class Solution{
    int[] DP;
    public int numTrees(int n){
      if(n==0) return 1;
      if(n==1) return 1;
      DP = new int[n+1];
      Arrays.fill(DP,-1);
      
      //G(N) = Sum F(i,N) i goes from 1 to N where i is the root of this tree.
      DP[0] = 1;
      DP[1] = 1;
      return G(n);
    }
    public int G(int n){
      if(DP[n]!=-1) return DP[n];
      int sum = 0;
      for(int i=1;i<=n;i++){
          sum += F(i,n);
      }
      DP[n] = sum;
      return sum;
    }
    
    public int F(int i,int n){
      return G(i-1)*G(n-i);
    }
    
    
}
