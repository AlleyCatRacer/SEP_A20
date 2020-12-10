package ModelClasses.Requirement;

import ModelClasses.MyDate;

public class ProjectRelated extends Requirement
{

    //Should type be final?
    private final String type;
    private double timeSpent;
    private Priority priority;
    //Deadline as an instance variable of a sub class, not super class
    private MyDate deadline;

    public ProjectRelated(String requirementId, String description, MyDate deadline)
    {
        super(requirementId, description);
        this.type = "Project Related";
        this.priority = Priority.UNDEFINED;
        this.deadline = deadline;
        this.timeSpent = getTimeSpent();
    }

    public String getType()
    {
        return type;
    }

    public double getTimeSpent()
    {
        return timeSpent;
    }

    public String getPriority()
    {
        return priority.getPriorityString();
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

    public void changeDeadline(MyDate deadline)
    {
        if (deadline.isValidDate(deadline))
        {
            this.deadline = deadline;
        }
        else
        {
            throw new IllegalArgumentException("Please enter a valid date");
        }
    }

 /*   public boolean equals(Object banana)
    {

    }

    public String toString()
    {

    }*/

}
