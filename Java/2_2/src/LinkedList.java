/*
Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 */
//https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/
public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static LinkedList insert(LinkedList list, int data) {
        Node new_node = new Node(data);
        new_node.next = null;

        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    public static LinkedList removeByKey(LinkedList list, int key) {
        Node currNode = list.head;
        Node prev = list.head;

        //Key found in head node
        if (currNode != null && currNode.data == key) {
            list.head = currNode.next;
            System.out.println(key + " found and deleted");
            return list;
        }
        //Look for key in the rest of the list
        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
        }
        //Key found
        if (currNode != null) {
            prev.next = currNode.next;
            System.out.println(key + " found and deleted");
            return list;
        } else //key not found
        {
            System.out.println(key + " not found");
        }
        return list;
    }

    public static void printList(LinkedList list) {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    //is the size known? (to easy length-k then iterate to it)
    //is this a doubly liked list? no
    //count to it means iterating twice N^2 worst case and N the best
    //recursion? base case if(element.next != null) -> return 0
    //we would go through all element on the way back, so print when kth found?
    public static int returnKthToLast(Node element, int k)
    {
        if(element.next == null)
            return 0;
        int count = returnKthToLast(element.next ,k) + 1;
        //System.out.println("Debug: " + count);
        if(count == k)
        {
            System.out.println(element.data);
        }
        return count;
    }
    /*
    This might be a worst solution than counting. Because we get to the end of the list, then walk all the way back.
    Regardless of what k is we will walk all the way back. Furthermore, all the calls to the returnKthToLast are
    put on the execution stack. While counting only puts one call.
     */
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();

        list = insert(list, 1);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 3);
        list = insert(list, 7);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 1);
        list = insert(list, 8);

        printList(list);
        returnKthToLast(list.head, 3); // expected output 4;
    }
}