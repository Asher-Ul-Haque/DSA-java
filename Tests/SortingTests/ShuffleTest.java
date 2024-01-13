package Tests.SortingTests;

import Algorithms.Sorting.Sorter;

import java.util.Random;

public class ShuffleTest {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        Integer[] list = new Integer[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list[i] = random.nextInt(Integer.MAX_VALUE);
        }
        sorter.setArray(list);
        System.out.println(sorter.toString());
        sorter.shuffle();
        System.out.println(sorter.toString());
    }
}
