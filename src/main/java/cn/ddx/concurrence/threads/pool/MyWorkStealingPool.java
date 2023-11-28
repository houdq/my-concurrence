package cn.ddx.concurrence.threads.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author daniel.hou
 * @date 2023/11/28 13:35
 * @Desc 通过Executors创建一个StealingPool 线程池
 */
public class MyWorkStealingPool {
    public static void main(String[] args) throws Exception, InterruptedException {

        // 创建一个可缓存线程池
        // 多个独立线程，自己线程中任务完成，回去其他线程的阻塞队列中获取任务执行，如果没有任务，会自动阻塞


        ExecutorService executorService = Executors.newWorkStealingPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                System.out.println("Thread: Hello, I am a work stealing thread!" + finalI);
            });
        }

        Thread.sleep(10000);//这里让主线程等待子线程执行完毕，也可以使用计数器的方式

        executorService.shutdown();


    }
}
