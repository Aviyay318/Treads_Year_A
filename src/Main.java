public class Main {


    public static void main(String[] args) {
        OrderTask orderTask = new OrderTask();
        for (int i = 0; i < 200000; i++) {
           new Thread(orderTask).start();
        }
        for (int i = 0; i < 200000; i++) {
            new Thread(orderTask).start();
        }
//----------------------------------------------------
        Example example = new Example();

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 1000000; i++) {
                example.add();
            }
        });
        t1.start();
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 1000000; i++) {
                example.sub();
            }
        });
        t2.start();
    }
}