import java.util.concurrent.*;

public class TaskSchedulerApp {
    private ScheduledExecutorService scheduler;

    public void start() {
        scheduler = Executors.newScheduledThreadPool(4);  // Create a thread pool with 4 threads
        System.out.println("Task Scheduler started");
    }

    public void scheduleTask(Runnable task, long interval) {
        // Schedule the task to run repeatedly at the specified interval
        scheduler.scheduleAtFixedRate(task, 0, interval, TimeUnit.SECONDS);
    }

    public void stop() {
        try {
            scheduler.shutdown();  // Stop accepting new tasks
            if (!scheduler.awaitTermination(60, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();  // Force shutdown if tasks don't complete in time
            }
        } catch (InterruptedException e) {
            scheduler.shutdownNow();  // Force shutdown in case of interruption
            Thread.currentThread().interrupt();
        }
        System.out.println("Task Scheduler stopped");
    }
}
