import java.util.concurrent.atomic.AtomicInteger;

public class Show {
    private String name;
    private AtomicInteger tickets;

    public Show(String name,int tickets){
        this.name = name;
        this.tickets = new AtomicInteger(tickets);
    }
    public synchronized void salesTickets(){
        if (this.tickets.get()>0){
            this.tickets.decrementAndGet();
            Utils.sleep(10);
            System.out.println("sold one ticket , the stock is : " +this.tickets.get());
        }else {
            System.out.println("out of stock: "  + this.tickets.get());
        }
    }

    public void print() {
        System.out.println("the tickets : " +this.tickets.get());

    }
}
