package Exceptions;

public class StackQueueExceptions extends Exception{
    public StackQueueExceptions(String message){
        super(message);
    }

    public StackQueueExceptions(){
    }

    public void popFromEmptyStack() throws StackQueueExceptions {
        throw new StackQueueExceptions("Attempted to pop from empty stack. Push something to be able to pop");
    }

    public void dequeueFromEmptyQueue() throws StackQueueExceptions {
        throw new StackQueueExceptions("Attempted to dequeue from empty queue. Enqueue something to be able to dequeue");
    }

    public void dequeueMultipleFromEmptyQueue() throws StackQueueExceptions {
        throw new StackQueueExceptions("Attempted to dequeue multiple items from empty queue. Enqueue something to be able to dequeue");
    }

    public void popMultipleFromEmptyStack() throws StackQueueExceptions {
        throw new StackQueueExceptions("Attempted to pop from empty stack. Push something to be able to pop");
    }

    public void pushBadDataType(Class Correction) throws StackQueueExceptions {
        throw new StackQueueExceptions("Attempted to push wrong type of data, use dataype: " + Correction);
    }

    public void insertAtNonExistentIndex(int index) throws StackQueueExceptions {
        throw new StackQueueExceptions("Attempted to insert item at a non-existent index: " + index + "Insert at a proper index or use insertForce instead.");
    }
}
