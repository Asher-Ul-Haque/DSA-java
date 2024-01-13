package Tests.SortingTests;

import Exceptions.SortingExceptions;
import Algorithms.Sorting.Sorter;

import java.util.Random;

public class MergeSortTest {
    public static void main(String[] args) throws SortingExceptions {
        Integer[] list= {34, 1, -1, 2, 0, 0, -91};
        Sorter sorter = new Sorter();
        list = new Integer[1000000];
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            list[i] = random.nextInt();
        }
        sorter.setArray(list);
        System.out.println(sorter.toString());
        sorter.mergeSort();
        System.out.println(sorter.toString());
        System.out.println(sorter.getLastSortingTime("seconds"));
    }
}
