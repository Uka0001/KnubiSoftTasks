package com.knubisoft.base.trees;

import java.util.ArrayList;
import java.util.List;


public class TreeTasksImpl implements TreeTasks {

    @Override
    public boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 != null && node2 == null) {
            return false;
        }
        if (node2 == null && node1 != null) {
            return false;
        }
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1.val != node2.val) {
            return false;
        }
        return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
    }

    @Override
    public List<Integer> inorderTraversal(TreeNode node) {
        List<Integer> ans = new ArrayList<>();
        if(node==null){
            return ans;
        }
        else if(node.right==null && node.left==null){
            ans.add(node.val);
            return ans;
        }
        else{
            return inOrder(node,ans);
        }
    }

    private List<Integer> inOrder(TreeNode point, List<Integer> ref){
        if(point==null){
            return ref;
        }
        inOrder(point.left,ref);
        ref.add(point.val);
        inOrder(point.right,ref);
        return ref;
    }

    @Override
    public boolean isSymmetric(TreeNode node) {
        if(node == null) return true;
        return validateTrees(node.left, node.right);
    }

    private boolean validateTrees(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if((left == null && right != null) || (left != null && right == null)) return false;
        if(left.val != right.val) return false;

        return validateTrees(left.left, right.right) && validateTrees(left.right, right.left);
    }

    @Override
    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    @Override
    public boolean hasPathSum(TreeNode node, int targetSum) {
        if(node == null){
            return false;
        }
        else if(node.left == null && node.right == null && targetSum - node.val == 0){
            return true;
        }
        else{
            return hasPathSum(node.left, targetSum - node.val) || hasPathSum(node.right, targetSum - node.val);
        }
    }

    @Override
    public TreeNode invertTree(TreeNode node) {
        if ( null == node ) return node;
        TreeNode left  = invertTree( node.left );

        node.left = invertTree( node.right );
        node.right = left;
        return node;
    }

    @Override
    public int sumOfLeftLeaves(TreeNode node) {
        if (node == null) return 0;

        if (node.left == null && node.right == null) return 0;

        return findSumOfLeaves(node, false);
    }

    private int findSumOfLeaves(TreeNode root, boolean isLeftNode) {

        if (root == null) return 0;

        if (root.left == null && root.right == null) { // leaf node
            if (isLeftNode)
                return root.val;
            else
                return 0;
        }

        int sum1 = findSumOfLeaves(root.left, true);
        int sum2 = findSumOfLeaves(root.right, false);

        return sum1 + sum2;
    }

    @Override
    public TreeNode mergeTrees(TreeNode node1, TreeNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        node1.val += node2.val;
        node1.left = mergeTrees(node1.left, node2.left);
        node1.right = mergeTrees(node1.right, node2.right);
        return node1;
    }
}
