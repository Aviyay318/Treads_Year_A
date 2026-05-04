import java.util.Random;

public class MyMain {
    static int partialSum;
    public static void main(String[] args) {
        int[] arr = new int[new Random().nextInt(200001)];
        for (int i = 0; i < arr.length; i++)
            arr[i] = i;

        double avg = calculateAverage(arr);
        System.out.println("Average: " + avg);
    }

    public static double calculateAverage(int[] array) {
        int chunkSize = 100000;
        int numberOfThreads = (int) Math.ceil((double) array.length / chunkSize);
        Thread[] threads = new Thread[numberOfThreads];
        partialSum = 0;

        for (int t = 0; t < numberOfThreads; t++) {
            int start = t * chunkSize;
            int end = Math.min(start + chunkSize, array.length);

            threads[t] = new Thread(() -> {
                for (int i = start; i < end; i++)
                    partialSum += array[i];
            });
        }

        for (Thread thread : threads)
            thread.start();

        try {
            for (Thread thread : threads)
                thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return partialSum / array.length;
    }
}
