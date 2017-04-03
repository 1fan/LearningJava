public class linkedlist{
    Node Head;
    Node CurrentNode;
    int size;

    public linkedlist(){
        Head = CurrentNode = new Node(null);
        size = 0;
    }

    public void index(int index) throws Exception{
        if(index<0 || index > size-1){
            System.out.println("Invalid Index");
            throw new Exception();
        }
        CurrentNode = Head.next;
        int j = 0;
        while(CurrentNode != null && j<index){
            CurrentNode = CurrentNode.next;
        }
    }

    public void delete(int index) throws Exception{
        if(index<0 || index > size-1){
            System.out.println("Invalid Index");
            throw new Exception();
        }
        index(index-1);
        CurrentNode.setNext(CurrentNode.next.next);
    }

//    public int getIndex(int index) throws Exception{
//        if(index<0 || index > size-1){
//            System.out.println("Invalid Index");
//            throw new Exception();
//        }
//        return 0;
//    }
}