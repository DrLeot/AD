/*
 * Copyright 2022 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.ad.Algorithmen.MergeSort;

import java.util.concurrent.ForkJoinPool;

import ch.hslu.ad.Algorithmen.MergeSort.init.RandomInitTask;
import ch.hslu.ad.Algorithmen.MergeSort.sum.SumTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Performance Vergleich der Mergesort-Implementation.
 */
public final class DemoMergesort {

    private static final Logger LOG = LogManager.getLogger(DemoMergesort.class);

    /**
     * Privater Konstruktor.
     */
    private DemoMergesort() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int size = 300_000_000;
        final int[] array = new int[size];
        final ForkJoinPool pool = new ForkJoinPool();

        // randomize Values
        RandomInitTask initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);

        // Build checksum
        SumTask sumTask = new SumTask(array);
        long result = pool.invoke(sumTask);
        LOG.info("Init. Checksum  : {}", result);
        final MergesortTask sortTask = new MergesortTask(array);

        // Concurrent Run
        long startTime = System.currentTimeMillis();
        pool.invoke(sortTask);
        LOG.info("Conc. Mergesort : {} sec.", (float)(System.currentTimeMillis()-startTime)/1000);

        // Build checksum
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Merge Checksum  : {}", result);

        // randomize Values
        initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);

        // Build Checksum
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Init. checksum  : {}", result);

        // Recursive Run
        startTime = System.currentTimeMillis();
        MergesortRecursive.mergeSort(array);
        LOG.info("MergesortRec.   : {} sec.", (float)(System.currentTimeMillis()-startTime)/1000);
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Sort checksum   : {}", result);
    }
}
