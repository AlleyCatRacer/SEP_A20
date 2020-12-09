package ModelClassess;

public class Task {
    private String taskId;
    private String description;
    private Estimate estimate;
    private TimeSpent timeSpent;
    private Status status;

    public Task(String taskId, String description, Estimate  estimate)
    {
        this.taskId  = taskId;
        this.description = description;
        this.estimate = estimate;
        timeSpent = null;
        status = Status.Waiting;
    }

    public void changeDescription(String description) {
        this.description = description;
    }

    public void changeStatus(Status status) {
        this.status = status;
    }

    public void changeEstimate(Estimate estimate) {
        this.estimate = estimate;
    }

    public void changeTimeSpent(TimeSpent timeSpent) {
        this.timeSpent = timeSpent;
    }

    public Estimate getEstimate() {
        return estimate;
    }

    public Status getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public String getTaskId() {
        return taskId;
    }

    public TimeSpent getTimeSpent() {
        return timeSpent;
    }
    public boolean isValidTaskId(String taskId)
    {
        return this.taskId.equals(taskId);
    }
}
