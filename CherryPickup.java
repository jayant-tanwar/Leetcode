1. Cherry Pickup
    Problem Statement: In a N x N grid representing a field of cherries, each cell is one of three possible integers.
                       0 means the cell is empty, so you can pass through;
                       1 means the cell contains a cherry, that you can pick up and pass through;
                      -1 means the cell contains a thorn that blocks your way.
            
            Your task is to collect maximum number of cherries possible by following the rules below:
            Starting at the position (0, 0) and reaching (N-1, N-1) by moving right or down through valid path cells (cells with value 0 or 1);
            After reaching (N-1, N-1), returning to (0, 0) by moving left or up through valid path cells;
            When passing through a path cell containing a cherry, you pick it up and the cell becomes an empty cell (0);
            If there is no valid path between (0, 0) and (N-1, N-1), than no cherries can be collected.
            
  Solution: A greedy algorithm which tries to maximise the number of cherries picked in round 1 (going down and right) and round 2 (going up and left) would give a wrong answer. 
            An example of that would be, the grid below...

            grid = [[1,1,1,0,1],
                    [0,0,0,0,0],
                    [0,0,0,0,0],
                    [0,0,0,0,0],
                    [1,0,1,1,1]]
            
            The greedy algorithm would suggest a Z shaped path for round 1, which is (0,0) => (0,2) => (4,2) => (4,4)
            which garners 6 cherries and then for the round 2, the maximum number of cherries that can be collected is
            just 1. So the total number of cherries would be 7. However, the maximum number of cherries you can pick is 8.
            
                   
       Solution 1 Top Down DP :
            Idea: Instead of thinking about two different rounds, if the optimal round 2 is reversed one would get leg 2 of round 1.
                  This holds because of the direction constraints. Going reverse on round 2 would only have right and downwards steps.
                  So, we have two paths going down and right. Remember, this does not mean you can now apply a greedy approach.
                  
                
                  Starting from (0,0) and going to (N-1,N-1).
                  After moving t steps right or downwards, one reaches at the position (r,c) and
                  r + c = t holds true. This equation would hold true if there are two people who started walking from (0,0) and reached (r1,c1) and
                  (r2,c2) respectively i.e. r1 + c1 = r2 + c2 = t.
                  This means three variables r1, c1 and c2 and uniquely determine the positions of 2 people who have walked 
                  r1 + c1 steps each.
                      
                  3D DP:
                  Let DP [r1] [c1] [c2] = maximum number of cherries picked by two people starting at (r1,c1) and (r2,c2) and reaching
                  (N-1,N-1) picking up cherries.
                   
                   Taking care of the thorns, if grid[N-1][N-1] is a thorn you can never complete your walk, therefore answer would 0.
                   Therefore, DP[r1][c1][c2] would be grid[r1][c1] + grid[r2][c2] (if r1 != r2 we should not double count a coordinate ) + max( DP[r1 + 1][c1][c2], DP[r1][c1+1][c2+1],
                   DP[r1][c1+1][c2], DP[r1+1][c1][c2+1]) 
                       
                       
                   The four transistions mentioned above are:
                    1. Person 1 goes down and person 2 goes down.
                    2. Person 1 goes down and person 2 goes right.
                    3. Person 1 goes right and person 2 goes down.
                    4. Person 1 goes right and person 2 goes right.         
  class Solution {
    
            int[][][] DP;
            int N;
    
            public int cherryPickup(int[][] grid) {
                N=grid.length;
               DP=new int[N][N][N];
                for(int[][] L:DP){
                    for(int[] A:L){
                        Arrays.fill(A,Integer.MIN_VALUE);
                    }
                }

                return Math.max(0,Solver(0,0,0,grid));
            }

            public int Solver(int r1,int c1, int c2,int[][] grid){
                int r2=r1+c1-c2;
                if(r2<0) return Integer.MIN_VALUE;
                if(r1==N || c1==N || c2==N || r2==N || grid[r1][c1]==-1 || grid[r2][c2]==-1) return Integer.MIN_VALUE;

                if(r1==N-1 && c1==N-1){
                    return grid[r1][c1];
                }
                if(DP[r1][c1][c2]!=Integer.MIN_VALUE) return DP[r1][c1][c2];

                int ans=0;
                ans+=grid[r1][c1];
                if(r1!=r2 && c1!=c2){
                    ans+=grid[r2][c2];
                }

                int one=Solver(r1,c1+1,c2+1,grid);
                int two=Solver(r1+1,c1,c2+1,grid);
                int three=Solver(r1,c1+1,c2,grid);
                int four=Solver(r1+1,c1,c2,grid);

                int m=Math.max(one,Math.max(two,Math.max(three,four)));
                DP[r1][c1][c2]=ans+m;
                return ans+m;
            }
    
}    
               
                      
                      
                   
                  

