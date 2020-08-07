In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for
which all other nodes are descendants of this node, plus every node has exactly one parent, except for the
root node which has no parents.

The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1,2,...,N)
with one additional directed egde added. The added edge has two different vertices chosen from 1 to N, and was
not an edge that already existed.

The resulting graph is given as 2D-array of edges. Each element of edges is a pair [u,v] that represents
a directed egde connecting nodes u and v, where u is a parent of child v.

Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If there are mutliple
answers, return the answer that occurs last in the 2D array.


Input: [[1,2], [1,3], [2,3]]
Output: [2,3]

Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
Output: [4,1]
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.



Thoughts
There are three cases for Redundant Connections.
Case 1: Two-parent problem such that a node has two parents.
Case 2: Cyclic problem, where there is a cycle in the graph
Case 3: Two-parent problem and cyclic problem. Example: Test case 13: [[2,1],[3,1],[4,2],[1,4]] Ans: [2,1]

More on case 3:
We do union only if it is not the second parentEdge.
We assume that, we always remove the second parentEdge, if in case there is still a cycle then that means
we made the wrong choice and we should remove the first parentEgde instead.

Example: [[1,2],[2,3],[4,3],[3,1]]
Explanation: This is a case 3 problem. [2,3] comes before [4,3] so remove [4,3] and then union [1,2],[2,3],[3,1]
however there is still a cycle in the graph. Therefore, we should remove [2,3].



public int[] findRedundantDirectedConnection(int[][] edges){
    
    int numNodes= edges.length;
    int edgeRemoved = -1;
    int edgeMakesCycle = -1;
    
    int[] parent = new int[ numNodes + 1];
    
    for(int i = 0 ; i < numNodes ; i++){
        int u = edges[i][0];
        int v = edges[i][1];
        
        if(parent[v]!=0){
            /*Assume we removed the second edge*/
            edgeRemoved = i;
            break;
         }
         else{
              parent[v] = u;
              
         }
    }
    
    








