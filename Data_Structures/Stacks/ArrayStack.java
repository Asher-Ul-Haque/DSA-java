package Data_Structures.Stacks;

import Exceptions.StackQueueExceptions;

import java.util.Scanner;

public class ArrayStack{
    //Important Prerequisites
    private Object[] array = new Object[1];
    private int N = 0;
    private boolean allowAny = true;
    private final StackQueueExceptions handler = new StackQueueExceptions();
    private final Scanner Keyboard = new Scanner(System.in);
    //--------------------------------------------------------------------------------

    //Iterator
    public Object[] iterator(){
        return array;
    }
    //--------------------------------------------------------------------------------

    //Resize
    private void resize(int capacity){
        Object[] copy = new Object[capacity];
        for (int i = 0; i < N; i++){
            copy[i] = array[i];
        }
        array = copy;
    }
    //--------------------------------------------------------------------------------

    //Pop
    public Object pop() throws StackQueueExceptions {
        if (N < array.length/4){
            resize(array.length/2);
        }
        if (N ==0){
            handler.popFromEmptyStack();
        }
        Object item = array[--N];
        array[N] = null;
        if (item != null){
            return item;
        }
        return pop();
    }
    public ArrayStack pop(int count) throws StackQueueExceptions {
        if (count > array.length - 1){
            handler.popMultipleFromEmptyStack();
        }
        ArrayStack returnStack = new ArrayStack();
        for (int i = 0; i < count; i++){
            returnStack.push(pop());
        }
        return returnStack;
    }
    //--------------------------------------------------------------------------------

    //Push and insert
    private void allowPush(Object item) throws StackQueueExceptions {
        try {
            if (array.length == N) {
                resize(2 * array.length);
            }
            array[N++] = item;
        }
        catch (Exception e){
            handler.pushBadDataType(array[0].getClass());
        }
    }
    public void push(Object item) throws StackQueueExceptions {
        if (allowAny || N == 0){
            allowPush(item);
        }
        else if(N > 0 && item.getClass() == array[--N].getClass()){
            allowPush(item);
        }
        else{
            handler.pushBadDataType(array[N].getClass());
        }

    }
    public void push(Object[] items) throws StackQueueExceptions {
        for (Object item : items){
            push(item);
        }
    }
    public void push(ArrayStack items) throws StackQueueExceptions {
        for (Object item: items.iterator()){
            this.push(item);
        }
    }
    public void push() throws StackQueueExceptions {
        push(Keyboard.next());
    }
    public void push(LinkedListStack items) throws StackQueueExceptions {
        while(!items.isEmpty()){
            push((Object) items.pop());
        }
    }
    //--------------------------------------------------------------------------------

    //ALLOW MULTIPLE DATA TYPES
    public void allowAny(boolean value){
        allowAny = value;
    }
    //--------------------------------------------------------------------------------

    //Print Stack-
    @Override
    public String toString() {
        String returnString ="[";
        if (array[0] != null){
            returnString = returnString + String.valueOf(array[0]);
        }
        for (int i = 1; i < array.length - 1; i++){
            if (array[i] != null){
                returnString = ", " + returnString + String.valueOf(array[i]);
            }
        }
        if (array[array.length - 1] != null){
            returnString = returnString + String.valueOf(array[array.length - 1]);
        }        returnString = returnString +"]";
        return returnString;
    }
    public void printStack(){
        System.out.println(this.toString());
    }
}