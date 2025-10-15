/*
 * Range Sum of BST

 * Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].

 

Example 1:


Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
Example 2:


Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23
Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
 

Constraints:

The number of nodes in the tree is in the range [1, 2 * 104].
1 <= Node.val <= 105
1 <= low <= high <= 105
All Node.val are unique.
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

public class RangeSumBST {

  // Function to compute sum of nodes in [low, high]
  public int rangeSumBST(TreeNode root, int low, int high) {
    if (root == null)
      return 0;

    int sum = 0;

    // Only explore left subtree if it may contain nodes >= low
    if (root.val > low) {
      sum += rangeSumBST(root.left, low, high);
    }

    // Include current node if it's within range
    if (root.val >= low && root.val <= high) {
      sum += root.val;
    }

    // Only explore right subtree if it may contain nodes <= high
    if (root.val < high) {
      sum += rangeSumBST(root.right, low, high);
    }

    return sum;
  }

  // Main method to test the program
  public static void main(String[] args) {
    /*
     * Example BST:
     * 10
     * / \
     * 5 15
     * / \ \
     * 3 7 18
     */
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(15);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(7);
    root.right.right = new TreeNode(18);

    int low = 7, high = 15;

    RangeSumBST solver = new RangeSumBST();
    int sum = solver.rangeSumBST(root, low, high);

    System.out.println("Range Sum of BST in [" + low + ", " + high + "] = " + sum);
  }
}
