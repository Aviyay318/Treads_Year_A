public class Example {
    private int counter;


    public Example(){
        this.counter = 0;
    }

    public synchronized void add(){
        this.counter++;
        System.out.println(this.counter);
    }

    public synchronized void sub(){
        this.counter--;
        System.out.println(counter);
    }
}
