/*
 * 
 * All Elements in Two Binary Search Trees
Medium
Topics
premium lock icon
Companies
Hint
Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.

 

Example 1:


Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
Example 2:


Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]
 

Constraints:

The number of nodes in each tree is in the range [0, 5000].
-105 <= Node.val <= 105
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

public class AllElementsBST {

  // Function to get all elements from two BSTs in sorted order
  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    inOrder(root1, list1);
    inOrder(root2, list2);

    return mergeSortedLists(list1, list2);
  }

  // In-order traversal to get sorted elements
  private void inOrder(TreeNode node, List<Integer> list) {
    if (node == null)
      return;
    inOrder(node.left, list);
    list.add(node.val);
    inOrder(node.right, list);
  }

  // Merge two sorted lists
  private List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
    List<Integer> merged = new ArrayList<>();
    int i = 0, j = 0;
    while (i < list1.size() && j < list2.size()) {
      if (list1.get(i) <= list2.get(j)) {
        merged.add(list1.get(i++));
      } else {
        merged.add(list2.get(j++));
      }
    }

    while (i < list1.size())
      merged.add(list1.get(i++));
    while (j < list2.size())
      merged.add(list2.get(j++));

    return merged;
  }

  // Main method to test
  public static void main(String[] args) {
    /*
     * Example BSTs:
     * root1: 2
     * / \
     * 1 4
     * 
     * root2: 1
     * / \
     * 0 3
     */
    TreeNode root1 = new TreeNode(2);
    root1.left = new TreeNode(1);
    root1.right = new TreeNode(4);

    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(0);
    root2.right = new TreeNode(3);

    AllElementsBST solution = new AllElementsBST();
    List<Integer> result = solution.getAllElements(root1, root2);

    System.out.println("All elements in sorted order: " + result);
  }
}
