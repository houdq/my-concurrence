package cn.ddx.concurrence.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author daniel.hou
 * @date 2023/11/28 14:01
 * @Desc Java 5.0 新增了一个 java.util.concurrent.locks 包，在该包中增加了一些新的锁支持。
 */
public class RenentrenceLock {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();

        // do something
        // trylock() 尝试获取锁，如果获取成功返回 true，否则返回 false
        if (reentrantLock.tryLock()) {

            try {
                // do something
                System.out.printf("Hello, I am a lock!");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }


    }

}
