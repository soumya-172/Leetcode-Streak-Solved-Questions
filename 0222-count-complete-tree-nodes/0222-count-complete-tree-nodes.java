/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        
        //tc -> O((logN)^2)
        
        if(root == null) return 0;
        
        int lh = findHightLeft(root);
        int rh = findHightRight(root);
        
        // if left and right height are equal then the tree is complete and we can return (2^height - 1) as anwer
        if(lh == rh) return ((2<<lh) - 1);
        
        // else recursively count the nodes in left and right part and return them by summing up by 1, 1 for the root itself
        else return (1 + countNodes(root.left) + countNodes(root.right));
    }
    
    public int findHightLeft(TreeNode root){
        int count = 0;
        
        while(root.left != null){
            count++;
            root = root.left;
        }
        
        return count;
    }
    
    public int findHightRight(TreeNode root){
        int count = 0;
        
        while(root.right != null){
            count++;
            root = root.right;
        }
        
        return count;
    }
    
    
}