import javax.swing.*;
import java.net.SocketOption;
import java.sql.SQLOutput;

public class Node {
    /*
    Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes
    greater than or equal to x. If x is contained within the list, the values of x only need to be after the elements
    less than x (see below). The partition element x can appear anywhere in the "right partition"; it does not need to
    appear between the left and right partitions.
    EXAMPLE
    Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition=5]
    Output 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
    */
    Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }
    Node deleteNode(Node head, int d) {
        Node n = head;

        if(n.data == d) {
            return head.next; /* moved head */
        }
        while (n.next != null) {
            if(n.next.data == d) {
                n.next = n.next.next;
                return head; /* head didn't change */
            }
            n = n.next;
        }
        return head;
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

     */
    Node partition(Node head, int x)
    {
        Node n = head;
        Node newHead = head;

        //first count the size of the list
        int size = 0;
        while(n!=null)
        {
            size++;
            n = n.next;
        }
        //reset
        n = head;
        //counter to make sure we dont go over values we append
        int counter = 0;
        while(counter < size)
        {
            if(n.data >= x) //if larger or equal, place on right side
            {
                n.appendToTail(n.data); //append
                newHead = n.deleteNode(newHead, n.data); //delete the node (if head node update head)
                n = n.next;
                counter++;
            }
            else // if data is smaller than x, leave it
            {
                counter++;
                n = n.next;
            }
        }
        return newHead;
    }
    /*
    Notes after viewing solution: make two lists 'before' and 'after' sort into appropriate list then merge
    I thought of this approach but for some reason very little about.
    It is less expensive than my solution which requires counting first.
     */

    public static void main(String[] args)
    {
        Node head = new Node(7);
        head.appendToTail(6);
        head.appendToTail(5);
        head.appendToTail(4);
        head.appendToTail(3);
        head.appendToTail(2);
        head.appendToTail(1);
        head.printList();

        head = head.partition(head,5); //head will change so return head
        head.printList();
    }
}
