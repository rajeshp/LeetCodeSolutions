/**
 * Created with IntelliJ IDEA.
 * User: TE162141
 * Date: 10/22/12
 * Time: 5:21 PM
 * To change this template use File | Settings | File Templates.
 *
 *
 *  You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 *
 *
 *
 */

class Node
{
    int val;
    Node next;
}

class LinkedList
{
    Node head;
    Node tail;

    void add(Node n)
    {
        if(head==null && tail==null)
        {
            head=n;
            tail=n;
        }
        else
            tail.next=n;

    }

    void reverse()
    {
        if(head!=null)
        {
           Node prev=head,current=head,next=head;

            while(current.next!=null)
            {
                next  = next.next;
                current = next;

                next=current.next;

                current.next=prev;

                prev=current;

            }


        }



    }

}


public class AddTwoNumbers {


    public static void main(String[] args)
    {
        int n1 = Integer.parseInt(args[0]);

        LinkedList list1 = MakeNumberAsLinkedList(n1);

        int n2 = Integer.parseInt(args[1]);
        LinkedList list2 = MakeNumberAsLinkedList(n2);


    }

  static LinkedList  MakeNumberAsLinkedList(int n)
    {
        LinkedList list = new LinkedList();

        while(n>0)
        {
            Node digit = new Node();
            digit.val = n%10;
            n=n/10;
            list.add(digit);
        }

       return list;
    }

}
