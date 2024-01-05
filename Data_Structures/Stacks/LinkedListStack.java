//PACKAGES AND IMPORTS---
package Data_Structures.Stacks;
import java.util.Iterator;
import java.util.Scanner;
//--------------------------------------------------------------------------------

public class LinkedListStack<Item>{
    //Important prerequisites
    private Long size = 0L;
    private Node first = null;
    private final Exceptions handler = new Exceptions();
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
    public void push(Item item){
        Node previous = first;
        first = new Node();
        first.item = item;
        first.next = previous;
        size++;
    }
    public void push(Item[] items){
        for (int i = 0; i < items.length; i++){
            push(items[i]);
        }
    }
    public void push(){
        Scanner KeyboardInput = new Scanner(System.in);
        push((Item) KeyboardInput.next());
    }
    //--------------------------------------------------------------------------------

    //Pop methods-
    public Item pop() throws Exceptions {
        if (getSize()==0){
            handler.popFromEmptyStack();
        }
        Item item = (Item) first.item;
        first = first.next;
        size--;
        return item;
    }
    public LinkedListStack pop(int count) throws Exceptions{
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

}
