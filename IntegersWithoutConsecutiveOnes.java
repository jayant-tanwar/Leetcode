Non-negative Integers without Consecutive Ones
Problem Statement: Given a positive integer n, find the number of non-negative integers less than or equal to n, 
whose binary representations do NOT contain consecutive ones.
Note: 1 <= n <= 109

We consider a simple idea that will be used in the current approach.
Suppose, we need to find the count of binary numbers with n bits such that these numbers
do not contain consecutive 1's. In order to do so, we can look at the problem in a
recursive fashion. Suppose f[i] gives the count of such binary numbers with i bits.
In order to determine the value of f[n], which is the requirement, we can consider two cases:

f[n-1] and f[n-2]
If we know the value of f[n-1] and f[n-2], in order to generate the required binary
numbers with n bits,we can append a 0 to all the binary  numbers contained in f[n-1],
without creating an invalid number. These numbers give a factor of f[n-1] to be included 
in f[n]. But we cannot append a 1 to all these numbers, since it could lead to the presence of 
two consecutive ones in the newly generated numbers. This, for the currently generated numbers
to end with a 1, we need to ensure that the second the last position is always 0.
Thus, for the currently generated numbers to end with a 1, we need to ensure that 
the second last position is always 0. This we need to fix a 01 at the end of all the 
numbers contained in f[n-2]. This gives a factor of f[n-2] to be included in f[n].
Thus, in total, we get f[n]= f[n-1] + f[n-2].

Now, let us look into the current approach. We will try to understand the idea behind
the approach by taking two simple examples. First we look at the cases where the given number 
does not contain any consecutive 1s. 
Say num = 1010100 ( 7 bit number ). Now, we will how we can find the numbers lesser than 
num with no two consecutive 1s. We start off with the MSB of nums. If we fix a 0 at the MBS
position, and find out the count of 6 bit numbers ( corresponding to the 6 LSBs) with
no two consecutive 1s, these 6 bit numbers will lie in the range 0000000 -> 0111111. For
finding this count we can make use of f[6] which we'll have calculated.

But even after doing this, all the numbers in the required range haven't been covered yet.
Now, if we try to fix 1 at the MSB, the number considered will lie in the range
1000000 -> 1111111. As we can see, this covers the nuymbers in th range 1000000 -> 1010100,
but it covers the numbers in the range beyond limit as well. Thus, we can't fix 1 at the MSB
and consider all the 6-biy numbers at the LSBs.

For covering the pending range, we fix 1 at the MSB, and move foward to proceed with the
second digit (counting from MSB). Now, since we have already got a 0 at this position, 
we cannot substitute a 1 here, since doing so will lead to generation of numbers
exceeding nums, this the only option left here is to substitute a 0 at the second position.
But, if we do so, and consider the 5-bit numbers (at the 5 LSBs) with no two consecutive 1s
these new numbers will fall in the range 1000000 -> 1011111. But, again we can observe that 
considering these numbers lead to exceeeding the required range. Thus, we cannot consider all
the 5-bit numbers for the required count by fixing 0 at the second position.

Thus, now , we fix 0 at the second position and proceed further. Again, we encounter a 1 at the third
position. Thus, we can fix a 0 at the position and find out the count of 4 bit consecutive
numbers with no two consecutive 1s. We can obtain this value from f[4]. Thus, now the numbers
in the range 100 0000-> 100 1111 have been covered.
Again, now we fix a 1 at the third position and proceed with the fourth bit. it is a 0. So, we
need to fix it as such as per the above discussion, and proceed with the fifth bit.
It is a 1. 



Now we look at the case, where num contains some consecutive 1s. The idea will be the same,
with the only exception taken when the two consecutive 1s are encountered. Let us say
num = 1011010 (7 bit number). Now, as per the last dicussion, we start with the MSB. 
We find a 1 at this position. Thus, we initially fix a 0 at this position to consider the
numebrs in the range 000000 -> 0111111, by varying the 6 LSB bits only. The count of the rquired
numbers in this range is again by f[6].
Now, we fix a 1 at the MSB and move on to the second bit. It is a 0, so we have no choice
but to fix 0 at this position and to proceed with the third bit. it is a 1, so we fi a 0 here,
considering the numbers in the range 100 0000 -> 100 1111. This accounts for a factor of f[4].
Now, we fix a 1 at the thirs position, and proceed with the fourth bit. It is a 1 (consecutive to
the previous 1). Now, initially we fix a 0 at the fourth position, considering the numbers in
the range 1010 000 -> 1010 111. This adds a factor of f[3] to the required count.
But if we try to consider any number larger than 1010111, it leads to the presence of 
two consectuive 1s in the new number at third and fourth position. Thus all the valid numbers upto num
have been considered with this, giving a resultant count of f[6] + f[4] + f[3]


Thus, summarizing the above discussion, we can say that we start scanning the given number num
from its MBS. For every 1 encountered at the ith position (counting from 0 from LSB)
we add a factor of f[i[ to the resultant count.
For every 0 encountered we don't add any factor.
We also keep a track of the last bit checked. If we happen to find two consecutive 1s at 
any time, we add the factors for the positions of both 1s and stop the traversal immediatley. If 
we dont find any two consecutive 1s we proceed till reaching the LSB and add an extra 1 to account 
for the given number num as well, since the procedure disscussed above considers numbers
upto num with including itself.


public class Solution{
    public int findIntegers(int num){
        int[] f = new int[32];
        f[0] = 1;
        f[1] = 2;
        for (int i=2;i<f.length;i++) f[i] = f[i-1] + f[i-2];
        
        int i = 30, sum = 0, prev_bit = 0;
        while(i>=0){
          if( (num&(1<<i))!=0){
              sum += f[i];
              if( prev_bit ==1 ) {
                
              }
          }
        }










