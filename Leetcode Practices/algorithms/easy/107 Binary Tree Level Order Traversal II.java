/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/



// My Solution:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        nodeList.add(root);
        while (!nodeList.isEmpty()) {
            List<Integer> tmpList = new ArrayList<Integer>();
            for (TreeNode node : nodeList) tmpList.add(node.val);
            res.add(tmpList);
            
            List<TreeNode> tmpNodeList = new ArrayList<TreeNode>(nodeList);
            nodeList.clear();
            for (TreeNode node : tmpNodeList) {
                if (node.left != null) nodeList.add(node.left);
                if (node.right != null) nodeList.add(node.right);
            }
        }
        Collections.reverse(res);
        
        return res;
    }
}