package cn.ddx.concurrence.threads.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author daniel.hou
 * @date 2023/11/28 12:08
 * @Desc
 */
public class MyCachedThreadPool {
    public static void main(String[] args) {
        // 创建一个可缓存线程池
        // 如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            System.out.println("Thread: Hello, I am a cached thread!");
        });


    }
}
