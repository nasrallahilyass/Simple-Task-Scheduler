public class Main {
    public static void main(String[] args) {
        TaskSchedulerApp scheduler = new TaskSchedulerApp();
        scheduler.start();  // Start the scheduler

        // Create a task that prints a message every 5 seconds
        Task task = new Task("Print Hello");
        scheduler.scheduleTask(task, 5);  // Run the task every 5 seconds

        // After some time, stop the scheduler (optional)
        try {
            Thread.sleep(20000);  // Run the scheduler for 20 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.stop();  // Stop the scheduler after 20 seconds
    }
}
