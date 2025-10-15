/* 
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

 

Example 1:


Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:


Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in a strictly increasing order.
 */

package BinaryTree;

// Only one public class per file
public class SortedArrayToBST {

  // Definition for a binary tree node
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  // Function to convert sorted array to height-balanced BST
  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0)
      return null;
    return buildBST(nums, 0, nums.length - 1);
  }

  // Recursive helper function
  private TreeNode buildBST(int[] nums, int left, int right) {
    if (left > right)
      return null;

    int mid = left + (right - left) / 2;
    TreeNode node = new TreeNode(nums[mid]);

    node.left = buildBST(nums, left, mid - 1);
    node.right = buildBST(nums, mid + 1, right);

    return node;
  }

  // Helper function to print tree in-order
  public void printInOrder(TreeNode root) {
    if (root != null) {
      printInOrder(root.left);
      System.out.print(root.val + " ");
      printInOrder(root.right);
    }
  }

  // Main method
  public static void main(String[] args) {
    int[] nums1 = { -10, -3, 0, 5, 9 };
    int[] nums2 = { 1, 3 };

    SortedArrayToBST converter = new SortedArrayToBST();

    TreeNode root1 = converter.sortedArrayToBST(nums1);
    TreeNode root2 = converter.sortedArrayToBST(nums2);

    System.out.println("In-order traversal of BST from nums1:");
    converter.printInOrder(root1);
    System.out.println();

    System.out.println("In-order traversal of BST from nums2:");
    converter.printInOrder(root2);
  }
}
