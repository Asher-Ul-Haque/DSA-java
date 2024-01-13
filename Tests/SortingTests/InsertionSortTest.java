package Tests.SortingTests;

import Exceptions.SortingExceptions;
import Algorithms.Sorting.Sorter;

public class InsertionSortTest {
    public static void main(String[] args) throws SortingExceptions {
        Integer[] list= {34, 1, -1, 2};
        Sorter sorter = new Sorter(list);

        sorter.insertionSort();
        System.out.println(sorter.toString());
    }
}
