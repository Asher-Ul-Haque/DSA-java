package Tests.StackTests;

import Data_Structures.Stacks.ArrayStack;
import Exceptions.Exceptions;

public class ArrayStackTest {
    public static void main(String[] args) throws Exceptions {
        ArrayStack stack1 = new ArrayStack();
        stack1.push(34);
        stack1.push("String");
        stack1.push(true);
        stack1.allowAny(false);
        System.out.println(stack1.toString());

    }
}
