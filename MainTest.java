import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  void findIntersectionV1() {
    Assertions.assertNull(Main.findIntersectionV1(null, null));
    Assertions.assertNull(Main.findIntersectionV1(null, new Node(1)));
    Assertions.assertNull(Main.findIntersectionV1(new Node(1), null));
    Assertions.assertNull(Main.findIntersectionV1(build(1, 2, 3), build(1, 2, 3)));
    Assertions.assertNull(Main.findIntersectionV1(build(1,1,1), build(1,1,1)));
    Assertions.assertNull(Main.findIntersectionV1(build(1,1,1), build(3,4,5,6,7)));

    Node intersection = getIntersection(3);

    Assertions.assertEquals(intersection, Main.findIntersectionV1(intersection, intersection), "Passing the same linked list will return the first node");

    Node a1 = build(1,2);
    getLast(a1).next = intersection;

    Node b1 = build(1,2);
    getLast(b1).next = intersection;

    Assertions.assertEquals(intersection, Main.findIntersectionV1(a1, b1));

    Node intersectionWithNoNodeAfter = getIntersection(0);

    Node a2 = build(1,2,3,4,4);
    getLast(a2).next = intersectionWithNoNodeAfter;

    Node b2 = build(1,2,3,4,5);
    getLast(b2).next = intersectionWithNoNodeAfter;

    Assertions.assertEquals(intersectionWithNoNodeAfter, Main.findIntersectionV1(a2, b2));

    Node a3 = build(3,4,4);
    getLast(a3).next = intersection;

    Node b3 = build(1,2,3,4,5);
    getLast(b3).next = intersection;

    Assertions.assertEquals(intersection, Main.findIntersectionV1(a3, b3));
  }

  @Test
  void findIntersectionV2() {
    Assertions.assertNull(Main.findIntersectionV2(null, null));
    Assertions.assertNull(Main.findIntersectionV2(null, new Node(1)));
    Assertions.assertNull(Main.findIntersectionV2(new Node(1), null));
    Assertions.assertNull(Main.findIntersectionV2(build(1, 2, 3), build(1, 2, 3)));
    Assertions.assertNull(Main.findIntersectionV2(build(1,1,1), build(1,1,1)));
    Assertions.assertNull(Main.findIntersectionV2(build(1,1,1), build(3,4,5,6,7)));

    Node intersection = getIntersection(3);

    Assertions.assertEquals(intersection, Main.findIntersectionV2(intersection, intersection), "Passing the same linked list will return the first node");

    Node a1 = build(1,2);
    getLast(a1).next = intersection;

    Node b1 = build(1,2);
    getLast(b1).next = intersection;

    Assertions.assertEquals(intersection, Main.findIntersectionV2(a1, b1));

    Node intersectionWithNoNodeAfter = getIntersection(0);

    Node a2 = build(1,2,3,4,4);
    getLast(a2).next = intersectionWithNoNodeAfter;

    Node b2 = build(1,2,3,4,5);
    getLast(b2).next = intersectionWithNoNodeAfter;

    Assertions.assertEquals(intersectionWithNoNodeAfter, Main.findIntersectionV2(a2, b2));

    Node a3 = build(3,4,4);
    getLast(a3).next = intersection;

    Node b3 = build(1,2,3,4,5);
    getLast(b3).next = intersection;

    Assertions.assertEquals(intersection, Main.findIntersectionV2(a3, b3));
  }

  @Test
  void findIntersectionV3() {
    Assertions.assertNull(Main.findIntersectionV3(null, null));
    Assertions.assertNull(Main.findIntersectionV3(null, new Node(1)));
    Assertions.assertNull(Main.findIntersectionV3(new Node(1), null));
    Assertions.assertNull(Main.findIntersectionV3(build(1, 2, 3), build(1, 2, 3)));
    Assertions.assertNull(Main.findIntersectionV3(build(1,1,1), build(1,1,1)));
    Assertions.assertNull(Main.findIntersectionV3(build(1,1,1), build(3,4,5,6,7)));

    Node intersection = getIntersection(3);

    Assertions.assertEquals(intersection, Main.findIntersectionV3(intersection, intersection), "Passing the same linked list will return the first node");

    Node a1 = build(1,2);
    getLast(a1).next = intersection;

    Node b1 = build(1,2);
    getLast(b1).next = intersection;

    Assertions.assertEquals(intersection, Main.findIntersectionV3(a1, b1));

    Node intersectionWithNoNodeAfter = getIntersection(0);

    Node a2 = build(1,2,3,4,4);
    getLast(a2).next = intersectionWithNoNodeAfter;

    Node b2 = build(1,2,3,4,5);
    getLast(b2).next = intersectionWithNoNodeAfter;

    Assertions.assertEquals(intersectionWithNoNodeAfter, Main.findIntersectionV3(a2, b2));

    Node a3 = build(3,4,4);
    getLast(a3).next = intersection;

    Node b3 = build(1,2,3,4,5);
    getLast(b3).next = intersection;

    Assertions.assertEquals(intersection, Main.findIntersectionV3(a3, b3));
  }

  private Node getIntersection(int nodesAfter) {
    Node intersection = new Node(99);

    Node current = intersection;
    for (int i = 0; i < nodesAfter; i++) {
      Node next = new Node(99 + i + 1);
      current.next = next;
      current = next;
    }

    return intersection;
  }

  public static Node build(Integer... values) {
    Node prev = null;
    Node head = null;

    for (Integer value : values) {
      Node n = new Node(value);

      if (prev == null) {
        head = n;
      } else {
        prev.next = n;
      }

      prev = n;
    }

    return head;
  }

  private Node getLast(Node n) {
    Node current = n;

    while (current.next != null) {
      current = current.next;
    }

    return current;
  }
}
