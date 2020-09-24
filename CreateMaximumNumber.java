Problem Statement: Given two arrays of length m and n with digits 0-9 representing two numbers. 
Create the maximum number of length k <= m + n from digits of the two. 
The relative order of the digits from the same array must be preserved. Return an array of the k digits.
Note: You should try to optimize your time and space complexity.

class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        for(int i=0;i<=k;i++){
            
            int x = i;
            int y = k-i;
            
            if(n1<x) continue;
            if(n2<y) continue;
            int[] a1 = GetMaxArray(nums1,x);
            int[] a2 = GetMaxArray(nums2,y);
            // for(int d=0;d<x;d++) System.out.print(a1[d]+" ");
            // System.out.println();
            // for(int d=0;d<y;d++) System.out.print(a2[d]+" ");
            // System.out.println();
            // System.out.println("__________");
            int[] a3 = combine(a1,x,a2,y);
            boolean F = compare(a3,0,ans,0);
            if(F) ans = a3;
            
        }
        
        return ans;
    }
    
    public int[] combine(int[] A,int x,int[] B,int y){
        int[] ans = new int[x+y];
        int j=0;
        int i=0;
        for(int k=0;k<x+y;k++){
            ans[k] = compare(A,i,B,j)? A[i++]:B[j++];
        }
        return ans;
    }
    public boolean compare(int[] A, int i,int[] B,int j){
        if(i==A.length) return false;
        if(j==B.length) return true;
        while(i<A.length && j<B.length){
            if(A[i]>B[j]) return true;
            if(A[i]<B[j]) return false;
            i++;
            j++;
        }
        if(j==B.length) return true;
        if(i<A.length) return true;
        return false;
        
    }
    
    ///This is the important part
    //this piece of code is very useful as 
    //this is the code which gives you the lexographically largest number/array of length k
    //k<=Actual length of the array
    public int[] GetMaxArray(int[] A, int k){
        int[] R = new int[k];
        int j=0;
        int n= A.length;
        for(int i=0;i<n;i++){
            while(n-i>k-j && j>0 && R[j-1]<A[i]) j--;
            if(j<k) R[j++] = A[i];
        }
        return R; 
     }
    
    
}
