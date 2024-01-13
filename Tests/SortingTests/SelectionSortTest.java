package Tests.SortingTests;

import Exceptions.SortingExceptions;
import Algorithms.Sorting.Sorter;

public class SelectionSortTest {


    public static void main(String[] args) throws SortingExceptions {
        Integer[] list= {34, 1, -1, 2};
        Sorter sorter = new Sorter();

        sorter.selectionSort(list);
        System.out.println(sorter.toString());
    }

}
