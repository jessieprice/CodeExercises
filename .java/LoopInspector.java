import java.util.ArrayList;

public class LoopInspector {

  /**
  * purpose: a linked list that has a head, and each node in the list
  *          has a next node returned by node.getNext(). there is a loop
  *          within the list, where the tail's next points to a different node
  *          anywhere within the 0th to second to last node. Find the number
  *          of nodes in that loop.
  *
  * @param node: head of the linked list
  * @return number nodes in the loop
  */
  public int loopSize(Node node) {

    Node curr = find_beginning(node);
    Node original = curr;

    int count = 1;
    while (curr.getNext() != original) {
      count++;
      curr = curr.getNext();
    }
    return count;
  }

  /**
  * purpose: helper method to traverse linked list, finding where tail meets
  *          a node that has already been visited (therefore, beginning of
  *          the loop)
  *
  * @param node: head of the linked list
  * @return node that begins the loop, pointed to by the tail of the list
  */
  public Node find_beginning(Node node) {
    ArrayList<Node> visited = new ArrayList<>();
    visited.add(node);

    while (!(visited.contains(node.getNext()))) {
      visited.add(node.getNext());
      node = node.getNext();
    }

    return node.getNext();
  }
}
