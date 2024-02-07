package Data_Structures.Linked_Lists;

import Exceptions.LinkedListExceptions;

import java.util.Iterator;

public class CircularLinkedList<Item> extends LinkedList{
    public CircularLinkedList(){
        super();
        last.next = first;
    }
    public void insertBottom(Object nextItem) throws LinkedListExceptions {
        handler.unsupportedForCircularLinkedList("insertBottom()");
    }
    public void insertTop(Object nextItem) throws LinkedListExceptions{
        handler.unsupportedForCircularLinkedList("insertTop()");
    }
    public void insert(Node nextNode, int index) throws LinkedListExceptions{
        handler.unsupportedForCircularLinkedList("insert() with index");
    }
    public void insert(Object item, int index) throws LinkedListExceptions{
        handler.unsupportedForCircularLinkedList("insert() with index");
    }
    public void deleteTop() throws LinkedListExceptions{
        handler.unsupportedForCircularLinkedList("deleteTop()");
    }
    public void deleteTop(int index) throws LinkedListExceptions{
        handler.unsupportedForCircularLinkedList("deleteTop() with count");
    }
    public void deleteAt(int index) throws LinkedListExceptions{
        handler.unsupportedForCircularLinkedList("deleteAt()");
    }
    public void deleteBottom() throws LinkedListExceptions{
        handler.unsupportedForCircularLinkedList("deleteBottom()");
    }
    public void deleteBottom(int count) throws LinkedListExceptions{
        handler.unsupportedForCircularLinkedList("deleteBottom()");
    }
    public void insert(Node nextNode){
        Node oldFirst = first;
        first = nextNode;
        if (size != 0){
            first.next = oldFirst;
        }
        size+=1;
    }
    public void insert(Item nextNode){
        Node newNode = new Node(nextNode);
        insert(newNode);
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
        returnString = returnString +"]\n";
        returnString = returnString + "^";
        for (int i = 0; i < getSize(); i++){
            returnString = returnString + "---";
        }
        returnString = returnString + "|";
        return returnString;
    }



}
