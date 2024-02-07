//PACKAGE AND IMPORTS-
package Algorithms.Searching;
import Exceptions.SearchExceptions;
import Exceptions.SortingExceptions;
//------------------------------------------------------------

public class Searcher<Item> {
    //Important Prerequisities
    private Item[] array;
    private Comparable[] comparableArray;
    private Item key;
    private Comparable target;
    private Long lastSortingTime;
    private boolean lastSearchisLinear = true;
    private final SearchExceptions handler = new SearchExceptions();
    //--------------------------------------------------------------------

    //Constructors
    public Searcher(Item[] inputArray){
        array = inputArray;
    }
    public Searcher(Item[] inputArray, Item target){
        array = inputArray;
        key = target;
    }
    public Searcher(){}
    //-------------------------------------------------------------------

    //Linear Search
    public boolean linearSearch(){
        long startTime = System.nanoTime();
        for (Item a : array){
            if (a == key){
                return true;
            }
        }
        lastSortingTime = System.nanoTime() - startTime;
        lastSearchisLinear = true;
        return false;
    }
    public boolean linearSearch(Item[] inputArray){
        array = inputArray;
        return linearSearch();
    }
    public boolean linearSearch(Item target){
        key = target;
        return linearSearch();
    }
    public boolean linearSearch(Item[] inputArray, Item target){
        array = inputArray;
        key = target;
        return linearSearch();
    }
    //------------------------------------------------------------------

    //Linear Search Index-
    public int linearSearchIndex(){
        long startTime = System.nanoTime();
        for (int i = 0; i < array.length; i++){
            if (array[i] == key){
                lastSortingTime = System.nanoTime() - startTime;
                lastSearchisLinear = true;
                return i;
            }
        }
        lastSortingTime = System.nanoTime() - startTime;
        lastSearchisLinear = true;
        return -1;
    }
    public int linearSearchIndex(Item[] inputArray){
        array = inputArray;
        return linearSearchIndex();
    }
    public int linearSearchIndex(Item target){
        key = target;
        return linearSearchIndex();
    }
    public int linearSearchIndex(Item[] inputArray, Item target){
        key = target;
        array = inputArray;
        return linearSearchIndex();
    }
    //-----------------------------------------------------------------

    //check sort and compare functions-
    private boolean less(Comparable v, Comparable w) throws SearchExceptions {
        try{
            return v.compareTo(w) < 0;
        }
        catch (Exception e){
            handler.dataTypeNotComparable();
        }
        return false;
    }
    private boolean isSorted() throws SearchExceptions{
        for (int i = 0; i < comparableArray.length - 1; i++) {
            if (less(comparableArray[i + 1], comparableArray[i])){
                return false;
            }
        }
        return true;
    }
    public boolean isSorted(Comparable[] array) throws SearchExceptions {
        this.comparableArray = array;
        if (this.array.length < 2){
            return true;
        }
        return isSorted();
    }
    //-----------------------------------------------------------------

    //Binary search-
    public boolean binarySearch() throws SearchExceptions {
        long startTime = System.nanoTime();
        int start = 0;
        int end = comparableArray.length;
        if (!isSorted()){
            lastSortingTime = System.nanoTime() - startTime;
            handler.notSorted();
        }
        while(start != end){
            if (comparableArray[start+end/2] == target){
                lastSortingTime = System.nanoTime() - startTime;
                lastSearchisLinear = false;
                return true;
            }
            else if (less(comparableArray[start+end/2], target)) {
                start = start+end/2;
            }
            else if (less(target, comparableArray[start+end/2])){
                end = start+end/2;
            }
        }
        lastSortingTime = System.nanoTime() - startTime;
        lastSearchisLinear = false;
        return false;
    }
    public boolean binarySearch(Comparable target) throws SearchExceptions {
        this.target = target;
        return binarySearch();
    }
    public boolean binarySearch(Comparable[] searchArray) throws SearchExceptions {
        this.comparableArray = searchArray;
        return binarySearch();
    }
    public boolean binarySearch(Comparable[] searchArray, int target) throws SearchExceptions {
        this.target = target;
        this.comparableArray = searchArray;
        return binarySearch();
    }
    public boolean binarySearch(Item[] searchArray) throws SearchExceptions {
        handler.dataTypeNotComparable();
        return false;
    }
    public boolean binarySearch(Item[] searchArray, Item target) throws SearchExceptions {
        handler.dataTypeNotComparable();
        return false;
    }
    public boolean binarySearch(Item target) throws SearchExceptions {
        handler.dataTypeNotComparable();
        return false;
    }
    //-----------------------------------------------------------------

