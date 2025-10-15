/* Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.

 

Example 1:


Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 8  */

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

public class UniqueBSTs {

  // Function to generate all unique BSTs
  public List<TreeNode> generateTrees(int n) {
    if (n == 0)
      return new ArrayList<>();
    return generateTreesHelper(1, n);
  }

  // Helper function to generate BSTs with values from start to end
  private List<TreeNode> generateTreesHelper(int start, int end) {
    List<TreeNode> allTrees = new ArrayList<>();

    if (start > end) {
      allTrees.add(null); // empty tree
      return allTrees;
    }

    // pick each number as root
    for (int i = start; i <= end; i++) {
      // recursively generate all left and right subtrees
      List<TreeNode> leftTrees = generateTreesHelper(start, i - 1);
      List<TreeNode> rightTrees = generateTreesHelper(i + 1, end);

      // combine left and right subtrees with root i
      for (TreeNode left : leftTrees) {
        for (TreeNode right : rightTrees) {
          TreeNode root = new TreeNode(i);
          root.left = left;
          root.right = right;
          allTrees.add(root);
        }
      }
    }

    return allTrees;
  }

  // Helper function to print BST in pre-order
  public void printPreOrder(TreeNode root) {
    if (root == null) {
      System.out.print("null ");
      return;
    }
    System.out.print(root.val + " ");
    printPreOrder(root.left);
    printPreOrder(root.right);
  }

  public static void main(String[] args) {
    int n = 3;
    UniqueBSTs generator = new UniqueBSTs();
    List<TreeNode> trees = generator.generateTrees(n);

    System.out.println("Total unique BSTs: " + trees.size());
    int count = 1;
    for (TreeNode tree : trees) {
      System.out.print("Tree " + count + ": ");
      generator.printPreOrder(tree);
      System.out.println();
      count++;
    }
  }
}
