package cn.ddx.concurrence.threads.create;

/**
 * @author daniel.hou
 * @date 2023/11/28 11:44
 * @Desc
 */
public class MyThread extends Thread{

        @Override
        public void run() {
            System.out.println("Thread");

        }

        public static void main(String[] args) {

            //直接 new Thread
            MyThread myThread = new MyThread();
            myThread.start();


            // lambda 表达式
            new Thread(() -> {
                // 线程执行的代码
                System.out.println("Thread: Hello, I am a thread!");
            }).start();

            // 匿名内部类
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 线程执行的代码
                    System.out.println("Runnable: Hello, I am a thread!");
                }
            }).start();

        }
}
