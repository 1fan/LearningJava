package Linkedlist;

public class linkedlist{
    Node Head;
    Node CurrentNode;
    int size;

    public linkedlist(){
//        this.Head = this.CurrentNode = new Node(null);
        this.Head = CurrentNode = new Node(null);
        this.size = 0;
    }

    public void index(int index) throws Exception{
        if(index<-1 || index > size-1){
            throw new Exception("Invalid Index");
        }
        if(index == -1){
            return;
        }
        CurrentNode = Head.next;
        int j = 0;
        while(CurrentNode != null && j<index){
            CurrentNode = CurrentNode.next;
            j++;
        }
    }

    public void delete(int index) throws Exception{
        if(index<0 || index > size){
            System.out.println("Invalid Index");
            throw new Exception();
        }
        index(index-1);
        CurrentNode.setNext(CurrentNode.next.next);
        size--;
    }

    public int getData(int index) throws Exception{
        if(index<-1 || index > size-1){
            System.out.println("Invalid Index");
            throw new Exception();
        }
        return CurrentNode.getValue();
    }

    public void insert(int index, int data) throws Exception{
        if(index<0 || index > size){
            System.out.println("Invalid Index");
            throw new Exception();
        }
        index(index-1);
        CurrentNode.setNext(new Node(data,CurrentNode.next));
        size++;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int Size(){
        return this.size;
    }

    public static void main(String [] args) throws Exception{
        linkedlist l = new linkedlist();
        l.insert(0,0);
        l.insert(1,1);
        l.insert(2,2);
    }
}