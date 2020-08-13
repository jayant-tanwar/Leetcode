Problem Statement: 
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.


class Solution {
    
    List<List<String>> Ans;
    //This holds the final answer
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<String> Q=new LinkedList<String>();
        // Queue for BFS
        
        
        HashMap<String,ArrayList<String>> Neighbours=new HashMap<>();
        //Neighbours is the graph, that I will make
        //Ladder property is that I can only go from current word to next word is the Distances(current_word)+1 == Distances(nextword)
        HashMap<String,Integer> Distances = new HashMap<>();
      
        
        Ans=new ArrayList<>();
        
        HashSet<String> Dictionary= new HashSet<String>(wordList);
        //Making the dictionary
      
        if(Dictionary.contains(endWord)==false){
          //Then we don't need to go into BFS
            return Ans;
        }
        
        int M=beginWord.length();
        //Given all words are so the same length
        
        Distances.put(beginWord,0);
        //Initial for the starting word  
      
        int d=Integer.MAX_VALUE;
        Q.add(beginWord);
        
        while(!Q.isEmpty()){
            
            int size=Q.size();
            // We need to go level by level
            // This is one way to go level by level we could have made a second queue but that would extra
          
            boolean f=false;
            //to check if we have reached the end word or not  
          
          for(int j=0;j<size;j++){
              //Iterate the current level, it is size-long    
            
                String Word=Q.poll();
                
                if(Neighbours.containsKey(Word)==false){
                    Neighbours.put(Word,new ArrayList<String>());
                }
            
                
                int length=Distances.get(Word);
                //How far
            
                char[] A=Word.toCharArray();
                //This will be useful;
            
                for(int i=0;i<M;i++){
                  //Replace one character at a time by every character possible.
                    
                    for(char ch='a';ch<='z';ch++){
                      
                            char tmp=A[i];
                            A[i]=ch;
                            //character changed
                        
                            String NewWord=String.valueOf(A);
                            
                            if(Dictionary.contains(NewWord)==false){
                                //We this isn't a word, then we cannot use it or visit it or anything
                                A[i]=tmp; //important 
                                continue;
                            }
                        
                            Neighbours.get(Word).add(NewWord);
                            //Making the graph
                            
                            if(!Distances.containsKey(NewWord)){
                                //If this new word was not previously visited.
                              
                                Distances.put(NewWord,length+1);
                                
                                if(NewWord.equals(endWord)){
                                    d=Math.min(d,length+1);
                                    f=true;
                                    //Records distance and f is true now we know we don't have to visit further levels!
                                    //DONT BREAK HERE no break; so that we can get all the paths!
                                }
                                else{
                                    Q.offer(NewWord);
                                    //Add to the next level!
                                }
                              
                            }
                      
                            A[i]=tmp; //important!
                        }
                    }  
            
                }   
          
            if(f) break; //last level did the job!
 
        }
        
        if(d==Integer.MAX_VALUE) return Ans; //if end was unreachable!
      
        ArrayList<String> X=new ArrayList<String>();
      
        X.add(beginWord); //Creating the start of the future paths
      
        DFS(X,beginWord,endWord,Distances,Neighbours);
        //DFS finds all the paths
      
        return Ans;
        
    }
    
    public void DFS(ArrayList<String> Cur,String s,String e, HashMap<String,Integer> Dist,HashMap<String,ArrayList<String>> G){
        if(s.equals(e)){
            //Path completed!
            Ans.add(new ArrayList<String>(Cur));
            return;
        }
        
        for(String AdjWord:G.getOrDefault(s,new ArrayList<String>())){
            //it is the next word;
            if(Dist.get(AdjWord)==Dist.get(s)+1){
                //Important check so that our distance to end is minimum AND all nodes are in the curr list.
                Cur.add(AdjWord);
                DFS(Cur,AdjWord,e,Dist,G);
                Cur.remove(Cur.size()-1);
            }
            
        }
        
    }
    
    
    
    
    
}
