package Linkedlist;

import java.util.Arrays;

/**
 * Created by hasee on 2017/4/2.
 */
public class Node{
    int data;
    Node next;

    public Node(Node Head){
        this.next = Head;
    }

    public Node(int obj, Node Next){
        this.data = obj;
        this.next = Next;
    }

    public Node getNext(){
        return this.next;
    }

    public int getValue(){
        return this.data;
    }

    public void setNext(Node Next) throws Exception{
        this.next = Next;
    }

    public void setData(int value){
        this.data = value;
    }

}
