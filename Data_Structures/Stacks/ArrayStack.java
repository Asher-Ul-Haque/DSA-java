package Data_Structures.Stacks;

import Exceptions.Exceptions;

import java.util.Scanner;

public class ArrayStack{
    //Important Prerequisites
    private Comparable[] array = new Comparable[1];
    private int N = 0;
    private boolean allowAny = true;
    private final Exceptions handler = new Exceptions();
    private final Scanner Keyboard = new Scanner(System.in);
    //--------------------------------------------------------------------------------

    //Iterator
    public Comparable[] iterator(){
        return array;
    }
    //--------------------------------------------------------------------------------

    //Resize
    private void resize(int capacity){
        Comparable[] copy = new Comparable[capacity];
        for (int i = 0; i < N; i++){
            copy[i] = array[i];
        }
        array = copy;
    }
    //--------------------------------------------------------------------------------

    //Pop
    public Comparable pop() throws Exceptions {
        if (N < array.length/4){
            resize(array.length/2);
        }
        if (N ==0){
            handler.popFromEmptyStack();
        }
        Comparable item = array[--N];
        array[N] = null;
        if (item != null){
            return item;
        }
        return pop();
    }
    public ArrayStack pop(int count) throws Exceptions {
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

    //Push
    private void allowPush(Comparable item) throws Exceptions {
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
    public void push(Comparable item) throws Exceptions {
        if (allowAny || N == 0){
            allowPush(item);
        }
        else if(N > 0 && item.getClass() == array[N].getClass()){
            allowPush(item);
        }
        else{
            handler.pushBadDataType(array[N].getClass());
        }

    }
    public void push(Comparable[] items) throws Exceptions {
        for (Comparable item : items){
            push(item);
        }
    }
    public void push(ArrayStack items) throws Exceptions {
        for (Comparable item: items.iterator()){
            this.push(item);
        }
    }
    public void push() throws Exceptions {
        push(Keyboard.next());
    }
    public void push(LinkedListStack items) throws Exceptions {
        while(!items.isEmpty()){
            push((Comparable) items.pop());
        }
    }
    //--------------------------------------------------------------------------------

    //ALLOW MULTIPLE DATA TYPES
    public void allowAny(boolean value){
        allowAny = value;
    }

    //Print Stack-
    @Override
    public String toString() {
        String returnString ="[";
        for (int i = 0; i < array.length - 1; i++){
            if (array[i] != null){
                returnString = returnString + String.valueOf(array[i]) + ", ";
            }
        }
        if (array[array.length - 1] != null){
            returnString = returnString + String.valueOf(array[array.length - 1]) + ", ";
        }        returnString = returnString +"]";
        return returnString;
    }
    public void printStack(){
        System.out.println(this.toString());
    }
}