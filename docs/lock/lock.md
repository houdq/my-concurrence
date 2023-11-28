# java 中各种锁



## sychronized

```java 
public class SynchronizedDemo {
    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class) {
        }
        method();
    }

    private static synchronized void method() {
    }
}
```
## Lock

### ReentrantLock

* java1.5之后提供的锁 
* ReentrantLock可以替代synchronized进行同步；
* ReentrantLock获取锁更安全；
* 必须先获取到锁，再进入try {...}代码块，最后使用finally保证释放锁；
* 可以使用tryLock()尝试获取锁。



```java
public class LockDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                //todo something
            }
        } finally {
            lock.unlock();
        }
    }
}
```

## 死锁

### 死锁产生的条件

* 互斥条件：一个资源每次只能被一个进程使用
* 请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放
* 不剥夺条件：进程已获得的资源，在末使用完之前，不能强行剥夺
* 循环等待条件：若干进程之间形成一种头尾相接的循环等待资源关系

### 避免死锁
破坏任意一个条件，死锁就不会发生
* 破坏互斥条件：允许多个进程同时访问资源
* 破坏请求与保持条件：进程在请求资源时，不保持原有的资源
* 破坏不剥夺条件：进程允许剥夺原有资源
* 破坏循环等待条件：对资源进行线性编号，按顺序申请资源
