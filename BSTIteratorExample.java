/* Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.

You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.

 

Example 1:


Input
["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
Output
[null, 3, 7, true, 9, true, 15, true, 20, false]

Explanation
BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
bSTIterator.next();    // return 3
bSTIterator.next();    // return 7
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 9
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 15
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 20
bSTIterator.hasNext(); // return False
 

Constraints:

The number of nodes in the tree is in the range [1, 105].
0 <= Node.val <= 106
At most 105 calls will be made to hasNext, and next. */

package BinaryTree;

import java.util.Stack;

// Definition for a binary tree node
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;
  }
}

// BSTIterator class
class BSTIterator {
  private Stack<TreeNode> stack;

  // Constructor: initialize the stack with the leftmost path of the tree
  public BSTIterator(TreeNode root) {
    stack = new Stack<>();
    pushLeft(root);
  }

  // Push all left children of a node to the stack
  private void pushLeft(TreeNode node) {
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
  }

  // Return the next smallest number in BST
  public int next() {
    if (!hasNext()) {
      throw new IllegalStateException("No next element");
    }
    TreeNode node = stack.pop();
    // If the node has a right child, push its leftmost path
    if (node.right != null) {
      pushLeft(node.right);
    }
    return node.val;
  }

  // Return true if there is a next smallest number
  public boolean hasNext() {
    return !stack.isEmpty();
  }
}

// Example usage
public class BSTIteratorExample {
  public static void main(String[] args) {
    /*
     * Construct BST:
     * 7
     * / \
     * 3 15
     * / \
     * 9 20
     */
    TreeNode root = new TreeNode(7);
    root.left = new TreeNode(3);
    root.right = new TreeNode(15);
    root.right.left = new TreeNode(9);
    root.right.right = new TreeNode(20);

    BSTIterator iterator = new BSTIterator(root);

    System.out.println(iterator.next()); // 3
    System.out.println(iterator.next()); // 7
    System.out.println(iterator.hasNext()); // true
    System.out.println(iterator.next()); // 9
    System.out.println(iterator.hasNext()); // true
    System.out.println(iterator.next()); // 15
    System.out.println(iterator.hasNext()); // true
    System.out.println(iterator.next()); // 20
    System.out.println(iterator.hasNext()); // false
  }
}



OUTPUT : 

3
7
true
9
true
15
true
20
false

