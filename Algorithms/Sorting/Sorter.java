//PACKAGES AND IMPORTS-
package Algorithms.Sorting;
//--------------------------------------------------------------------------------

import Exceptions.SortingExceptions;

import java.util.Random;

public class Sorter {
    //Important prerequisities
    private final SortingExceptions handler = new SortingExceptions();
    private Comparable[] array;
    private long lastSortingTime;
    //--------------------------------------------------------------------------------

    //Set array
    public void setArray(Comparable[] array) {
        this.array = array;
    }
    public void setArray(Comparable[] array, int index){
        Comparable[] temp = new Comparable[index];
        for (int i = 0; i <= index; i++){
            temp[i] = array[i];
        }
        setArray(temp);
    }
    public void setIndex(int index){
        setArray(this.array, index);
    }
    //--------------------------------------------------------------------------------

    //Constructors
    public Sorter(Comparable[] array) {
        this.array = array;
    }
    public Sorter(){}
    //--------------------------------------------------------------------------------

    //Private functions
    private boolean less(Comparable v, Comparable w) throws SortingExceptions {
        try{
            return v.compareTo(w) < 0;
        }
        catch (Exception e){
            handler.dataTypeNotComparable();
        }
        return false;
    }
    private void swap(int index1, int index2){
        Comparable temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    private void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) throws SortingExceptions {
        for (int k = low; k <= high; k++){
            aux[k] = a[k];
        }
        int i = low;
        int j = mid+1;
        for (int k = low; k <= high; k++){
            if (i > mid){
                a[k] = aux[j++];
            }
            else if (j > high){
                a[k] = aux[i++];
            }
            else if (less(aux[j], aux[i])){
                a[k] = aux[j++];
            }
            else{
                a[k] = aux[i++];
            }
        }
    }
    private void merge(Comparable[] array, int left, int mid, int right) throws SortingExceptions {
        Comparable[] L = new Comparable[mid - left + 1];
        Comparable[] R = new Comparable[right - mid];

        for (int i = 0; i < mid - left + 1; i++) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < right - mid; j++){
            R[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < mid - left + 1 && j < right - mid){
            if (less(L[i], R[j]) || (less(L[i], R[j]) && less(R[j], L[i]))){
                array[k] = L[i];
                i++;
            }
            else{
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while ( i < mid - left + 1){
            array[k] = L[i];
            i++;
            k++;
        }
        while ( j < right - mid){
            array[k] = R[j];
            j++;
            k++;
        }
    }
    private int partition(int low, int high) throws SortingExceptions {
        int i = low, j = high + 1;
        while (true){
            while (less(array[++i], array[low])){
                if (i == high){
                    break;
                }
            }
            while (less(array[low], array[--j])){
                if (j == low){
                    break;
                }
            }
            if (i >= j){
                break;
            }
            swap(i, j);
        }
        swap(low, j);
        return j;
    }
    private void sort(int low, int high) throws SortingExceptions {
        if (high <= low){
            return;
        }
        int j = partition(low, high);
        sort(low, j-1);
        sort(j+1, high);
    }
    //--------------------------------------------------------------------------------

    //SELECTION SORT
    public void selectionSort() throws SortingExceptions {
        long startTime = System.nanoTime();
        for (int i = 0; i < array.length; i++){
            int min = i;
            for(int j = i + 1; j < array.length; j++){
                if (less(array[j], array[min])){
                    min = j;
                }
            }
            swap(i, min);
        }
        lastSortingTime = System.nanoTime() - startTime;
    }
    public void selectionSort(Comparable[] inputarray) throws SortingExceptions {
        array = inputarray;
        selectionSort();
    }
    //--------------------------------------------------------------------------------

    //BUBBLE SORT-
    public void bubbleSort() throws SortingExceptions {
        long startTime = System.nanoTime();
        if (array.length == 0)
        {
            lastSortingTime = System.nanoTime() - startTime;
            return;
        }
        for (int i = 1; i < array.length - 1; i++)
        {
            for (int j = array.length; j < i+1; j--)
            {
                if (less(array[j], array[j-1]))
                    swap(j, j-1);
            }
        }
        lastSortingTime = System.nanoTime() - startTime;
        return;
    }
    public void bubbleSort(Comparable[] inputArray) throws SortingExceptions {
        array = inputArray;
        bubbleSort();
    }
    //--------------------------------------------------------------------------------

    //INSERTION SORT
    public void insertionSort() throws SortingExceptions {
        long startTime = System.nanoTime();
        for (int i = 0; i < array.length; i++){
            for (int j = i; j > 0; j--){
                if (less(array[j], array[j-1])){
                    swap(j, j-1);
                }
            }
        }
        lastSortingTime = System.nanoTime() - startTime;
    }
    public void insertionSort(Comparable[] inputarray) throws SortingExceptions {
        array = inputarray;
        insertionSort();
    }
    //--------------------------------------------------------------------------------

    //BOTTOM UP MERGE SORT AND MERGE SORT
    public void bottomUpMergeSort() throws SortingExceptions {
        long startTime = System.nanoTime();
        Comparable[] temp = new Comparable[array.length];
        for (int size = 1; size < array.length; size = size * 2){
            for (int low = 0; low < array.length - size; low+= size*2){
                merge(array, temp, low, low+size-1, Math.min(low+size+size-1, array.length-1));
            }
        }
        lastSortingTime = System.nanoTime() - startTime;
    }
    public void bottomUpMergeSort(Comparable[] inputarray) throws SortingExceptions {
        array = inputarray;
        bottomUpMergeSort();
    }
    private void mergeSort(int left, int right) throws SortingExceptions {
        long startTime = System.nanoTime();
        if (left < right){
            int mid = (left + right)/2;
            mergeSort(left, mid);
            mergeSort(mid+1, right);
            merge(array, left, mid, right);
        }
        lastSortingTime = System.nanoTime() - startTime;
    }
    public void mergeSort() throws SortingExceptions {
        mergeSort(0, array.length - 1);
    }
    public void mergeSort(Comparable[] inputArray) throws SortingExceptions {
        array = inputArray;
        mergeSort();
    }
    //--------------------------------------------------------------------------------

    //SHELL SORT
    public void shellSort() throws SortingExceptions {
        int h = 1;
        while ( h < array.length/3){
            h = 3*h +1;
        }
        while (h >= 1){
            for (int i = h; i < array.length; i++){
                for (int j = i; (j >= h) && less(array[j], array[j-h]); j -=h){
                    swap(j, j-h);
                }
            }
            h = h/3;
        }
    }
    public void shellSort(Comparable[] inputArray) throws SortingExceptions {
        setArray(inputArray);
        shellSort();
    }
    //--------------------------------------------------------------------------------

    //QUICK SORT
    public void quickSort() throws SortingExceptions {
        shuffle(array);
        sort(0, array.length - 1);
    }
    public void quickSort(Comparable[] array) throws SortingExceptions {
        setArray(array);
        quickSort();
    }
    //--------------------------------------------------------------------------------

    //HITLER SORT-
    public void hitlerSort() throws SortingExceptions {
        long startTime = System.nanoTime();
        Comparable[] temp = new Comparable[1];
        temp[0] = array[0];
        array = temp;
        lastSortingTime = System.nanoTime() - startTime;
    }
    public void hitlerSort(Comparable[] inputArray) throws SortingExceptions {
        array = inputArray;
        hitlerSort();
    }
    //--------------------------------------------------------------------------------

    //SHUFFLE AND REVERSE AND CHECK IF SORTED
    public void shuffle(){
        Random generator = new Random();
        for (int i = 1; i < array.length; i++){
            swap(i, generator.nextInt(0, i));
        }
    }
    public void shuffle(Comparable[] inputArray){
        setArray(inputArray);
        shuffle();
    }
    public Comparable[] reverse(Comparable[] array){
        Comparable[] temp = new Comparable[array.length];
        for (int i = 0; i < array.length; i++){
            temp[i] = array[array.length - 1 - i];
        }
        return temp;
    }
    public Comparable[] reverse(){
        return reverse(this.array);
    }
    public boolean isSorted() throws SortingExceptions {
        for (int i = 0; i < array.length - 1; i++) {
            if (less(array[i + 1], array[i])){
                return false;
            }
        }
        return true;
    }
    public boolean isSorted(Comparable[] array) throws SortingExceptions {
        this.array = array;
        if (this.array.length < 2){
            return true;
        }
        return isSorted();
    }

    //--------------------------------------------------------------------------------

    //Print Array
    @Override
    public String toString(){
        String returnString ="[";
        for (int i = 0; i < array.length - 1; i++){
            returnString = returnString + String.valueOf(array[i]) + ", ";
        }
        returnString = returnString + String.valueOf(array[array.length - 1]) + "]";
        return returnString;
    }
    //Get lastSortedTime
    public Long getLastSortingTime(){
        return lastSortingTime;
    }
    public String getLastSortingTime(String format) throws SortingExceptions {
        if (format.equals("nanoseconds"))
        {
            return String.valueOf(lastSortingTime) + " nano seconds taken";
        }
        if (format.equals("seconds")){
            return String.valueOf((double) lastSortingTime/1000000000) + " seconds taken";
        }
        else if (format.equals("milliseconds")){
            return String.valueOf((double) lastSortingTime/1000000) + " milliseconds taken";
        }
        else if (format.equals("minutes")){
            return String.valueOf((double) lastSortingTime/1000000000/60) + " minutes taken";
        }
        else if (format.equals("milliseconds")){
            return String.valueOf((double) lastSortingTime/1000000000/60/60) + " hours taken";
        }
        else if (format.equals("days")){
            return String.valueOf((double) lastSortingTime/1000000000/60/60/24) + " days taken";
        }
        else if (format.equals("years")){
            return String.valueOf((double) lastSortingTime/1000000000/60/60/24/365.5) + " years taken";
        }
        else if (format.equals("decades")){
            return String.valueOf((double) lastSortingTime/1000000000/60/60/24/365.5/10) + " decades taken";
        }
        else{
            handler.wrongFormat();
            return "Error";
        }
    }
}
