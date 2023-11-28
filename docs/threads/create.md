# 线程创建

### Thread类

```java
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread.run()");
    }
}

```

### Runnable接口

    ```java
    public class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("MyRunnable.run()");
        }
    }
  

    public void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
  

    ```

### Callable接口

        ```java
        public class MyCallable implements Callable<String> {
            @Override
            public String call() throws Exception {
                return "MyCallable.call()";
            }
        }
    
    
        public void main(String[] args) {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            Future<String> future = executorService.submit(new MyCallable());
            try {
                String result = future.get();
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    
    
        ```

### 线程池

```
            ExecutorService executorService = Executors.newSingleThreadExecutor();
```

