package ModelClasses.Requirement;

import ModelClasses.MyDate;
import ModelClasses.Status;
import ModelClasses.Task;

import java.util.ArrayList;

public class UserStory extends Requirement
{

    //Should type be final?
    private final String type;
    private double timeSpent;
    //Sums the estimates of all the tasks
    private double estimate;
    private Priority priority;
    //ArrayList of tasks seems to make more sense
    private ArrayList<Task> requirementTasks;
    //Deadline as an instance variable of a sub class, not super class
    private MyDate deadline;

    public UserStory(String requirementId, String description, MyDate deadline)
    {
        super(requirementId, description);
        this.type = "User Story";
        this.timeSpent = 0;
        this.estimate = 0;
        this.priority = Priority.UNDEFINED;
        this.requirementTasks = new ArrayList<>();
        this.deadline = deadline;
    }

    public String getType()
    {
        return type;
    }

    public double getTimeSpent()
    {
        return timeSpent;
    }

    public double calculateEstimate()
    {
        double hours = 0;
        for (int i = 0; i < requirementTasks.size(); i++)
        {
            hours += requirementTasks.get(i).getEstimate();
        }
        return hours;
    }

    public String getPriority()
    {
        return priority.getPriorityString();
    }

    public ArrayList<Task> getRequirementTasks()
    {
        return requirementTasks;
    }

    public MyDate getDeadline()
    {
        return deadline;
    }

    public void updateTimeSpent(double timeSpent)
    {
        this.timeSpent = timeSpent;
    }

    public void changePriority(Priority priority)
    {
        this.priority = priority;
    }

    public void createNewTask(String taskId, String description, double estimate)
    {
        int i=1;
        do
        {
            Task task = new Task(taskId, description, estimate, this);
            try
            {
                if(task.isValidTaskId(taskId, this))
                {
                    requirementTasks.add(task);
                    i=0;
                }
            }
            catch (IllegalArgumentException e)
            {
                e=new IllegalArgumentException("This task ID is taken. Please enter an ID that is unique within the requirement.");
                throw(e);
            }

        }
        while(i!=0);
        this.estimate=calculateEstimate();
    }

    public void assignTask(Task task)
    {
        requirementTasks.add(task);
    }

    public void removeTask(Task task)
    {
        requirementTasks.remove(task);
    }

    public void changeDeadline(MyDate deadline)
    {
        this.deadline=deadline;
    }

    //if all the tasks have status "Ended", the requirement automatically becomes "Ended"
    public void completionCheck()
    {
        int counter=0;
        for (int i=0;i<requirementTasks.size();i++)
        {
            if (requirementTasks.get(i).getStatus().equals(Status.ENDED.getStatusString()))
            {
                counter++;
            }
        }
        if (counter==requirementTasks.size()-1)
        {
            changeStatus(Status.ENDED);
        }
    }


    public boolean equals(Object banana) {
        if(!(banana instanceof UserStory))
            return false;
        UserStory temp = (UserStory) banana;
        return(temp.deadline.equals(deadline) && temp.priority.equals(priority) && temp.timeSpent == timeSpent && temp.type.equals(type) && temp.estimate == estimate && temp.requirementTasks.equals(requirementTasks));

    }

    public String toString()
    {
        return "UserStory{" + "type='" + type + '\'' + ", timeSpent="
            + timeSpent + ", estimate=" + estimate + ", priority=" + priority
            + ", requirementTasks=" + requirementTasks + ", deadline="
            + deadline + '}';
    }
}
