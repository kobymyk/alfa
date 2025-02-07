package lang.threads;

public class NewThread extends Thread {
    private Resource resource;

    public NewThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        resource.increment();
    }
}
