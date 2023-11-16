package lang.threads;

public class StaticResource {
    public static int i;

    public static void increment() {
        synchronized (StaticResource.class) {
            int newData = i;
            if (Thread.currentThread().getName().equals("Thread-B")) {
                // Give execution to another threads
                Thread.yield();
            }
            newData++;
            i = newData;
        }
        System.out.println(i);
    }
}
