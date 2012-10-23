package com.rao.ds;

/**
 * Created with IntelliJ IDEA.
 * User: TE162141
 * Date: 10/23/12
 * Time: 2:13 AM
 * To change this template use File | Settings | File Templates.
 */

class BinaryNode<T>
{
    BinaryNode left;
    T val;
    BinaryNode right;

}

public class Tree<T> {

    BinaryNode root;

    public Tree()
    {
       root = new BinaryNode();

    }

    public Tree(T nodeData)
    {
        BinaryNode<T> temp = new BinaryNode<T>();
        temp.val= nodeData;
        root = temp;
    }


    public void add(BinaryNode node)
    {


    }

}
