Problem Statement: Given an array A of integers, return true if and only 
if we can partition the array into three non-empty parts with equal sums.
Formally, we can partition the array if we can find indexes i+1 < j
with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])


Solution: 
1. Calculate the total sum.
2. Go through the array and calculate how many times sum//3 occurs in the array, everytime sum//3 occurs, set the running sum to zero.
3. The number of times it occurs should be atleast three. return 'count >=3'.
4. Why '>=', because when sum//3 is 0, then this testcase will fail: [1, -1, 1, -1, 1, -1, 1, -1], because sum//3 here is zero and the count would be 4, however the array 
can be divided into three parts.


class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = IntStream.of(A).sum();
        if(sum%3!=0) return false;
        sum=sum/3;
        int c = 0;
        int csum = 0;
        
        for(int i:A){
            csum+=i;
            
            if(csum==sum){
                c++;
                csum=0;
            }
            
        }
        
        return c>=3;
        
        
        
    }
}
