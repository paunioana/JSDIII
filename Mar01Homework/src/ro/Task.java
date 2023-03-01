import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Task {
    private String taskName;
    private Integer taskId;
    private Integer executionTime;
    private static int numberOfTasks = 0;
    private static int id = -1;

    public Task(String taskName, Integer executionTime) {
        this.taskName = taskName;
        this.executionTime = executionTime;
        this.taskId = Task.generateId();
    }
    private static int generateId() {
        id++;
        return id;
    }

    public void run() throws InterruptedException {
        TimeUnit.SECONDS.sleep(this.executionTime);
    }
}
