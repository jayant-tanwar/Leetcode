Unique Binary Search Trees
Unique Binary Search Trees II

Question: Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Solution:
The solution to this problem is to be find the nth Catalan number
The nth Catalan number is defined by:
C_n = (1/(n+1))*(2N _c_ N) = (2n)!/ (n+1)!n!
C_n = Product n+k/k where k goes from 2 to n. (n>=0)
First few Catalan numbers are: 1,1,2,5,14,42,132,439,1430,4862...
Catalan numbers grow as 4^n/n^(3/2)

G(n) = F(1,n) + F(2,n) + ... + F(n,n)
F(i,n) = G(i-1)*G(n-i)

A kool pthon solution:
class Solution:
    def numTrees(self,n):
        @lru_cache(maxsize=None)
        def G(n):
            if(n==0 or n==1):   return 1
            s = 0
            for i in range(1,n+1):
                s += G(i-1)*G(n-i)
            return s
         return G(n)
                    
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

--------------------------

Unique Binary Search Trees II
Given an integer n, generate all structurally unique BSTs that store values 1..n.

Example
Input: 3
Ouput: 
[1,null,3,2]
[3,2,null,1]
[3,1,null,null,2]
[2,1,3]
[1,null,2,null,3]

Without using any memoisation

class Solution{
    public List<Treenode> generateTrees(int n){
        if(n==0) return new Arraylist<TreeNode>();
        return Recur(1,n);
    }
    
    public List<TreeNode> Recur(int s,int e){
        List<TreeNode> X = new ArrayList<TreeNode>();
        if(s>e){
            X.add(null);
            return X;
        }
        
        for(int i=s;i<=e;i++){
            List<TreeNode> B = Recur(s,i-1);
            List<TreeNode> C = Recur(i+1,e);
            
            for(TreeNode l:B){
                for(TreeNode r:C){
                    TreeNode root = new TreeNode(i);
                    root.right = r;
                    root.left = l;
                    X.add(root);
                }
            }
            
        }
        return X;
        
    }
}

With memoisation
class Solution{
    List<TreeNode>[][] DP;
    public List<TreeNode> genTrees(int n){
        if(n==0) return new ArrayList<TreeNode>();
        DP = new ArrayList[n+1][n+1];
        return Recur(1,n);
    }
    
    public List<TreeNode> Recur(int s, int e){
        List<TreeNode> X = new ArrayList<TreeNode>();
        if(s>e){
            X.add(null);
            return X;
        }
        if(DP[s][e]!=null) return DP[s][e];
        for(int i=s;i<=e;i++){
            List<TreeNode> B = Recur(s,i-1);
            List<TreeNode> C = Recur(i+1,e);
            for(TreeNode l:B)
                for(TreeNode r:C){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    X.add(root);
                }
        }
        DP[s][e] = X;
        return X;
    }
}





