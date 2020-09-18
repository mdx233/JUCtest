package 阻塞队列;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 *功能描述
 * @author mdx
 * @date 2020/8/18
 * @param
 * @return
 *
 *
 */
public class   BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        //构造方法参数传入一个int类型数，表示队列中的存储容量
        BlockingQueue <String> blockingQueue = new ArrayBlockingQueue<>(3);

        //改方法为报异常

        //add方法往队列中添加数据，如果添加成功则返回true
        //System.out.println(blockingQueue.add("A"));
        //System.out.println(blockingQueue.add("B"));
        //System.out.println(blockingQueue.add("C"));
        //如果队列已满，再添加数据则报IllegalStateException异常
        //System.out.println(blockingQueue.add("D"));

        //remove方法移除队列中第一个值，如果成功则返回被移除的数据的值
        //System.out.println(blockingQueue.remove());
        //System.out.println(blockingQueue.remove());
        //System.out.println(blockingQueue.remove());
        //如果队列为空，再移除数据则NoSuchElementException异常
        //System.out.println(blockingQueue.remove());

        //element方法检查队列中第一个元素，如果队列中没有元素则报NoSuchElementException异常
        //System.out.println(blockingQueue.element());
        //System.out.println(blockingQueue.element());
        //System.out.println(blockingQueue.element());

        //offer方法往队列中添加一个数据，成功则返回true
        // System.out.println(blockingQueue.offer("a"));
        // System.out.println(blockingQueue.offer("b"));
        // System.out.println(blockingQueue.offer("c"));
        //如果队列已满，再添加数据则返回false
        //System.out.println(blockingQueue.offer("d"));

        //poll方法移除队列中第一个元素，并返回被移除元素的值
        // System.out.println(blockingQueue.poll());
        // System.out.println(blockingQueue.poll());
        // System.out.println(blockingQueue.poll());
        //如果该队列中没有元素则返回null
        //System.out.println(blockingQueue.poll());

        //peek方法与element方法效果一样
        //System.out.println(blockingQueue.peek());

        //put方法往队列中添加元素，
        // blockingQueue.put("A");
        // blockingQueue.put("B");
        // blockingQueue.put("C");
        //如果队列已满再往队列中用put方法添加元素，则会导致程序堵塞。
        //blockingQueue.put("D");

        //take方法从队列中拿出一个元素，并返回该元素的值
        // System.out.println(blockingQueue.take());
        // System.out.println(blockingQueue.take());
        // System.out.println(blockingQueue.take());

        //如果队列已空再使用take方法，则会导致程序阻塞
        //System.out.println(blockingQueue.take());

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        //该方法再队列满时会阻塞当前线程一段时间，当时间超过后该线程会退出
        blockingQueue.offer("a",3, TimeUnit.SECONDS);

    }
}
