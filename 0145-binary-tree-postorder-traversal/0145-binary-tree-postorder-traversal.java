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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        ArrayList<Integer> postOrderList = new ArrayList<>();
        
        return postOrderTrav(root, postOrderList);
    }
    
    public static ArrayList<Integer> postOrderTrav(TreeNode curr, ArrayList<Integer> postOrderList){
        if(curr == null){
            return postOrderList;
        }
        
        postOrderTrav(curr.left, postOrderList);
        postOrderTrav(curr.right, postOrderList);
        postOrderList.add(curr.val);
        
        return postOrderList;
    }
}