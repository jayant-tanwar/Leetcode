/* Iterative Solution Using Parent Pointers
If we have parent pointers for each node we can traverse back from p and q to get their ancestors.
The first common node we get during this traversal would be the LCA node. We can save the parent pointers in a dictionary
as we traverse the tree.

Algorithm:
1. Start from the root node and traverse the tree.
2. Until we find p and q both, keep storing the parent pointers in a dictionary.
3. Once we have found both p and q, we get all the ancestors for p using the parent dictionary and add to a set called
ancestors.
4. Similarly, we traverse through ancestors for node q. If the ancestor is present in the ancestors set for p, this mean
this is the first ancestor common between p and q( while traversing upwards) and hence this is the LCA node.

*/

class Solution{
  public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p , TreeNode q){
        //Stack for the tree traversal
        Deque<TreeNode> stack = new ArrayDeque<>();
        
        //HashMap for parent pointers
        Map<TreeNode,TreeNode> parent =new HashMap<>();
        
        parent.put(root,null);
        stack.push(root);
        
        //iterate until we both find the both nodes p and q
        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node=stack.pop();
            
            //While traversing the tree, keep saving the parent pointers
            
            if(node.left!=null){
                parent.put(node.left,node);
                stack.push(node.left);}
                
            if(node.right!=null){
                parent.put(node.right,node);
                 stack.push(node.right);
             }
          }
          
          //Ancestors set)_ for node p.
          Set<TreeNode> ancestors=new HashSet<>();
          
          //Process all ancestors for node p using parent pointers.
          while(p!=null){
            ancestor.add(p);
            p=parent.get(p);
            }
            //First ancestor of q which appears in p's ancestor set() is their lowest common ancestor.
            
            while(!ancestors.contains(q)){
              q=parent.get(q);
                }
             
             return q;
             }
             }
             
          
          
          
                 
            
            
            
            
            
            
            
