package Day1;

public class Trie {
	//Implement Trie
	//Prefix Tree- Data Structure
	//Example of what Trie does
	/*
	 * Trie trie=new Trie();
	 * trie.insert("apple");
	 * trie.search("apple"); //return true
	 * trie.search("app"); //return false
	 * trie.startsWith("app"); //return true
	 * trie.insert("app");
	 * trie.search("app"); //return true
	 */
	//Assumption: all inputs of lowercase letters
	//all inputs are guaranteed to be non-empty strings.
	
	/*
	 * Applications:
	 * Trie (we pronounce "try")
	 * or prefix tree is a tree ds, which  is 
	 * used for retrieval of a key in a dataset
	 * of strings. There are various applictions
	 * of this very efficient data structure as such 
	 * as:
	 * 1. Google: Autocomplete
	 * 2. Spell Checker
	 * 3. IP routing aka Longest prefix matching
	 * 4. T9 preditive text
	 * 5. Solving word games
	 * 
	 * There are several data structures
	 * like balanced trees and hashtables, which give us the possibility to search for a word in a dataset of strings
	 * Then why do we need trie? Although hash table has O(1) time complexity for looking for a key, it is not efficient in the following operations:
	 * 1. Finding all keys with a common prefix.
	 * 2. Enumerating a dataset of strings in lexicographical order.
	 * 
	 * Another reason why trie outperforms hash table, is that has hash table increases in size, there are lots of hash collisions and the search time complexity could deteriorate to O(n).
	 * Where n in the number of keys inserted. Trie could use less space compared to hash table when storing many keys with the same prefix. In this case using trie has only O(m) time complexity,
	 * where m is the key length. Searching for a key in a balanced tree costs O(mlogn) time complexity.
	 * 
	 * 
	 * Trie node structure
	 * 
	 * Trie is a rooted tree. Its nodes have the following fields:
	 * 1. Maximum of R links to its children,where each link corresponds to one of R character values from the dataset alphabet.
	 * In this article that R is 26, the number of lowercase latin letters.
	 * 
	 * Boolean field which specifies whether the node corresponds to the end of the key, or is just a key prefix.
	 * 
	 */
	class TrieNode{
		private TrieNode[] Links;
		private final int R=26;
		private boolean isEnd;
		
		public TrieNode() {
			Links=new TrieNode[R];
		}
		
		public boolean containsKey(char ch) {
			return Links[ch-'a']!=null;
		}
		
		public TrieNode get(char ch) {
			return Links[ch-'a'];
		}
		
		public void put(char ch,TrieNode node) {
			Links[ch-'a']=node;
		}
		
		public void setEnd() {
			isEnd=true;
		}
		
		public boolean isEnd() {
			return isEnd;
		}
	}
	

	/*
	 * Two of the most common operations in a
	 * trie are insertion of a key and search for a key
	 * 
	 * Insertion for a key to a trie
	 * We insert a key by searching into the trie.
	 * We start from the root and search a link,
	 * which corresponds to the first key character.
	 * There are two cases:
	 * 
	 * A link exists. Then we move down the tree following the link to the next child level.
	 * The algorithm continue with searching for the next key character.
	 * 
	 * A link does not exist. Then we create a new node and link it with the parent's link matching the  current
	 * key character. We repeat this step until we encounter the last character of the key,
	 * then we mark the current node as an end node and the algorithm finishes.
	 */
		
	
		private TrieNode root;
		
		public Trie() {
			root = new TrieNode();
		}
		
		//Insert a word into the trie
		public void insert(String word) {
			
			TrieNode node=root;
			char[] charA=word.toCharArray();
			for(char ch: charA) {
				if(node.containsKey(ch)==false) {
					node.put(ch, new TrieNode());
				}
				node=node.get(ch);
			}
			node.setEnd();
		}
		
		/*
		 * Time Complexity : O(m), where m is the key length
		 * 
		 * In each iteration of the algorithm, we either examine or create a node in the trie till we reach the end of they key.
		 * Space Complexity: O(m)
		 * 
		 * In the worst case newly inserted key does not share a prefix with the keys already inserted in the trie.
		 * We have to add m new nodes, which takes us O(m) space.
		 * 
		 */
		
		/*
		 * Search for a key in trie
		 * 
		 * Each key is represented in the trie as a path from the root to the internal node or leaf.
		 * We start from the root with the first key character. We examine the current node for a link
		 * corresponding to the key character. There are two cases:
		 * 
		 * 1. A link exists. We move to the next node in the path from this link,and proceed searching for the next key character.
		 * 
		 * 2. A link does not exist. If there are no available key characters and current node is marked as isEnd we return true.
		 * Otherwise there are two cases in each of them we return false:
		 *   2.1. There are key characters left,but it is impossible to follow the key path in the trie and the key is missing.
		 *   2.2 No key characters are left, but the current node is not marked as isEnd. Therefore the search key is only a prefix of another key in the trie.
		 *   
		 *  
		 */
		
		public boolean search(String word) {
			TrieNode node=searchPrefix(word);
			return node!=null && node.isEnd();
		}
		private TrieNode searchPrefix(String word) {
			TrieNode node=root;
			char[] Arr=word.toCharArray();
			for(char ch:Arr) {
				if(node.containsKey(ch)) {
					node=node.get(ch);
				}
				else {
					return null;
				}
			}
			return node;
		}
		
		/*
		 * complexity analysis:
		 * Time Complexity: O(m) in each step of the algorithm we search for the next key character. In the worst case the algorithm performs m operations.
		 * Space Complexity: O(1)
		 */
		
		
		/*
		 * search for a key prefix in a trie
		 * 
		 * Here we do not consider the isEnd mark of the current trie node and we have to come to and end of the key prefix
		 * to return true.
		 * 
		 */
		
		public boolean startsWith(String prefix) {
			TrieNode node=searchPrefix(prefix);
			return node!=null;
		}
		
		/*
		 * Complexity analysis:
		 * 
		 * Time Complexity: O(m)
		 * 
		 * Space Complexity: O(1)
		 * 
		 */
	
		
		 
	
	
	
	
}
