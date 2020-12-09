package ModelClasses;

public class Task
{
    private String taskId;
    private String description;
    private double estimate;
    private double timeSpent;
    private Status status;

    public Task(String taskId, String description, double estimate)
    {
        this.taskId = taskId;
        this.description = description;
        this.estimate = estimate;
        timeSpent = 0;
        status = Status.WAITING;
    }

    public void changeDescription(String description)
    {
        this.description = description;
    }

    public void changeStatus(Status status)
    {
        this.status = status;
    }

    public void changeEstimate(double estimate)
    {
        this.estimate = estimate;
    }

    public void logHours(double timeSpent)
    {
        this.timeSpent += timeSpent;
    }

    public double getEstimate()
    {
        return estimate;
    }

    public Status getStatus()
    {
        return status;
    }

    public String getDescription()
    {
        return description;
    }

    public String getTaskId()
    {
        return taskId;
    }

    public double getTimeSpent()
    {
        return timeSpent;
    }

    public boolean isValidTaskId(String taskId)
    {
        return this.taskId.equals(taskId);
    }
}