    //Binary search index
    public int binarySearchIndex() throws SearchExceptions {
        long startTime = System.nanoTime();
        int start = 0;
        int end = comparableArray.length;
        if (!isSorted()){
            lastSortingTime = System.nanoTime() - startTime;
            handler.notSorted();
        }
        while(start != end){
            if (comparableArray[start+end/2] == target){
                lastSortingTime = System.nanoTime() - startTime;
                lastSearchisLinear = false;
                return start+end/2;
            }
            else if (less(comparableArray[start+end/2], target)) {
                start = start+end/2;
            }
            else if (less(target, comparableArray[start+end/2])){
                end = start+end/2;
            }
        }
        lastSortingTime = System.nanoTime() - startTime;
        lastSearchisLinear = false;
        return -1;
    }
    public int binarySearchIndex(Comparable target) throws SearchExceptions {
        this.target = target;
        return binarySearchIndex();
    }
    public int binarySearchIndex(Comparable[] searchArray, Comparable target) throws SearchExceptions {
        this.comparableArray = searchArray;
        this.target = target;
        return binarySearchIndex();
    }
    public int binarySearchIndex(Comparable[] searchArray) throws SearchExceptions {
        this.comparableArray = searchArray;
        return binarySearchIndex();
    }
    public int binarySearchIndex(Item[] searchArray, Item target) throws SearchExceptions {
        handler.dataTypeNotComparable();
        return -1;
    }
    public int binarySearchIndex(Item[] searchArray) throws SearchExceptions {
        handler.dataTypeNotComparable();
        return -1;
    }
    public int binarySearchIndex(Item target) throws SearchExceptions {
        handler.dataTypeNotComparable();
        return -1;
    }
    //-----------------------------------------------------------------

    //Set stuff and get stuff-
    public void setArray(Item[] inputArray){
        this.array = inputArray;
    }
    public void setArray(Comparable[] inputArray){
        this.comparableArray = inputArray;
    }
    public void setTarget(Item target){
        key = target;
    }
    public void setTarget(Comparable target){this.target = target;}
    //-----------------------------------------------------------------

    //To string-
    @Override
    public String toString(){
        String returnString ="[";
        if (lastSearchisLinear){
            for (int i = 0; i < array.length - 1; i++){
                returnString = returnString + String.valueOf(array[i]) + ", ";
            }
            returnString = returnString + String.valueOf(array[array.length - 1]) + "]";
        }
        else{
            for (int i = 0; i < comparableArray.length - 1; i++){
                returnString = returnString + String.valueOf(comparableArray[i]) + ", ";
            }
            returnString = returnString + String.valueOf(comparableArray[comparableArray.length - 1]) + "]";
        }

        return returnString;
    }
    public String toString(Item[] keys){
        lastSearchisLinear = true;
        this.array = keys;
        return toString();
    }
    public String toString(Comparable[] keys){
        this.comparableArray = keys;
        lastSearchisLinear = false;
        return toString();
    }
    //----------------------------------------------------------------

    //Get lastSortedTime
    public String getLastSortingTime(){
        return String.valueOf(lastSortingTime) + " nano seconds taken";
    }
    public String getLastSortingTime(String format) throws SortingExceptions, SearchExceptions {
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
