package com.knubisoft.base.trees;

import java.util.List;
import java.util.Objects;

public interface TreeTasks {

    //Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
        }
    }

    /**
     * Given the roots of two binary trees node1 and node2, implement the method to check if they are the same or not.
     * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
     * <p>
     * Example 1:
     * <p>
     * 1           1
     * / \         / \
     * 2   3       2   3
     * <p>
     * input: node1 = [1,2,3] node2 = [1,2,3]
     * output: true
     * <p>
     * Example 2:
     * <p>
     * 1             1
     * /            /  \
     * 2          null   2
     * <p>
     * input: node1 = [1,2] node2 = [1,null,2]
     * output: false
     * <p>
     * Example 3:
     * <p>
     * 1           1
     * / \         / \
     * 2   1       1   2
     * <p>
     * input: node1 = [1,2] node2 = [1,1,2]
     * output: false
     *
     * @param node1 First root node.
     * @param node2 Second root node.
     */
    boolean isSameTree(TreeNode node1, TreeNode node2);

    /**
     * Given the root of a binary tree, return the inorder traversal of its nodes' values.
     * Note, for inorder, you traverse from the left subtree to the root then to the right subtree.
     * <p>
     * Example 1:
     * <p>
     * input:        1
     * \
     * 2
     * /
     * 3
     * <p>
     * output: [1,3,2]
     * <p>
     * Example 2:
     * <p>
     * input:         1
     * /  \
     * 2    3
     * / \  / \
     * 4  5 6  7
     * / \
     * 8   9
     * <p>
     * output: [8,4,9,2,5,1,6,3,7]
     * <p>
     * Example 3:
     * <p>
     * input:          1
     * /   \
     * 2     3
     * / \   /
     * 4   5 6
     * <p>
     * output: [4,2,5,1,6,3]
     * <p>
     * Example 4:
     * <p>
     * input: node = []
     * output: []
     * <p>
     * Example 5:
     * <p>
     * input: node = [1]
     * output: [1]
     *
     * @param node Root node.
     * @return Tree values in inordered traversal
     */
    List<Integer> inorderTraversal(TreeNode node);

    /**
     * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
     * <p>
     * Example 1:
     * <p>
     * input: node - [1,2,2,3,4,4,3]
     * <p>
     * 1
     * / |  \
     * 2   |   2
     * / \  |  / \
     * 3  4  | 4   3
     * <p>
     * output: true
     * Example 2:
     * <p>
     * input: node - [1,2,2,null,3,null,3]
     * <p>
     * 1
     * /  |  \
     * 2   |   2
     * /  \  |  /  \
     * null 3 | null 3
     * <p>
     * output: false
     *
     * @param node Root node.
     */
    boolean isSymmetric(TreeNode node);

    /**
     * Given the root of a binary tree, return its maximum depth.
     * <p>
     * A binary tree's maximum depth is the number of nodes
     * along the longest path from the root node down to the farthest leaf node.
     * <p>
     * Example 1:
     * <p>
     * input: node - [3,9,20,null,null,15,17]
     * <p>
     * 3
     * /  \
     * 9   20
     * / \
     * 15   7
     * <p>
     * output: 3
     * <p>
     * Example 2:
     * <p>
     * input: node - [1,null,2]
     * <p>
     * 1
     * /  \
     * null   2
     * <p>
     * output: 2
     * <p>
     * Example 3:
     * <p>
     * input: node - [74,13,21,null,null,15,7,null,null,17,23]
     * <p>
     * 74
     * /  \
     * 13  21
     * / \
     * 15   7
     * / \
     * 17 23
     * <p>
     * output: 4
     *
     * @param node Root node.
     * @return Maximum depth value.
     */
    int maxDepth(TreeNode node);

    /**
     * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path
     * such that adding up all the values along the path equals targetSum.
     * <p>
     * A leaf is a node with no children.
     * <p>
     * Example 1:
     * <p>
     * input: node - [5,4,8,11,null,13,4,7,2,null,null,null,1] targetSum - 22
     * <p>
     * [5]
     * /  \
     * [4]    8
     * /     / \
     * [11]     13  4
     * /  \         \
     * 7   [2]         1
     * <p>
     * output: true
     * explanation: The root-to-leaf path with the target sum is shown in square brackets.
     * <p>
     * Example 2:
     * <p>
     * input: node - [1,2,3] targetSum - 5
     * <p>
     * 1
     * /  \
     * 2    3
     * <p>
     * output: false
     * explanation: There two root-to-leaf paths in the tree:
     * (1 --> 2): The sum is 3.
     * (1 --> 3): The sum is 4.
     * There is no root-to-leaf path with sum = 5.
     *
     * @param node      Root node.
     * @param targetSum Target sum.
     */
    boolean hasPathSum(TreeNode node, int targetSum);

    /**
     * Given the root of a binary tree, invert the tree, and return its root.
     * <p>
     * Example 1:
     * <p>
     * input: node - [4,2,7,1,3,6,9]
     * <p>
     * 4                   4
     * /  \                /  \
     * 2     7    ----->   7     2
     * / \   / \           / \   / \
     * 1  3  6  9          9  6  3   1
     * <p>
     * output: node - [4,7,2,9,6,3,1]
     * <p>
     * Example 2:
     * <p>
     * input: node - [2,1,3]
     * <p>
     * 2                  2
     * /  \    ----->     /  \
     * 1     3            3     1
     * <p>
     * <p>
     * output: node - [2,3,1]
     *
     * @param node Root node.
     * @return Root of inverted tree.
     */
    TreeNode invertTree(TreeNode node);

    /**
     * Given the root of a binary tree, return the sum of all left leaves.
     * <p>
     * A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
     * <p>
     * Example 1:
     * <p>
     * input: node - [3,9,20,null,null,15,7]
     * <p>
     * 3
     * /  \
     * 9   20
     * / \
     * 15   7
     * <p>
     * output: 24
     * explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
     * <p>
     * Example 2:
     * <p>
     * input: node - [3,7,20,23,1,15,7]
     * <p>
     * 3
     * /   \
     * 7      20
     * / \    /  \
     * 23  1   15   7
     * <p>
     * output: 38
     * explanation: There are two left leaves in the binary tree, with values 23 and 15 respectively.
     * <p>
     * Example 3:
     * <p>
     * input: node - [1]
     * output: 0
     * <p>
     * Example 4:
     * <p>
     * input: node - [3,7,20,23,1,15,7]
     * <p>
     * 3
     * /   \
     * 7      20
     * / \    /  \
     * 23  1   15   7
     * /  \
     * 41   16
     * /  \
     * 17   41
     * <p>
     * output: 73
     * explanation: There are three left leaves in the binary tree, with values 41, 17 and 15 respectively.
     *
     * @param node Root node.
     * @return Sum of left leaves.
     */
    int sumOfLeftLeaves(TreeNode node);

    /**
     * You are given two binary trees root1 and root2.
     * <p>
     * Imagine that when you put one of them to cover the other,
     * some nodes of the two trees are overlapped while the others are not.
     * The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
     * Otherwise, the NOT null node will be used as the node of the new tree.
     * <p>
     * Return the merged tree.
     * <p>
     * Note: The merging process must start from the root nodes of both trees.
     * <p>
     * Example 1:
     * <p>
     * input: node1 - [1,3,2,5] node2 - [2,1,3,null,4,null,7]
     * <p>
     * 1                   2                      3
     * /  \                /  \                   /  \
     * 3     2      +       1    3     ---->       4    5
     * /                      \    \              /  \    \
     * 5                        4    7            5   4     7
     * <p>
     * output: [3,4,5,5,4,null,7]
     * <p>
     * Example 2:
     * <p>
     * input: node1 - [1,2,3,4,5,10,1,4] node2 - [8,7,3,10,4,null,7]
     * <p>
     * 1                   8                      9
     * /  \                /  \                   /  \
     * 3     2      +       7    3     ---->      10    5
     * / \   / \            / \    \              /  \  / \
     * 5  10 1   4         10   4    7           15  14 1  11
     * <p>
     * output: [8,10,5,15,14,1,11]
     *
     * @param node1 First root node.
     * @param node2 Second root node.
     * @return Merged tree.
     */
    TreeNode mergeTrees(TreeNode node1, TreeNode node2);
}
