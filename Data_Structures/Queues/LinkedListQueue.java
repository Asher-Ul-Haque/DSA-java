package Data_Structures.Queues;

import Exceptions.Exceptions;

public class LinkedListQueue<Item>{
    //Important prerequisites
    private Long size = 0L;
    private Node first, last;
    private boolean allowAny = true;
    private final Exceptions handler = new Exceptions();
    //--------------------------------------------------------------------------------

    //Nodes
    private final class Node<Item>{
        Item item;
        Node next;
    }
    //--------------------------------------------------------------------------------

    //Methods to check Size-
    public boolean isEmpty(){
        return first==null;
    }
    public Long getSize(){
        return size;
    }
    //--------------------------------------------------------------------------------

    //Enqueue
    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        }
        else{
            oldLast.next = last;
        }
    }
    public void enqueue(Item[] items){
        for(Item item: items){
            enqueue(item);
        }
    }
    public void enqueue(LinkedListQueue items){
        while(!items.isEmpty()){
            enqueue((Item) items.dequeue());
        }
    }
    //--------------------------------------------------------------------------------

    //Dequeue
    public Item dequeue(){
        Item item = (Item) first.item;
        first = first.next;
        if (isEmpty()){
            last = null;
        }
        return item;
    }
    //--------------------------------------------------------------------------------



}
