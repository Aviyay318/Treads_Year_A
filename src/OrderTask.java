import java.net.http.HttpHeaders;

public class OrderTask implements Runnable {
    private int stock;


    public OrderTask(){
        this.stock = 10;
    }

    public synchronized void run(){
        System.out.println("stock : " + this.stock);
        if (this.stock>0){
            this.stock--;
            System.out.println("order successes");
        }else if (this.stock<0){
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        }
    }

}
