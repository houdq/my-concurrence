package cn.ddx.concurrence.threads.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author daniel.hou
 * @date 2023/11/28 12:02
 * @Desc
 */
public class MySingleThreadPool {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(() -> {
            System.out.println("Thread: Hello, I am a thread!");
        });
    }
}
