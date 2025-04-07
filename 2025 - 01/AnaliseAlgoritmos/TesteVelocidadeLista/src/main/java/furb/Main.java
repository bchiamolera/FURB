package furb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<long[]> times = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            times.add(insertAndCompare(100000));
        }
        long[] average = calculateAverage(times);
        System.out.printf("ArrayList Average 100000 = %d microssegundos", average[0]);
        System.out.printf("\nLinkedList Average 100000 = %d microssegundos\n", average[1]);

        times.clear();
        for (int i = 0; i < 20; i++) {
            times.add(insertAndCompareFixed(10, 100000));
        }
        average = calculateAverage(times);
        System.out.printf("\nArrayList (fixed) Average 10 = %d microssegundos", average[0]);
        System.out.printf("\nLinkedList Average 10 = %d microssegundos\n", average[1]);

        times.clear();
        for (int i = 0; i < 20; i++) {
            times.add(insertAndCompareFixed(1000, 100000));
        }
        average = calculateAverage(times);
        System.out.printf("\nArrayList (fixed) Average 1000 = %d microssegundos", average[0]);
        System.out.printf("\nLinkedList Average 1000 = %d microssegundos\n", average[1]);

        times.clear();
        for (int i = 0; i < 20; i++) {
            times.add(insertAndCompareFixed(50000, 100000));
        }
        average = calculateAverage(times);
        System.out.printf("\nArrayList (fixed) Average 50000 = %d microssegundos", average[0]);
        System.out.printf("\nLinkedList Average 50000 = %d microssegundos\n", average[1]);

        times.clear();
        for (int i = 0; i < 20; i++) {
            times.add(insertAndCompareFixed(100000, 100000));
        }
        average = calculateAverage(times);
        System.out.printf("\nArrayList (fixed) Average 100000 = %d microssegundos", average[0]);
        System.out.printf("\nLinkedList Average 100000 = %d microssegundos\n", average[1]);

        times.clear();
        for (int i = 0; i < 20; i++) {
            times.add(insertRandomAndCompare(10000));
        }
        average = calculateAverage(times);
        System.out.printf("\nArrayList Random Average 10000 = %d microssegundos", average[0]);
        System.out.printf("\nLinkedList Random Average 10000 = %d microssegundos\n", average[1]);

        times.clear();
        for (int i = 0; i < 20; i++) {
            times.add(removeFirstAndCompare(100000));
        }
        average = calculateAverage(times);
        System.out.printf("\nArrayList Remove First Average 100000 = %d microssegundos", average[0]);
        System.out.printf("\nLinkedList Remove First Average 100000 = %d microssegundos\n", average[1]);

        times.clear();
        for (int i = 0; i < 20; i++) {
            times.add(removeLastAndCompare(100000));
        }
        average = calculateAverage(times);
        System.out.printf("\nArrayList Remove Last Average 100000 = %d microssegundos", average[0]);
        System.out.printf("\nLinkedList Remove Last Average 100000 = %d microssegundos\n", average[1]);

        times.clear();
        for (int i = 0; i < 20; i++) {
            times.add(removeRandomAndCompare(10000));
        }
        average = calculateAverage(times);
        System.out.printf("\nArrayList Remove Random Average 10000 = %d microssegundos", average[0]);
        System.out.printf("\nLinkedList Remove Random Average 10000 = %d microssegundos\n", average[1]);
    }

    private static long[] insertAndCompare(int qty) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Random random = new Random();

        // Inicializando timer;
        long t0 = System.nanoTime();

        // Inserindo 100000 items em uma arrayList e guardando tempo final
        for (int i = 0; i < qty; i++) {
            arrayList.add(random.ints(1,10).findFirst().getAsInt());
        }
        long t1 = System.nanoTime();

        // Inserindo 100000 items em uma linkedList e guardando tempo final
        for (int i = 0; i < qty; i++) {
            linkedList.addLast(random.ints(1,10).findFirst().getAsInt());
        }
        long t2 = System.nanoTime();

        long dt1 = calculateDeltaTime(t0,t1);
        long dt2 = calculateDeltaTime(t1,t2);

        long[] times = new long[2];
        times[0] = dt1;
        times[1] = dt2;

        return times;
    }

    private static long[] insertAndCompareFixed(int fixedSize, int qty) {
        ArrayList<Integer> arrayList = new ArrayList<>(fixedSize);
        LinkedList<Integer> linkedList = new LinkedList<>();
        Random random = new Random();

        // Inicializando timer;
        long t0 = System.nanoTime();

        // Inserindo 100000 items em uma arrayList e guardando tempo final
        for (int i = 0; i < qty; i++) {
            arrayList.add(random.ints(1,10).findFirst().getAsInt());
        }
        long t1 = System.nanoTime();

        // Inserindo 100000 items em uma linkedList e guardando tempo final
        for (int i = 0; i < qty; i++) {
            linkedList.addLast(random.ints(1,10).findFirst().getAsInt());
        }
        long t2 = System.nanoTime();

        long dt1 = calculateDeltaTime(t0,t1);
        long dt2 = calculateDeltaTime(t1,t2);

        long[] times = new long[2];
        times[0] = dt1;
        times[1] = dt2;

        return times;
    }

    private static long[] insertRandomAndCompare(int qty) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Random random = new Random();


        // Inicializando timer;
        long t0 = System.nanoTime();

        // Inserindo 100000 items em uma arrayList e guardando tempo final
        for (int i = 0; i < qty; i++) {
            int number = random.nextInt(100);
            int position = arrayList.isEmpty() ? 0 : random.nextInt(arrayList.size() + 1);
            arrayList.add(position, number);
        }
        long t1 = System.nanoTime();

        // Inserindo 100000 items em uma linkedList e guardando tempo final
        for (int i = 0; i < qty; i++) {
            int number = random.nextInt(100);
            int position = linkedList.isEmpty() ? 0 : random.nextInt(linkedList.size() + 1);
            linkedList.add(position, number);
        }
        long t2 = System.nanoTime();

        long dt1 = calculateDeltaTime(t0,t1);
        long dt2 = calculateDeltaTime(t1,t2);

        long[] times = new long[2];
        times[0] = dt1;
        times[1] = dt2;

        return times;
    }

    private static long[] removeFirstAndCompare(int qty) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Random random = new Random();

        for (int i = 0; i < qty; i++) {
            int number = random.nextInt(100);
            arrayList.add(number);
        }
        for (int i = 0; i < qty; i++) {
            int number = random.nextInt(100);
            linkedList.add(number);
        }

        long t0 = System.nanoTime();
        while (!arrayList.isEmpty()) {
            arrayList.remove(0);
        }
        long t1 = System.nanoTime();

        while (!linkedList.isEmpty()) {
            linkedList.removeFirst();
        }
        long t2 = System.nanoTime();

        long dt1 = calculateDeltaTime(t0,t1);
        long dt2 = calculateDeltaTime(t1,t2);

        long[] times = new long[2];
        times[0] = dt1;
        times[1] = dt2;

        return times;
    }

    private static long[] removeLastAndCompare(int qty) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Random random = new Random();

        for (int i = 0; i < qty; i++) {
            int number = random.nextInt(100);
            arrayList.add(number);
        }
        for (int i = 0; i < qty; i++) {
            int number = random.nextInt(100);
            linkedList.add(number);
        }

        long t0 = System.nanoTime();
        while (!arrayList.isEmpty()) {
            arrayList.remove(arrayList.size() - 1);
        }
        long t1 = System.nanoTime();

        while (!linkedList.isEmpty()) {
            linkedList.removeLast();
        }
        long t2 = System.nanoTime();

        long dt1 = calculateDeltaTime(t0,t1);
        long dt2 = calculateDeltaTime(t1,t2);

        long[] times = new long[2];
        times[0] = dt1;
        times[1] = dt2;

        return times;
    }

    private static long[] removeRandomAndCompare(int qty) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Random random = new Random();

        for (int i = 0; i < qty; i++) {
            int number = random.nextInt(100);
            arrayList.add(number);
        }
        for (int i = 0; i < qty; i++) {
            int number = random.nextInt(100);
            linkedList.add(number);
        }

        long t0 = System.nanoTime();
        while (!arrayList.isEmpty()) {
            arrayList.remove(random.nextInt(arrayList.size()));
        }
        long t1 = System.nanoTime();

        while (!linkedList.isEmpty()) {
            linkedList.remove(random.nextInt(linkedList.size()));
        }
        long t2 = System.nanoTime();

        long dt1 = calculateDeltaTime(t0,t1);
        long dt2 = calculateDeltaTime(t1,t2);

        long[] times = new long[2];
        times[0] = dt1;
        times[1] = dt2;

        return times;
    }

    private static long calculateDeltaTime(long time1, long time2) {
        return (time2 - time1) / 1000L;
    }

    private static long[] calculateAverage(ArrayList<long[]> times) {
        long[] averages = new long[2];

        for (long[] time : times) {
            averages[0] += time[0];
            averages[1] += time[1];
        }

        averages[0] /= times.size();
        averages[1] /= times.size();

        return averages;
    }
}