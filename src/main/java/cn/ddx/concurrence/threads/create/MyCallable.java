package cn.ddx.concurrence.threads.create;

import java.util.concurrent.*;

/**
 * @author daniel.hou
 * @date 2023/11/28 11:42
 * @Desc
 */
public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        return "Callable: Hello, I am a callable!";
    }

    public static void main(String[] args) throws Exception {
        MyCallable myCallable = new MyCallable();
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(myCallable);

        // 获取线程执行结果
        String result = null;
        result = future.get();

        System.out.println(result);

        // 关闭线程池
        executorService.shutdown();

    }
}
