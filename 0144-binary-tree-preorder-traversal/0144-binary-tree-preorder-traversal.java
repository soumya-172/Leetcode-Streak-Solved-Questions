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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> preOrder = new ArrayList<>();
        
        return preOrderTrav(root, preOrder);
    }
    
    public List<Integer> preOrderTrav(TreeNode curr, List<Integer> preOrder){
        if(curr == null){
            return preOrder;
        }
        
        preOrder.add(curr.val);
        preOrderTrav(curr.left, preOrder);
        preOrderTrav(curr.right, preOrder);
        
        return preOrder;
    }
}