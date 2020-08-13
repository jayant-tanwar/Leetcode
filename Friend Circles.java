There are N students in a class. Some of them are friends, while some are not. 
Their friendship is transitive in nature. For example, 
if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. 
And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class.
If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. 
And you have to output the total number of friend circles among all the students.

Note:
N is in range [1,200].
M[i][i] = 1 for all students.
If M[i][j] = 1, then M[j][i] = 1.

class Solution{
    boolean[] V;
    public int findCircleNum(int[][] M){
      V = new boolean[M.length];
      int circles=0;
      for(int i=0;i<M.length;i++){
          if(V[i]==false){
              DFS(i,M);
              //since M[i][i]==True
              //Therefore in any case,
              //There are M.length number of circles
              //at max!
               circles++;
          }
       }
       
       return circles;
     }
     
     public void DFS(int i,int[][] M){
        for(int j=0;j<M.length;j++){
          if(V[j]==false && M[i][j]==1){
              //Mark them true
              V[j]=true;
              //Search next row
              DFS(j,M);
             }
          }
          
        return;
     }
          
       



