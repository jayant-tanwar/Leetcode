Given a nxn matrix where each of the rows and columns are sorted in ascending order, find
the Kth smallest element in the matrix.
Note that it is the Kth Smallest element in the sorted order, not the kth distinct element.
Example:

[1, 5, 9]
[10,11,13]
[12,13,15]
and k = 8 
Answer 13


    public int kthSmallest(int[][] matrix, int k){
        int n = matrix.length;
        int m = matrix[0].length;
        
        int s = matrix[0][0];
        int e = matrix[n-1][m-1];

