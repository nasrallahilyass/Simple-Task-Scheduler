import java.util.concurrent.*;

public class TaskSchedulerApp {
    private ScheduledExecutorService scheduler;

    /*
        Initialize the scheduled executor service.
        1. Start () : This method initializes the ScheduledExecutorService with a thread pool of 4 threads.
        2. scheduleTask (Runnable task, long interval) : This method schedules a task to run repeatedly at the specified interval.
        3. stop () : This method stops the ScheduledExecutorService by shutting it down and waiting for 60 seconds for the tasks to complete. If the tasks don't complete in time, it forces a shutdown.

     */

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
