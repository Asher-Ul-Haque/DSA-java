package Data_Structures.Linked_Lists;
import Exceptions.LinkedListExceptions;
import java.util.Iterator;

public class DoublyLinkedList<Item>{
    //Important Preqrequisites-
    private final class Node<Item>{
        Item item;
        Node next;
        Node previous;
        public Node(Item data, Node next, Node previous){
            this.item = data;
            this.next = next;
            this.previous = previous;
        }
        public Node(Item data){
            this.item = data;
            this.next = null;
            this.previous = null;
        }
    }
    private Node first;
    private LinkedListExceptions handler;
    private Node last;
    private int size = 0;
    private boolean allowAny = true;
    public DoublyLinkedList(){
        first.previous = null;
        last.next = null;
    }
    //-------------------------------------------------------

    //Important Helper functions
    private boolean equals(Node node1, Node node2){ return (node1.item == node2.item) && (node1.next == node2.next) && (node1.previous == node2.previous);}
    private boolean canInsert(Item insertItem){
        return((first.item.getClass() == insertItem.getClass()) || allowAny);
    }
    private void loopToCurrent(int index) throws LinkedListExceptions {
        Node current = first;
        for(int i = 0; i < size; i++){
            current=current.next;
        }
    }
    /*public Item get(int index) throws LinkedListExceptions {
        loopToCurrent(index);
        re
    }*/
    //--------------------------------------------------------

    //Insert
    public void insertBottom(Item nextItem){
        Node newNode = new Node(nextItem);
        insertBottom(newNode);
    }
    public void insertBottom(Node newNode){
        last.next = newNode;
        newNode.previous = last;
        last= newNode;
        size++;
    }
    public void insertBottom(Item[] items){
        for (Item a: items){
            insertBottom(a);
        }
    }
    public void insertBottom(Node[] nodes){
        for (Node a: nodes){
            insertBottom(a);
        }
    }
    public void insertTop(Node newNode){
        first.previous = newNode;
        newNode.next = first;
        first = newNode;
        newNode.previous = null;
        size++;
    }
    public void insertTop(Item item){
        Node newNode = new Node(item);
        insertTop(newNode);
    }
    public void insertTop(Item[] items){
        for (Item a: items){
            insertTop(a);
        }
    }
    public void insertTop(Node[] nodes){
        for (Node a: nodes){
            insertTop(a);
        }
    }
    private void insertAt(Node nextNode, Node current){
        if (canInsert((Item) nextNode.item)){
            Node oldNext = current.next;
            current.next = nextNode;
            nextNode.next = oldNext;
            size+=1;
        }

    }
    public void insert(Node nextNode, int index) throws LinkedListExceptions {
        Node current = first;
        if (size < index){
            handler.reachedEndOfList();
        }
        loopToCurrent(index);
        if(current == last){
            insertBottom(nextNode);
        }
        else {
            insertAt(nextNode, current);
        }

    }
    public void insert(Item item, int index) throws LinkedListExceptions {
        Node newNode = new Node(item);
        insert(newNode, index);
    }
    public void insert(Node[] nextNodes, int index) throws LinkedListExceptions {
        Node current = first;
        if (size < index){
            handler.reachedEndOfList();
        }
        loopToCurrent(index);
        for (Node a: nextNodes){
            insertAt(a, current);
            current = a;
        }
    }
    public void insert(Item[] nextItems, int index) throws LinkedListExceptions {
        Node nextNode;
        Node[] nextNodes= new Node[nextItems.length];
        for (Item a : nextItems){
            nextNode = new Node(a);
        }
        insert(nextNodes, index);
    }
    //------------------------------------------------------------------------------

    //Delete
    public void deleteTop() throws LinkedListExceptions {
        if (size == 0){
            handler.emptyList();
        }
        first = first.next;
        size--;
    }
    public void deleteTop(int count) throws LinkedListExceptions {
        for (int i = 0; i < count; i++){
            deleteTop();
        }
    }
    public void deleteBottom() throws LinkedListExceptions {
        if (size == 0)
        {
            handler.emptyList();
        }
        if (size ==1)
        {
            deleteTop();
            return;
        }
        last = last.previous;
        last.next = null;
        size--;
        return;
    }
    public void deleteBottom(int count) throws LinkedListExceptions {
        if (count > size)
        {
            handler.listSmall();
        }
        for (int i = 0; i < count; i++)
        {
            deleteBottom();
        }
        return;
    }
    public void deleteNode(Node toDelete) throws LinkedListExceptions {
        if(size == 0){
            handler.emptyList();
        }
        Node current = first;
        Node previous = first;
        while (!equals(current, toDelete)){
            previous = current;
            current = current.next;
            if (current == last){
                handler.nodeDoesntExist();
                break;
            }
        }
        previous.next = current.next;
        size--;

    }
    public void deleteAt(int index) throws LinkedListExceptions {
        if (size == 0){
            handler.emptyList();
        }
        if (size > index){
            handler.listSmall();
        }
        if (size/2 > index)
        {
            Node current = first;
            for(int i = size/2; i < index - 1; i++){
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
        else{
            Node current = last;
            for(int i = index-1; i <= size/2; i--){
                current = current.previous;
            }
            current.previous = current.previous.previous;
            size--;
        }

    }
    //-----------------------------------------------------------------

    //Iterate and print-
    private final class Iterations implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext(){
            return current != last;
        }

        public Item next(){
            Item item = (Item) current.item;
            current = current.next;
            return item;
        }
    }
    public Iterator<Item> iterator(){
        return new Iterations();    }
    public void printLinkedList(){
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
            returnString = returnString + "<->" + String.valueOf(iteration.next());
        }
        returnString = returnString +"]";
        return returnString;
    }
    //---------------------------------------------------------------------------
}
