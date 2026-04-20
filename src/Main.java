import java.util.Random;

public class Main {


    public static void main(String[] args) {
        Student student = new Student("abc" , 10);


        Thread avgThread = new Thread(()->{
            while (true){
                System.out.println("The avg : " + student.getAvg());

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        avgThread.start();

        Thread maxThread = new Thread(()->{
            while (true){
                System.out.println("The max : " + student.getMax());

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        maxThread.start();

        Thread addThread = new Thread(()->{
            while (true){
                int randomGrade = new Random().nextInt(101);
                System.out.println("Adding  : " + randomGrade + " : " + student.addGrades(randomGrade));

                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        addThread.start();

        Thread removeThread = new Thread(()->{
            while (true){
                System.out.println("removing  : " + student.removeFirstGrade());

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        removeThread.start();
    }
}