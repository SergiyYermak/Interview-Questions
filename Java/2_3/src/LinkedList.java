//https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/
class Node
{
    int data;
    Node next = null;

    public Node(int d)
    {
        data = d;
    }

    void appendToTail(Node end)
    {
        Node n = this;
        while(n.next != null)
        {
            n = n.next;
        }
        n.next = end;
    }
    void printList()
    {
        Node n = this;
        while(n != null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
    /*
    Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but the first and last
    node, not necessarily the exact middle) of a singly linked list, "given only access to that node".
    */
    //I would need access to the target node. I cant just make it in main because it would not be the .next of something
    //and it wouldn't have a .next.
    //problem is if head node does get passed, there is no way to check.
    boolean deleteMiddleNode(Node target)
    {
        if(target.next == null)
            return false; //check if tail
        else
        { //override it with the next node
            target.data = target.next.data;
            target.next = target.next.next;
            return true;
        }
    }
    public static void main(String[]args)
    {
        Node head = new Node(1);
        Node newNode2 = new Node(2);
        head.appendToTail(newNode2);
        Node newNode3 = new Node(3);
        head.appendToTail(newNode3);

        head.printList();
        System.out.println(head.deleteMiddleNode(newNode3)); // expect to fail
        head.printList();
        System.out.println(head.deleteMiddleNode(newNode2)); // expect to pass
        head.printList();
    }
}