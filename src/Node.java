/**
 * Created by hasee on 2017/4/2.
 */
public class Node{
    int data;
    Node next;

    public Node(Node Head){
        next = Head;
    }

    public Node(int obj,Node Next){
        data = obj;
        next = Next;
    }

    public Node getNext(){
        return this.next;
    }

    public int getValue(){
        return this.data;
    }

    public void setNext(Node Next){
        this.next = Next;
    }

    public void setData(int value){
        this.data = value;
    }

}
