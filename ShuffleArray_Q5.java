/* Shuffle a set of numbers without duplicates
Example:
//Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
*/

/*Brute Forces and Fisher-Yates Algorithm

Intuition: If we put each number in a hat and draw them out at random, the order in which we draw them
will define random ordering.

Algorithm:
The brute force algorithm essentially puts each number in the aforemenioned hat and draws them at random,
(without replacement) until there are none left. Mechanically, this is performed by copying the contests 
of array into a second auxiliary array named aux, before overwriting each element of array with a randomly 
selected one from aux. After selecting each random element,it is removed from aux to prevent duplicate draws.
The implementation of reset is simple,as we just store the original state of nums on construction.

The correctness of the algorithm follows from the fact that an element (wlos) is equally likely to be selected
during all iterations of the for loop. To prove this, observe that the probability of a particular
element e being chosen on the kth iteration (indexed from 0) is simply=
Probability(e being chosen during the kth iteration) * Probability(e not being chosen before the kth iteration).
This comes out to be 1/n, so each array permutation is equally likely to arise.
*/


class Solution{
    
      private int[] array;
      private int[] original;
      
      
      private Random rand=new Random();
      
      private List<Integer> getArrayCopy(){
        List<Integer> asList=new ArrayList<Integer>();
        for(int i=0;i<array.length;i++){
              asList.add(array[i]);
          }
             return asList;
      }
      
      public Solution(int[] nums){
          array=nums;
          original=nums.clone();
        }
        
       public int[] reset(){
          array=original;
          original=original.clone();
          return array; 
          }
       
       public int[] shuffle(){
          List<Integer> aux=getArrayCopy();
        
            for(int i=0;i<array.length;i++){
              int removeIdx=rand.nextInt(aux.size());
              array[i]=aux.get(removeIdx);
              aux.remove(removeIdx);
              }
          return array;
       }
          
          
}

/* 
Fisher- Yates Algorithm
We can cut down the time and space complexities of shuffle with a bit of cleverness-
namely by swapping elements around within the array itself,we can avoid the linear space cost
of the auxiliary array and the linear time cost of the list modification.

Algorithm:
We generate a random integer between the current index and the last index of the array.
Then, we swap the elements at the current index and the chosen index. This simulates drawing (and removing)
the element from the hat, as the next range from which we select a random index will not include
the most recently processed one. One small, yet important detail is that it is possible to swap an element
with itself- otherwise, some aray permutations would be more likely than others.
*/

class Solution2{
  
  private int[] array;
  private int[] original;
  
  Random rand=new Random();
  
  private int randRange(int min,int max){
      return rand.nextInt(max-min)+min; 
    }
    
  private void swapAt(int i,int j){
      int temp=array[i];
      array[i]=array[j];
      array[j]=temp;
   }
      
    public Solution2(int[] nums){
          array=nums;
          original=nums.clone();
      }
          
    public int[] reset(){
          array=original;
          original=original.clone();
          return original;
       }
            
     public int[] shuffle(){
          for(int i=0;i<array.length;i++){
              swapAt(i,randRange(i,array.length));
              }
           return array;  }
              
              
   }
    
      
  




