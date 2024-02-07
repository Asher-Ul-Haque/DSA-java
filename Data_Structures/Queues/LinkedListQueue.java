package Data_Structures.Queues;
import Exceptions.StackQueueExceptions;
import java.util.Iterator;

public class LinkedListQueue<Item>{
    //Important prerequisites
    private Long size = 0L;
    private Node first, last;
    private boolean allowAny = true;
    private final StackQueueExceptions handler = new StackQueueExceptions();
    //--------------------------------------------------------------------------------

    //Private classes
    private final class Node<Item>{
        Item item;
        Node next;
    }
    private final class StackIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext(){
            return current != null;
        }

        public Item next(){
            Item item = (Item) current.item;
            current = current.next;
            return item;
        }
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
    private Node getLast(){
        Node returnNode =first;
        for (int i = 0; i < size - 1; i++){
            returnNode = returnNode.next;
        }
        return returnNode;
    }
    private void allowEnqueue(Item item){
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
    public void enqueue(Item item) throws StackQueueExceptions {
        if (allowAny || size == 0){
            allowEnqueue(item);
        }
        else if(size > 0 && item.getClass() == first.item.getClass()){
            allowEnqueue(item);
        }
        else{
            handler.pushBadDataType(first.item.getClass());
        }
    }
    public void enqueue(Item[] items) throws StackQueueExceptions {
        for(Item item: items){
            enqueue(item);
        }
    }
    public void enqueue(LinkedListQueue items) throws StackQueueExceptions {
        while(!items.isEmpty()){
            enqueue((Item) items.dequeue());
        }
    }
    //--------------------------------------------------------------------------------

    //Dequeue
    public Item dequeue() throws StackQueueExceptions {
        if (size == 0){
            handler.dequeueFromEmptyQueue();
        }
        Item item = (Item) first.item;
        first = first.next;
        if (isEmpty()){
            last = null;
        }
        return item;
    }
    public LinkedListQueue dequeue(int count) throws StackQueueExceptions {
        if (count > size){
            handler.dequeueMultipleFromEmptyQueue();
        }
        LinkedListQueue returnQueue = new LinkedListQueue();
        for (int i = 0; i < count; i++){
            returnQueue.enqueue(dequeue());
        }
        return returnQueue;
    }
    //--------------------------------------------------------------------------------

    //Iteration and printing
    public Iterator<Item> iterator(){
        return new StackIterator();
    }
    @Override
    public String toString() {
        Iterator iteration = iterator();
        String returnString ="[";
        if (iteration.hasNext()){
            returnString = returnString + String.valueOf(iteration.next());
        }
        while(iteration.hasNext()){
            returnString = returnString + ", " + String.valueOf(iteration.next());
        }
        returnString = returnString +"]";
        return returnString;
    }
    public void printQueue(){
        System.out.println(this.toString());
    }

    //--------------------------------------------------------------------------------

    //Control Data Types
    public void allowAny(boolean ans){
        allowAny = ans;
    }

    //FIX ALLOW ANY. FIND OUT THE PROBLEMM


}
