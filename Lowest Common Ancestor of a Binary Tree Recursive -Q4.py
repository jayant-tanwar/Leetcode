#Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
#According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
#Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
#Example 1:
#Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
#Output: 3
#Explanation: The LCA of nodes 5 and 1 is 3
#link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

##### A Recurive Solution - From b2bswe

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root, p, q):
        if(root==None): return None
        def LCA(root,p,q):
            if(root==None): return None
            if(root.val==p.val or root.val==q.val): return root
            
            l=LCA(root.left,p,q)
            r=LCA(root.right,p,q)
            
            if(l==None):
                return r
            if(r==None):
                return l
            
            if(l!=None and r!=None):
                #both sides gave some answer then 
                return root
        return LCA(root,p,q)
 
##Find the iterative solution in Java

   



