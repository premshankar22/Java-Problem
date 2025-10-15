/*
 *450. Delete Node in a BST
Medium
Topics
premium lock icon
Companies
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
 

Example 1:


Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

Example 2:

Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.
Example 3:

Input: root = [], key = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-105 <= Node.val <= 105
Each node has a unique value.
root is a valid binary search tree.
-105 <= key <= 105
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

public class DeleteNodeBST {

  // Function to delete a node with given key in BST
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null)
      return null;

    if (key < root.val) {
      root.left = deleteNode(root.left, key);
    } else if (key > root.val) {
      root.right = deleteNode(root.right, key);
    } else {
      // Node to delete found
      if (root.left == null) {
        return root.right; // replace with right child
      } else if (root.right == null) {
        return root.left; // replace with left child
      } else {
        // Node has two children
        TreeNode successor = findMin(root.right); // find in-order successor
        root.val = successor.val; // copy successor value to current node
        root.right = deleteNode(root.right, successor.val); // delete successor
      }
    }

    return root;
  }

  // Helper to find minimum node in BST (leftmost node)
  private TreeNode findMin(TreeNode node) {
    while (node.left != null)
      node = node.left;
    return node;
  }

  // Level-order traversal to display tree structure
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

  // Main method to test deletion
  public static void main(String[] args) {
    /*
     * Example BST:
     * 5
     * / \
     * 3 6
     * / \ \
     * 2 4 7
     */
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.right.right = new TreeNode(7);

    int key = 3; // Node to delete

    DeleteNodeBST bst = new DeleteNodeBST();
    TreeNode newRoot = bst.deleteNode(root, key);

    System.out.println("BST after deleting key " + key + ":");
    bst.printLevelOrder(newRoot);
  }
}
