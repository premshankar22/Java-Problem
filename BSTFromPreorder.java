/*
 * 
 * Construct Binary Search Tree from Preorder Traversal

Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.

It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.

A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.

A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.

 

Example 1:


Input: preorder = [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
Example 2:

Input: preorder = [1,3]
Output: [1,null,3]
 

Constraints:

1 <= preorder.length <= 100
1 <= preorder[i] <= 1000
All the values of preorder are unique.
 */

package BinaryTree;

import java.util.*;

// Definition for a binary tree node
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;
  }
}

public class BSTFromPreorder {

  private int index = 0; // to track current element in preorder array

  // Main function to construct BST from preorder array
  public TreeNode bstFromPreorder(int[] preorder) {
    return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  // Helper function using bounds
  private TreeNode helper(int[] preorder, int lower, int upper) {
    if (index == preorder.length)
      return null;

    int val = preorder[index];
    if (val < lower || val > upper)
      return null;

    index++;
    TreeNode root = new TreeNode(val);
    root.left = helper(preorder, lower, val); // left subtree: values < val
    root.right = helper(preorder, val, upper); // right subtree: values > val
    return root;
  }

  // Level-order traversal to display tree
  public void printLevelOrder(TreeNode root) {
    if (root == null) {
      System.out.println("[]");
      return;
    }

    List<String> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node != null) {
        result.add(String.valueOf(node.val));
        queue.offer(node.left);
        queue.offer(node.right);
      } else {
        result.add("null");
      }
    }

    // Remove trailing nulls
    int i = result.size() - 1;
    while (i >= 0 && result.get(i).equals("null")) {
      result.remove(i);
      i--;
    }

    System.out.println(result);
  }

  // Main method
  public static void main(String[] args) {
    int[] preorder = { 8, 5, 1, 7, 10, 12 };

    BSTFromPreorder bstBuilder = new BSTFromPreorder();
    TreeNode root = bstBuilder.bstFromPreorder(preorder);

    System.out.println("BST constructed from preorder:");
    bstBuilder.printLevelOrder(root);
  }
}


OUTPUT : 
BST constructed from preorder:
[8, 5, 10, 1, 7, null, 12]

