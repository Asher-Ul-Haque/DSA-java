package Data_Structures.Tests;

import Data_Structures.Stacks.Exceptions;
import Data_Structures.Stacks.LinkedListStack;
import java.util.Scanner;

public class LinkedListStackTest {
    public static void main(String[] args) throws Exceptions {
        System.out.println("Testing begins");
        LinkedListStack Stack1 = new LinkedListStack<Integer[]>();
        Scanner Keyboard = new Scanner(System.in);
        Integer[] a = {123, 12, 45, 01, -2};
        Integer[] b = {123, 65, -34, -34,1};
        Integer[][]c = {a, b};
        Stack1.push(a);
        Stack1.push(b);
        Stack1.printStack();
        Stack1.push(0.3);
        Stack1.push("124ASher");
        Stack1.printStack();


    }
}
