/*
 * 
 * Convert BST to Greater Tree
Medium
Topics
premium lock icon
Companies
Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.

As a reminder, a binary search tree is a tree that satisfies these constraints:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
Example 2:

Input: root = [0,null,1]
Output: [1,null,1]
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-104 <= Node.val <= 104
All the values in the tree are unique.
root is guaranteed to be a valid binary search tree.
 * 
 */

package BinaryTree;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BSTToGreaterTree {
    // Running sum of all visited nodes
    private int sum = 0;

    // Function to convert BST to Greater Tree
    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;

        // Traverse the right subtree first (greater values)
        convertBST(root.right);

        // Update current node with sum of greater nodes
        sum += root.val;
        root.val = sum;

        // Traverse the left subtree
        convertBST(root.left);

        return root;
    }

    // Helper function to print in-order traversal
    public void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }

    // Main method to test the program
    public static void main(String[] args) {
        /*
         * Example BST:
         * 4
         * / \
         * 1 6
         * / \ / \
         * 0 2 5 7
         * \ \
         * 3 8
         */
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        BSTToGreaterTree converter = new BSTToGreaterTree();
        TreeNode newRoot = converter.convertBST(root);

        System.out.println("In-order traversal of Greater Tree:");
        converter.printInOrder(newRoot);
    }
}
