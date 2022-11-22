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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        ArrayList<Integer> inOrderList = new ArrayList<>();
                
        return inOrderTrav(root, inOrderList);
    }
    
    public static ArrayList<Integer> inOrderTrav(TreeNode curr, ArrayList<Integer> inOrderList){
        if(curr == null){
            return inOrderList;
        }
        
        inOrderTrav(curr.left, inOrderList);
        inOrderList.add(curr.val);
        inOrderTrav(curr.right, inOrderList);
        
        return inOrderList;
    }
}