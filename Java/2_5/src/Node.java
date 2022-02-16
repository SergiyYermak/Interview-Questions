public class Node {
    /*
    You have two numbers represented by a linked list, where each node contains a single digit.
    The digits are stored in reverse order, such that the 1's digit is at the head of the list.
    Write a function that adds the two numbers and returns the sum as a linked list.
    EXAMPLE:
    input: (7->1->6) + (5->9->2). That is 617+295 = 912
    output: (2->1->9) which is 912.
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
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println();
    }
    /*
    Notes before viewing solution:
    Do the two numbers equal each other in size? i.e. the both have the same amount of nodes? NO
    Do the data in the nodes always less than 10? YES
    Reverse order makes more sense because that's how we add numbers.
    If addition is >= 10, minus 10 from sum, and add 1 to data of the next NOT NULL node
     */
    Node sumListsReverse(Node head2)
    {
        Node n1 = this;
        Node n2 = head2;
        Node solHead = null;
        while(n1!=null || n2!=null)//go till both empty
        {
            if(n1!=null)//n1 still has numbers
            {
                if(n2!=null)//n1 and n2 still have numbers
                {
                    int x = n1.data + n2.data;
                    if(x < 10)//addition of numbers is less than ten
                    {
                        if(solHead == null)//adding the first two numbers
                        {
                            solHead = new Node(x);
                            n1 = n1.next;
                            n2 = n2.next;
                        }
                        else //not the first addition
                        {
                            solHead.appendToTail(x);
                            n1 = n1.next;
                            n2 = n2.next;
                        }
                    }
                    else
                    {
                        if(solHead == null)
                        {
                            solHead = new Node(x-10);
                            if(n1.next != null)
                            {
                                n1.next.data++;
                            }
                            else
                            {
                                n1.appendToTail(1);
                            }
                            n1 = n1.next;
                            n2 = n2.next;
                        }
                        else
                        {
                            solHead.appendToTail(x-10);
                            if(n1.next != null)
                            {
                                n1.next.data++;
                            }
                            else
                            {
                                n1.appendToTail(1);
                            }
                            n1 = n1.next;
                            n2 = n2.next;
                        }
                    }
                }
                else
                {
                    if(solHead == null)
                    {
                        solHead = new Node(n1.data);
                        n1 = n1.next;
                    }
                    else
                    {
                        if(n1.data < 10) //check that the value in n1 is less than ten
                        {
                            solHead.appendToTail(n1.data);
                            n1 = n1.next;
                        }
                        else //value in n1 is greater than 10
                        {
                            solHead.appendToTail(n1.data - 10);
                            if(n1.next != null)
                            {
                                n1.next.data++;
                            }
                            else
                            {
                                n1.appendToTail(1);
                            }
                            n1 = n1.next;
                        }
                    }
                }

            }
            else //n1 == null
            {
                if(n2 != null)
                {
                    if(solHead == null)
                    {
                        solHead = new Node(n2.data);
                        n2 = n2.next;
                    }
                    else
                    {
                        if(n2.data < 10) //check that the value in n2 is less than ten
                        {
                            solHead.appendToTail(n2.data);
                            n2 = n2.next;
                        }
                        else //value in n2 is greater than 10
                        {
                            solHead.appendToTail(n2.data - 10);
                            if(n2.next != null)
                            {
                                n2.next.data++;
                            }
                            else
                            {
                                n2.appendToTail(1);
                            }
                            n2 = n2.next;
                        }
                    }
                }
            }
        }
        return solHead;
    }
    Node sumListsForward(Node head2)
    {
        return this;
    }
    /*
    Notes after viewing solution:
     */

    public static void main(String[] args)
    {
        Node head1 = new Node(2);
        head1.appendToTail(3);


        Node head2 = new Node(8);
        head2.appendToTail(6);
        head2.appendToTail(9);

        head1.printList();
        head2.printList();

        Node solution = head1.sumListsReverse(head2);
        solution.printList();
    }
}