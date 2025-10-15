/*
 * 701. Insert into a Binary Search Tree
Medium
Topics
premium lock icon
Companies
You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

 

Example 1:


Input: root = [4,2,7,1,3], val = 5
Output: [4,2,7,1,3,5]
Explanation: Another accepted tree is:

Example 2:

Input: root = [40,20,60,10,30,50,70], val = 25
Output: [40,20,60,10,30,50,70,null,null,25]
Example 3:

Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
Output: [4,2,7,1,3,5]
 

Constraints:

The number of nodes in the tree will be in the range [0, 104].
-108 <= Node.val <= 108
All the values Node.val are unique.
-108 <= val <= 108
It's guaranteed that val does not exist in the original BST.
 * 
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

public class InsertIntoBST {

  // Function to insert val into BST
  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val); // create new node if tree/subtree is empty
    }

    if (val < root.val) {
      root.left = insertIntoBST(root.left, val);
    } else { // val > root.val (guaranteed unique)
      root.right = insertIntoBST(root.right, val);
    }

    return root;
  }

  // Helper function to print tree in level-order
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

    // Remove trailing "null"s for cleaner output
    int i = result.size() - 1;
    while (i >= 0 && result.get(i).equals("null")) {
      result.remove(i);
      i--;
    }

    System.out.println(result);
  }

  // Main method to test the program
  public static void main(String[] args) {
    /*
     * Example BST:
     * 4
     * / \
     * 2 7
     * / \
     * 1 3
     */
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(7);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);

    int val = 5;

    InsertIntoBST bst = new InsertIntoBST();
    TreeNode newRoot = bst.insertIntoBST(root, val);

    System.out.println("BST after insertion:");
    bst.printLevelOrder(newRoot);
  }
}
