package Tests.QueueTests;

import Data_Structures.Queues.LinkedListQueue;
import Exceptions.StackQueueExceptions;

public class LinkedListQueueTest {
    public static void main(String[] args) throws StackQueueExceptions {
        LinkedListQueue stack1 = new LinkedListQueue();
        stack1.enqueue(34);
        stack1.enqueue("String");
        stack1.enqueue(true);
        stack1.allowAny(false);
        stack1.enqueue(34.667);
        System.out.println(stack1.toString());

    }
}