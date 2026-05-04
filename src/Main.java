public class Main {


    public static void main(String[] args) {
        Show show = new Show("a" , 10000);

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 6000; i++) {
                show.salesTickets();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 6000; i++) {
                show.salesTickets();
            }
        });
        Thread t3 = new Thread(()->{
            for (int i = 0; i < 6000; i++) {
                show.salesTickets();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        show.print();
    }

}
