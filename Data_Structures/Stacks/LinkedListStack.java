//PACKAGES AND IMPORTS---
package Data_Structures.Stacks;
import Exceptions.StackQueueExceptions;

import java.util.Iterator;
import java.util.Scanner;
//--------------------------------------------------------------------------------

public class LinkedListStack<Item>{
    //Important prerequisites
    private Long size = 0L;
    private Node first = null;
    private boolean allowAny = true;
    private final StackQueueExceptions handler = new StackQueueExceptions();
    //--------------------------------------------------------------------------------

    //Private classes
    private final class StackIterator implements Iterator<Item>{
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

    //Push methods-
    private Node getLast(){
        Node returnNode =first;
        for (int i = 0; i < size - 1; i++){
            returnNode = returnNode.next;
        }
        return returnNode;
    }
    private void allowPush(Item item){
        Node previous = first;
        first = new Node();
        first.item = item;
        first.next = previous;
        size++;
    }
    public void push(Item item) throws StackQueueExceptions {
        if (allowAny || size == 0){
            allowPush(item);
        }
        else if(size > 0 && item.getClass() == getLast().item.getClass()){
            allowPush(item);
        }
        else{
            handler.pushBadDataType(getLast().item.getClass());
        }
    }
    public void push(Item[] items) throws StackQueueExceptions {
        for (int i = 0; i < items.length; i++){
            push(items[i]);
        }
    }
    public void push() throws StackQueueExceptions {
        Scanner KeyboardInput = new Scanner(System.in);
        push((Item) KeyboardInput.next());
    }
    public void push(LinkedListStack items) throws StackQueueExceptions {
        while(!items.isEmpty()){
            push((Item) items.pop());
        }
    }
    public void push(ArrayStack items) throws StackQueueExceptions {
        for (Object item: items.iterator()) {
            push((Item) item);
        }
    }
    //--------------------------------------------------------------------------------

    //Pop methods-
    public Item pop() throws StackQueueExceptions {
        if (getSize()==0){
            handler.popFromEmptyStack();
        }
        Item item = (Item) first.item;
        first = first.next;
        size--;
        return item;
    }
    public LinkedListStack pop(int count) throws StackQueueExceptions {
        if (count > size){
            handler.popMultipleFromEmptyStack();
        }
        LinkedListStack returnItems = new LinkedListStack();
        for (int i = 0; i < count; i++){
               returnItems.push(pop());
        }
        return returnItems;
    }
    //--------------------------------------------------------------------------------

    //Iterate and print methods
    public Iterator<Item> iterator(){
        return new StackIterator();
    }
    public void printStack(){
        System.out.println(this.toString());
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
    //--------------------------------------------------------------------------------

    //Control data types
    public void allowAny(boolean permission){
        allowAny = permission;
    }

}
