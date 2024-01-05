//PACKAGES AND IMPORTS---
package Stacks;
import java.util.Iterator;
import java.util.Scanner;
//--------------------------------------------------------------------------------

public class LinkedListStack{
    //Important prerequisites
    private Integer size = 0;
    private Node first = null;
    private final Exceptions handler = new Exceptions();
    //--------------------------------------------------------------------------------

    //Private classes
    private final class StackIterator implements Iterator<Comparable>{
        private Node current = first;

        public boolean hasNext(){
            return current != null;
        }

        public Comparable next(){
            Comparable item = (Comparable) current.item;
            current = current.next;
            return item;
        }
    }
    private final class Node<Comparable>{
        Comparable item;
        Node next;
    }
    //--------------------------------------------------------------------------------

    //Methods to check Size-
    public boolean isEmpty(){
        return first==null;
    }
    public Integer getSize(){
        return size;
    }
    //--------------------------------------------------------------------------------

    //Push methods-
    public void push(Comparable item){
        Node previous = first;
        first = new Node();
        first.item = item;
        first.next = previous;
        size++;
    }
    public void push(Comparable[] items){
        for (int i = 0; i < items.length; i++){
            push(items[i]);
        }
    }
    public void push(){
        Scanner KeyboardInput = new Scanner(System.in);
        push(KeyboardInput.next());
    }
    //--------------------------------------------------------------------------------

    //Pop methods-
    public Comparable pop() throws Exceptions {
        if (getSize()==0){
            handler.popFromEmptyStack();
        }
        Comparable item = (Comparable) first.item;
        first = first.next;
        size--;
        return item;
    }
    public LinkedListStack popStack(int count) throws Exceptions{
        if (count > size){
            handler.popMultipleFromEmptyStack();
        }
        LinkedListStack returnItems = new LinkedListStack();
        for (int i = 0; i < count; i++){
               returnItems.push(pop());
        }
        return returnItems;
    }
    public Comparable[] popArray(int count) throws Exceptions{
        if (count > size){
            handler.popMultipleFromEmptyStack();
        }
        Comparable[] returnItems = new Comparable[count];
        for (int i = 0; i < count; i++){
            returnItems[i] = pop();
        }
        return returnItems;
    }
    //--------------------------------------------------------------------------------

    //Iterate and print methods
    public Iterator<Comparable> iterator(){
        return new StackIterator();
    }
    public void printStack(){
        Iterator iteration = iterator();
        if (iteration.hasNext()){
            System.out.print(iteration.next());
        }
        while(iteration.hasNext()){
            System.out.print(", ");
            System.out.print(iteration.next());
        }
    }
    public void prettyPrintStack(){
        Iterator iteration = iterator();

        for (int i = 0; i < this.getSize()-1; i++){
            System.out.print("=");
        }
        System.out.println("=");

        if (iteration.hasNext()){
            System.out.print(iteration.next());
            System.out.print(" |");
        }

        while(iteration.hasNext()){
            System.out.print(" | ");
            System.out.print(iteration.next());
        }

        for (int i = 0; i < this.getSize()-1; i++){
            System.out.print("=");
        }
        System.out.println("=");
    }
    //--------------------------------------------------------------------------------

}
