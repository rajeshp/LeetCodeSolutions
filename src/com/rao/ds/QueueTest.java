package com.rao.ds;

/**
 * Created with IntelliJ IDEA.
 * User: TE162141
 * Date: 10/23/12
 * Time: 5:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class QueueTest {


    public static void main(String[] args)
    {

        Queue<Integer> queue = new Queue<Integer>(5);

        queue.enQueue(6);
        queue.enQueue(10);


        int  q ;

        while(!queue.isEmpty())
        {
            int n = queue.deQueue();
            System.out.println(n+"-->");
        }



    }


}
