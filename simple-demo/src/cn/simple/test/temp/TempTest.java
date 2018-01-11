
package cn.simple.test.temp;

public class TempTest {

    public static void main( String[] args ) throws Exception {
        Thread thread = new MyThread();
        thread.start();
        System.out.println("end");
    }
}
class MyThread extends Thread {
    private int i = 0;
    @Override
    public void run() {
        while (true) {
            i++;
            System.out.println(i);
        }
    }
}