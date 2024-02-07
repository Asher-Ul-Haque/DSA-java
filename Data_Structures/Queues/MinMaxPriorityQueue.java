package Data_Structures.Queues;
import Exceptions.StackQueueExceptions;

public class MinMaxPriorityQueue <Key extends Comparable<Key>>{
    //Important Prerequisities-
    private Key[] PQ;
    private int N;
    private boolean resizable = true;
    public MinMaxPriorityQueue(int capacity){
        PQ = (Key[]) new Comparable[capacity];
    }
    private final StackQueueExceptions handler = new StackQueueExceptions();
    //--------------------------------------------------------------------------------

    //Methods to check size-
    public boolean isEmpty(){
        return N == 0;
    }
    private boolean less(Key A, Key B) {
        return A.compareTo(B) < 0;
    }
    private void swap(int index1, int index2){
        Key temp = PQ[index1];
        PQ[index1] = PQ[index2];
        PQ[index2] = temp;
    }
    //--------------------------------------------------------------------------------

    //Insertion
    public void insert(Key x){
        if (resizable){
            if (N == PQ.length){
                resize(PQ.length*2);
            }
            if (N == PQ.length/4){
                resize(PQ.length/2);
            }
        }
        PQ[N++] = x;
    }
    public void insert(Key[] keys){
        for (Key x : keys){
            insert(x);
        }
    }
    private void resize(int capacity){
        Comparable[] copy = new Comparable[capacity];
        for (int i = 0; i < N; i++){
            copy[i] = PQ[i];
        }
        PQ = (Key[]) copy;
    }
    //--------------------------------------------------------------------------------

    //Delection
    public Key delMin() throws StackQueueExceptions {
        if (isEmpty()){
            handler.dequeueFromEmptyQueue();
        }
        int min = 0;
        for (int i = 1; i < N; i++){
            if (less(PQ[i], PQ[min])){
                min = i;
            }
        }
        swap(min, N-1);
        return PQ[--N];
    }
    public Key delMax() throws StackQueueExceptions {
        if (isEmpty()){
            handler.dequeueFromEmptyQueue();
        }
        int max = 0;
        for (int i = 1; i < N; i++){
            if (less(PQ[max], PQ[i])){
                max = i;
            }
        }
        swap(max, N-1);
        return PQ[--N];
    }
    public MinMaxPriorityQueue delMin(int count) throws StackQueueExceptions {
        if (isEmpty()){
            handler.dequeueMultipleFromEmptyQueue();
        }
        MinMaxPriorityQueue returnMinPQ = new MinMaxPriorityQueue(count);
        returnMinPQ.insert(delMin());
        return returnMinPQ;
    }
    public MinMaxPriorityQueue delMax(int count) throws StackQueueExceptions {
        if (isEmpty()){
            handler.dequeueMultipleFromEmptyQueue();
        }
        MinMaxPriorityQueue returnMaxPQ = new MinMaxPriorityQueue(count);
        returnMaxPQ.insert(delMax());
        return returnMaxPQ;
    }

    //Print Queue-
    @Override
    public String toString() {
        String returnString ="[";
        if (PQ[0] != null){
            returnString = returnString + String.valueOf(PQ[0]);
        }
        for (int i = 1; i < PQ.length - 1; i++){
            if (PQ[i] != null){
                returnString = ", " + returnString + String.valueOf(PQ[i]);
            }
        }
        if (PQ[PQ.length - 1] != null){
            returnString = returnString + String.valueOf(PQ[PQ.length - 1]);
        }        returnString = returnString +"]";
        return returnString;
    }
    public void printQueue(){
        System.out.println(this.toString());
    }

}
