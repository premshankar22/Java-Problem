package BinaryTree;

class Node {
  int data;
  Node left, right;

  Node(int item) {
    data = item;
    left = right = null;
  }
}

public class IdenticalBinaryTree {

  public static boolean isIdentical(Node root1, Node root2) {

    if (root1 == null && root2 == null)
      return true;

    if (root1 == null || root2 == null)
      return false;

    return (root1.data == root2.data)
        && isIdentical(root1.left, root2.left)
        && isIdentical(root1.right, root2.right);
  }

  public static void main(String[] args) {
    // Tree 1
    Node root1 = new Node(1);
    root1.left = new Node(2);
    root1.right = new Node(3);
    root1.left.left = new Node(41);
    root1.left.right = new Node(5);

    // Tree 2
    Node root2 = new Node(1);
    root2.left = new Node(2);
    root2.right = new Node(3);
    root2.left.left = new Node(4);
    root2.left.right = new Node(5);

    if (isIdentical(root1, root2))
      System.out.println("Both trees are identical.");
    else
      System.out.println("Trees are not identical.");
  }
}
