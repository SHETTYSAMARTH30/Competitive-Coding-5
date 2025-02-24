// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

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
    public List<Integer> largestValues(TreeNode root) {
        
        //we will store all the max value at each level
        List<Integer> result = new ArrayList<>();

        if(root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        //Level order traversal at each level
        while(!q.isEmpty()) {

            int len = q.size();

            //Reset max at each level
            int max = Integer.MIN_VALUE;

            //We will perform level order traversal
            for(int i = 0; i < len; i++) {

                TreeNode curr = q.poll();
                int val = curr.val;

                //check if it is greatest value at that level and store it
                if(val > max)
                    max = val;

                //add its children in q
                if(curr.left != null)
                    q.add(curr.left);
                
                if(curr.right != null)
                    q.add(curr.right);
            }

            //after all the elements are scanned at each level add the result
            result.add(max);
        }
        
        return result;
    }
}