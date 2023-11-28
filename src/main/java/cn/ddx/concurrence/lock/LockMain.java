package cn.ddx.concurrence.lock;

/**
 * @author daniel.hou
 * @date 2023/11/28 13:59
 * @Desc
 */
public class LockMain {

    //synchronized  demo


    public static void main(String[] args) {
        synchronized (LockMain.class) {
            System.out.println("Hello World!");
        }

        new Thread().start();


    }



}

