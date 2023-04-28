import java.util.HashSet;
import java.util.Set;

/**
 * Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node.
 * Note that the intersection is defined based on reference, not value. That is, if the kth
 * node of the first linked list is the exact same node (by reference) as the jth node of the second
 * linked list, then they are intersecting.
 */
public class Main {

  /**
   * A brute force solution would be to traverse through all nodes of <b>b</b> for each node of <b>a</b> and checking
   * if they are the same by reference. If they are - return that node.
   *
   * Time Complexity: O(ab)
   * Space Complexity: O(1)
   */
  public static Node findIntersectionV1(Node a, Node b) {
    if (a == null || b == null) {
      return null;
    }

    Node current = b;

    while (a != null) {
      while (current != null) {
        if (a == current) {
          return a;
        }

        current = current.next;
      }

      // Advance a
      a = a.next;

      // Reset current
      current = b;
    }

    return null;
  }

  /**
   * An optimization of V1 could be achieved white using a set to store the elements you passed through by reference,
   * and if the same one occurs at any point - an intersection exists.
   *
   * Time Complexity: O(l)
   * Space Complexity: O(l)
   *
   * <i>where l is the node with bigger length</i>
   */
  public static Node findIntersectionV2(Node a, Node b) {
    if (a == null || b == null) {
      return null;
    }

    Set<Node> cache = new HashSet<>();

    while (a != null && b != null) {
      if (cache.contains(a)) {
        return a;
      }

      cache.add(a);

      if (cache.contains(b)) {
        return b;
      }

      cache.add(b);

      a = a.next;
      b = b.next;
    }

    // In case a.length > b.length
    while (a != null) {
      if (cache.contains(a)) {
        return a;
      }

      cache.add(a);

      a = a.next;
    }

    // In case b.length > a.length
    while (b != null) {
      if (cache.contains(b)) {
        return b;
      }

      cache.add(b);

      b = b.next;
    }

    return null;
  }

  /**
   * In this approach we make use of the fact that if the lists have intersection,
   * and we denote the first node of the intersection with k we could conclude that the list size will be k.length + n where n is the amount of elements before k.
   * In order to establish if intersection exists in 1 pass - we need to compare the nodes on the same positions within the lists as we go,
   * but since their length varies - we cannot do that unless we make them equal. That means we will have to make n steps for both of them to reach k, if it exists.
   *
   * To realize it, we would need:
   * <ol>
   *   <li>Length of the lists</li>
   *   <li>Their size difference, if any</li>
   *   <li>Way to add the difference in nodes to make them the same length</li>
   * </ol>
   *
   * Time Complexity: O(n), derived from O(3n) by removing the constants
   * Space Complexity: O(1)
   */
  public static Node findIntersectionV3(Node a, Node b) {
    if (a == null || b == null) {
      return null;
    }

    int aLength = getLength(a);
    int bLength = getLength(b);

    int diff = Math.abs(aLength - bLength);

    Node smaller = aLength < bLength ? a : b;
    Node bigger = bLength > aLength ? b : a;

    smaller = prependNodes(smaller, diff);

    while (smaller != null) {
      if (smaller == bigger) {
        return smaller;
      }

      smaller = smaller.next;
      bigger = bigger.next;
    }

    return null;
  }

  private static int getLength(Node n) {
    int counter = 0;

    while (n != null) {
      counter++;

      n = n.next;
    }

    return counter;
  }

  private static Node prependNodes(Node n, int count) {
    if (n == null || count <= 0) {
      return n;
    }

    // Adding new nodes and continuously
    // changing the head (current)
    Node current = n;
    for (int i = 0; i < count; i++) {
      Node newNode = new Node(0);
      newNode.next = current;
      current = newNode;
    }

    return current;
  }
}
