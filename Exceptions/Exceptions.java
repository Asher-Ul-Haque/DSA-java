package Exceptions;

public class Exceptions extends Exception{
    public Exceptions(String message){
        super(message);
    }

    public Exceptions(){
    }

    public void popFromEmptyStack() throws Exceptions {
        throw new Exceptions("Attempted to pop from empty stack. Push something to be able to pop");
    }

    public void dequeueFromEmptyQueue() throws Exceptions {
        throw new Exceptions("Attempted to dequeue from empty queue. Enqueue something to be able to dequeue");
    }

    public void dequeueMultipleFromEmptyQueue() throws Exceptions {
        throw new Exceptions("Attempted to dequeue from empty queue. Enqueue something to be able to dequeue");
    }

    public void popMultipleFromEmptyStack() throws Exceptions {
        throw new Exceptions("Attempted to pop from empty stack. Push something to be able to pop");
    }

    public void pushBadDataType(Class Correction) throws Exceptions {
        throw new Exceptions("Attempted to push wrong type of data, use dataype: " + Correction);
    }
}
