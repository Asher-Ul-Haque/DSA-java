package Tests.SortingTests;

import Exceptions.SortingExceptions;
import Algorithms.Sorting.Sorter;

public class QuickSortTest {
    //QUICK SORT FAILS TEST
    public static void main(String[] args) throws SortingExceptions {
        Integer[] list= {34, 1, -1, 2, -23, 453, 2, 0 ,0 ,0};
        Sorter sorter = new Sorter(list);
        sorter.quickSort();
        System.out.println(sorter.toString());
    }
}
