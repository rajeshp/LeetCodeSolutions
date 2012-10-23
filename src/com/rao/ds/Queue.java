package com.rao.ds;

/**
 * Created with IntelliJ IDEA.
 * User: TE162141
 * Date: 10/23/12
 * Time: 4:53 PM
 * To change this template use File | Settings | File Templates.
 */

class QueueNode<T>
{
    T data;
    QueueNode next;

}

public class Queue<T> {

    QueueNode<T> start;
    public Queue(T t)
    {
        if(start==null)
        {
            start = new QueueNode<T>();
            start.data=t;
        }
    }


    public void enQueue(T t)
    {
        while(start.next!=null)
        {
            start=start.next;
        }

        start=new QueueNode();
        start.data=t;
    }


    public T deQueue()
    {
        QueueNode<T> temp = null;
        if(start!=null)
        {
                temp = start;
            start = start.next;

        }

        return temp.data;
    }



    public boolean isEmpty()
    {
        if(start==null) return true;
        else
            return false;
    }


}
