package ch.hslu.ad.Lists.RingBufferQueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RingBufferQueueTest {


    @Test
    public void TestInsertToEmpty(){
        RingBufferQueue ringBufferQueue = new RingBufferQueue(10);
        ringBufferQueue.enqueue('A');
        ringBufferQueue.enqueue('B');
        ringBufferQueue.enqueue('C');
        assertEquals(3,ringBufferQueue.getUsedSize());
    }

    @Test
    public void testDequeueOnce(){
        RingBufferQueue ringBufferQueue = new RingBufferQueue(10);
        ringBufferQueue.enqueue('A');
        ringBufferQueue.enqueue('B');
        ringBufferQueue.enqueue('C');
        assertEquals('A',ringBufferQueue.dequeue());
    }

    @Test
    public void testDequeueTwice(){
        RingBufferQueue ringBufferQueue = new RingBufferQueue(10);
        ringBufferQueue.enqueue('A');
        ringBufferQueue.enqueue('B');
        ringBufferQueue.enqueue('C');
        ringBufferQueue.dequeue();
        assertEquals('B',ringBufferQueue.dequeue());
    }
}