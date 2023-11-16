package lang.threads;

public class Resource {
    private int data;

    public int getData() {
        return data;
    }

    public synchronized void setData(int data) {
        this.data = data;
    }

    public void increment() {
        synchronized (this) {
            int newData = data;
            if (Thread.currentThread().getName().equals("Thread-B")) {
                // Give execution to another threads
                Thread.yield();
            }
            newData++;
            data = newData;
        }
        System.out.println(data);
    }
}
