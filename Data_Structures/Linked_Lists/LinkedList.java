package Data_Structures.Linked_Lists;
import Exceptions.LinkedListExceptions;
import java.util.Iterator;
//---------------------------------------------------------------------------
public class LinkedList<Item>{
    //Improtant Prerequisities-
    protected Node first;
    protected Node last;
    protected final LinkedListExceptions handler = new LinkedListExceptions();
    protected int size;
    private boolean allowAny = true;
    public boolean isEmpty(){
        return first==null;
    }
    public int getSize(){
        return size;
    }
    private boolean equals(Node node1, Node node2){ return (node1.item == node2.item) && (node1.next == node2.next);}
    //------------------------------------------------------------------------

    //Node class and Iterator
    protected final class Node<Item>{
        Item item;
        Node next;
        public Node(Item data, Node next){
            this.item = data;
            this.next = next;
        }
        public Node(Item data){
            this.item = data;
            this.next = null;
        }
    }
    private final class Iterations implements Iterator<Item> {
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
    public Iterator<Item> iterator(){
        return new Iterations();    }
    //-----------------------------------------------------------------------

    //Insert-
    private boolean canInsert(Item insertItem){
        return((first.item.getClass() == insertItem.getClass()) || allowAny);
    }
    public void insertBottom(Node nextNode) throws LinkedListExceptions {
        if (canInsert((Item) nextNode.item)){
            last.next = nextNode;
            last = nextNode;
            size+=1;
        }

    }
    public void insertBottom(Item nextItem) throws LinkedListExceptions {
        Node newNode = new Node(nextItem);
        insertBottom(newNode);
    }
    public void insertTop(Node nextNode){
        Node oldFirst = first;
        first = nextNode;
        if (size != 0 && canInsert((Item) nextNode.item)){
            first.next = oldFirst;
        }
        size+=1;
    }
    public void insertTop(Item nextItem) throws LinkedListExceptions {
        Node newNode = new Node(nextItem, first);
        insertTop(newNode);
    }
    public void insert(Node nextNode, int index) throws LinkedListExceptions {
        if (size < index){
            handler.reachedEndOfList();
        }
        Node current = first;
        for(int i = 0; i < size; i++){
            current=current.next;
        }
        if(current == last){
            insertBottom(nextNode);
        }
        else if (canInsert((Item) nextNode.item)){
            Node oldNext = current.next;
            current.next = nextNode;
            nextNode.next = oldNext;
            size+=1;
        }
    }
    public void insert(Item nextItem, int index) throws LinkedListExceptions {
        Node newNode = new Node(nextItem);
    }
    //-----------------------------------------------------------------------

    //Delete-
    public void deleteTop() throws LinkedListExceptions {
        if (size == 0){
            handler.emptyList();
        }
        first = first.next;
        size--;
    }
    public void deleteTop(int count) throws LinkedListExceptions {
        if (count > size){
            handler.listSmall();
        }
        for (int i = 0; i < count; i++){
            deleteTop();
        }

    }
    public void deleteAt(int index) throws LinkedListExceptions {
        if (size == 0){
            handler.emptyList();
        }
        if (size > index){
            handler.listSmall();
        }
        Node current = first;
        for(int i = 0; i < index - 1; i++){
            current = current.next;
        }
        current.next = current.next.next;
        size--;
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
    public void deleteBottom() throws LinkedListExceptions {
        deleteBottom(0);
    }
    public void deleteBottom(int count) throws LinkedListExceptions {
        if (size == 0){
            handler.emptyList();
        }
        if (count > size){
            handler.listSmall();
        }
        Node current = first;
        while (current.next != last){
            current = current.next;
        }
        for (int i = 0; i < count; i++){
            current.next = null;
            last = current.next;
            size--;
        }

    }
    //----------------------------------------------------------------------

    //Iterate and print methods
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
            returnString = returnString + "-> " + String.valueOf(iteration.next());
        }
        returnString = returnString +"]";
        return returnString;
    }
    //----------------------------------------------------------------------

    //Control data types
    public void allowAny(boolean permission){
        allowAny = permission;
    }

}
