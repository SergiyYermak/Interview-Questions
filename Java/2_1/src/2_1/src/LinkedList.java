/*
Write code to remove duplicates from an unsorted linked list
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
*/
import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

//https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/
public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    public static LinkedList insert(LinkedList list, int data)
    {
        Node new_node = new Node(data);
        new_node.next = null;

        if(list.head == null)
        {
            list.head = new_node;
        }
        else
        {
            Node last = list.head;
            while (last.next != null)
            {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }
    public static LinkedList removeByKey(LinkedList list, int key)
    {
        Node currNode = list.head;
        Node prev = list.head;

        //Key found in head node
        if(currNode != null && currNode.data == key)
        {
            list.head = currNode.next;
            System.out.println(key + " found and deleted");
            return list;
        }
        //Look for key in the rest of the list
        while (currNode != null && currNode.data != key)
        {
            prev = currNode;
            currNode = currNode.next;
        }
        //Key found
        if(currNode != null)
        {
            prev.next = currNode.next;
            System.out.println(key + " found and deleted");
            return list;
        }
        else //key not found
        {
            System.out.println(key + " not found");
        }
        return list;
    }

    public static void printList(LinkedList list)
    {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        while(currNode != null)
        {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    //sorting would take to much time (running through the list multiple times)
    //boolean hashmap?
    public static LinkedList removeDups(LinkedList list)
    {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        Node currNode = list.head;
        Node prev = list.head;
        while(currNode != null)
        {
            if(hashSet.contains(currNode.data))
            {
                prev.next = currNode.next;
            }
            else
            {
                hashSet.add(currNode.data);
            }
            prev = currNode;
            currNode = currNode.next;
        }
        return list;
    }

    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();

        list = insert(list, 1);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 3);
        list = insert(list, 7);
        list = insert(list, 2);
        list = insert(list, 3); //duplicate
        list = insert(list, 4);
        list = insert(list, 1); //duplicate
        list = insert(list, 8);

        printList(list);
        list = removeDups(list);
        printList(list);

    }
}
