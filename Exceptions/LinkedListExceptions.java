package Exceptions;

public class LinkedListExceptions extends Exception{
    public LinkedListExceptions(String message){ super(message);}
    public LinkedListExceptions(){}
    public void reachedEndOfList() throws LinkedListExceptions {
        throw new LinkedListExceptions("Index is out of bounds for the linked List.\nUse insertBottom instead or give a valid index");
    }
    public void emptyList() throws LinkedListExceptions{
        throw new LinkedListExceptions("Cannot delete from an empty list");
    }
    public void listSmall() throws LinkedListExceptions{
        throw new LinkedListExceptions("Cannot delete more times than the size of the list");
    }
    public void nodeDoesntExist() throws LinkedListExceptions{
        throw new LinkedListExceptions("The node does not exist");
    }
    public void unsupportedForCircularLinkedList(String operation) throws LinkedListExceptions{
        throw new LinkedListExceptions("The operation " + operation + " is unsupported for Circular Linked List. \nUse simple insert and delete or use a normal Linked List or Doubly Linked List instead");
    }



}
