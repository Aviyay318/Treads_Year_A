import java.util.Random;

public class Main {


    public static void main(String[] args) {
        int [] grades = new int[20];

        int x  = 0;
       try{
           System.out.println((5/x));
       }catch (Exception e){
           System.out.println("can't div by zero");
       }


        Thread t1  = new Thread(()->{
            for (int i = 0; i < grades.length/2 ; i++) {
                Random random = new Random();
                int grade = random.nextInt(50,101);
                System.out.println("T1 : "  +grade);
               grades[i] = grade ;
            }
        });
        t1.start();
        Thread t2  = new Thread(()->{
            for (int i = grades.length/2; i < grades.length ; i++) {
                Random random = new Random();
                int grade = random.nextInt(50,101);
                System.out.println("T2: " + grade);
                grades[i] = grade ;
            }
        });
        t2.start();

        System.out.println("before join");
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("after join");
        int sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum+=grades[i];
        }
        double avg  = (double) sum / grades.length;
        System.out.println("The Avg : " + avg );
    }
}