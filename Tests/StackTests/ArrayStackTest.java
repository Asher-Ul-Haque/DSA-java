package Tests.StackTests;

import Data_Structures.Stacks.ArrayStack;
import Data_Structures.Stacks.LinkedListStack;
import Exceptions.StackQueueExceptions;

public class ArrayStackTest {
    public static void main(String[] args) throws StackQueueExceptions {
        ArrayStack stack1 = new ArrayStack();
        LinkedListStack stack2 = new LinkedListStack();
        stack1.push(34);
        stack1.push("String");
        stack1.push(true);
        stack1.allowAny(false);
        stack1.push(false);
        System.out.println(stack1.toString());

    }
}
