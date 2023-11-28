# thread pool

### 常用的线程池

#### newCachedThreadPool 
这个线程池会根据任务的数量动态调整线程的数量。适用于执行许多短期异步的小程序，性能较好。


```java
public static ExecutorService newCachedThreadPool() {
    return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                  60L, TimeUnit.SECONDS,
                                  new SynchronousQueue<Runnable>());
}
```
    
#### newFixedThreadPool
这个线程池会保持一个固定数量的线程，当有任务提交时，就会用其中一个线程来执行。适用于执行长期的任务，性能稳定。


```java
public static ExecutorService newFixedThreadPool(int nThreads) {
    return new ThreadPoolExecutor(nThreads, nThreads,
                                  0L, TimeUnit.MILLISECONDS,
                                  new LinkedBlockingQueue<Runnable>());
}
```

#### newSingleThreadExecutor
这个线程池只包含一个线程，适用于需要顺序执行任务的场景。


```java
public static ExecutorService newSingleThreadExecutor() {
    return new FinalizableDelegatedExecutorService
        (new ThreadPoolExecutor(1, 1,
                                0L, TimeUnit.MILLISECONDS,
                                new LinkedBlockingQueue<Runnable>()));
}
```

#### newScheduledThreadPool
这个线程池可以延迟或定期执行任务，适用于需要按照计划执行任务的场景。



```java
public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
    return new ScheduledThreadPoolExecutor(corePoolSize);
}
```

#### newworkStealingPool

底层用的ForkJoinPool 来实现的。 ForkJoinPool的优势在于，可以充分利用多cpu，多核cpu的优势，把一个任务拆分成多个“小任务”分发到不同的cpu核心上执行，执行完后再把结果收集到一起返回。

**特点：**
- 可以传入线程的数量，不传入，则默认使用当前计算机中可用的cpu数量
- 能够合理的使用CPU进行对任务操作（并行操作）
- 适合使用在很耗时的任务中

```java
ExecutorService executorService = Executors.newWorkStealingPool();

```

### 线程池的原理
根据自定义预先创建一些线程，放入队列中，当有任务提交时，就会用其中一个线程来执行。如果队列中的线程都在执行任务，那么就会创建新的线程来执行任务。如果线程空闲时间超过设定的时间，就会被销毁。

### 线程池的作用
- 降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的消耗。
- 提高响应速度。当任务到达时，任务可以不需要等到线程创建就能立即执行。
- 提高线程的可管理性。线程是稀缺资源，如果无限制的创建，不仅会消耗系统资源，还会降低系统的稳定性，使用线程池可以进行统一的分配，调优和监控。
- 提供更多更强大的功能。线程池具备可拓展性，允许开发人员向其中增加更多的功能。比如延时定时线程池ScheduledThreadPoolExecutor，就允许任务延期执行或定期执行。

### 适用场景
- 服务器接受客户端请求，每个请求都会用一个线程去处理，如果并发量很大，就会创建大量的线程，导致服务器资源消耗殆尽。使用线程池可以解决这个问题。
- 一个相对固定的资源池，可以用来执行各种各样的异步任务。
- 一个任务队列，用来存放异步任务，然后用一个线程池去执行这些任务。
- 一个定时任务队列，用来定时执行任务。