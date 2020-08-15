Given a nxn matrix where each of the rows and columns are sorted in ascending order, find
the Kth smallest element in the matrix.
Note that it is the Kth Smallest element in the sorted order, not the kth distinct element.
Example:

[1, 5, 9]
[10,11,13]
[12,13,15]
and k = 8 
Answer 13

Solution: Using Binary Search
Time Complexity: (Please confirm this) O( N*log(max-min) ) ///log(max-min) component comes from the range binary search over N*N elements and N component comes from the two loops
Space Complexity: O(1) //Big advantage!

class Solution{
	public int KthSmallest(int[][] Matrix,int k){
		//Using Binary Search
		int N=Matrix.length;
		int s=Matrix[0][0];
		int e=Matrix[N-1][N-1];

		while(s<e){
			int mid=(s+e)>>1;

			int j=N-1;
			int count=0;

			for(int i=0;i<N;i++){
				while(j>=0 && Matrix[i][j]>mid){
					j--;
				}
				count=count+(j+1);
			}

			if(count<k){
				s=mid+1;
			}
			else{
				e=mid;
			}


		}
		return e;

	}
}


Solution: Using Priority Queue!
Time Complexity: O(min(K,N) + K*log(N)) //Please check this! I think it should be K*log(min(K,N))
Space Complexity: O(N)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int N=matrix.length;
		PriorityQueue<int[]> PQ=new PriorityQueue<int[]>((a,b)->(matrix[a[0]][a[1]] - matrix[b[0]][b[1]]));
        //mini comparator?
        
        //Only min(N,k) elements in the Queue will be there at any time.
		for(int i=0;i<Math.min(N,k);i++){
			PQ.add(new int[]{0,i});
		}

		while(k!=0){
			int[] A=PQ.poll();
            k--;
			if(k==0){
				return matrix[A[0]][A[1]];
			}
			else if(A[0]<N-1){ //check to see if you are going out of the matrix
                
                //Since my right element already exists in the PQ
                // I will add the element bigger than current element which is the one below
                
				PQ.add(new int[]{A[0]+1,A[1]});
			}
		}
		return -1;
	}
}
