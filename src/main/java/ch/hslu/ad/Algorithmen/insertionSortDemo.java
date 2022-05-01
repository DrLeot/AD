package ch.hslu.ad.Algorithmen;

import ch.hslu.ad.Datenstrukturen.Farbkuebel.FarbkübelDemo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Random;

public class insertionSortDemo {

    private static final Logger LOG = LogManager.getLogger(insertionSortDemo.class);

    public static void main(String[] args){
        circle(10_000);
        circle(20_000);
        circle(40_000);

    }

    private static void circle(final int n){
        int[] arraySorted = RandomArrays.getNumberedArray(n);
        int[] arrayReverseSorted = RandomArrays.getReverseNumberedArray(n);
        int[] arrayRandom = RandomArrays.getRandomNumberedUniqueArray(n);

        LOG.info("n -> {}", n);

        long startTime = System.currentTimeMillis();
        Sort.insertionSort(arraySorted);
        LOG.info("Sorted Array: {} ms",System.currentTimeMillis()-startTime);

        startTime = System.currentTimeMillis();
        Sort.insertionSort(arrayReverseSorted);
        LOG.info("Reverse Array: {} ms",System.currentTimeMillis()-startTime);

        startTime = System.currentTimeMillis();
        Sort.insertionSort(arrayRandom);
        LOG.info("Random Array: {} ms",System.currentTimeMillis()-startTime);

    }


}
