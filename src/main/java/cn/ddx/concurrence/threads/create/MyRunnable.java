package cn.ddx.concurrence.threads.create;

/**
 * @author daniel.hou
 * @date 2023/11/28 11:39
 * @Desc
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable");
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);

        thread.start();
    }
}
