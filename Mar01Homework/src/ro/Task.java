package ro;

import org.springframework.beans.factory.DisposableBean;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Task {
    private String taskName;
    private Integer taskId;
    private Integer executionTime;
    public static int numberOfTasks = 0;
    private static int id = -1;

    private static int generateId() {
        id++;
        return id;
    }

    public void run() throws InterruptedException {
        System.out.println(this.taskName + ": I'm going to sleep now for " + this.executionTime + " seconds...");
        TimeUnit.SECONDS.sleep(this.executionTime);
    }
    private void performInit() {
        numberOfTasks++;
        System.out.println("Current number of instances: " + Task.numberOfTasks);
        this.taskId = generateId();
        this.taskName = "Task"+ this.taskId;
        this.executionTime = ThreadLocalRandom.current().nextInt(1, 21);
    }

    public void performDestroy() throws Exception {
        System.out.println(this.taskName + " was destroyed!");
        numberOfTasks--;
    }

}
