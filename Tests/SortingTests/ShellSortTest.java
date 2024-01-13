package Tests.SortingTests;

import Exceptions.SortingExceptions;
import Algorithms.Sorting.Sorter;

public class ShellSortTest {
    public static void main(String[] args) throws SortingExceptions {
        Integer[] list= {34, 1, -1, 2, -23, 453, 2, 0 ,0 ,0};
        Sorter sorter = new Sorter(list);

        sorter.shellSort();
        System.out.println(sorter.toString());
        sorter.shuffle();
        System.out.println(sorter.toString());
        sorter.shellSort();
        System.out.println(sorter.toString());
    }
}
