package ModelClasses.Requirement;

import ModelClasses.MyDate;

public class ProjectRelated extends Requirement
{

    //Should type be final?
    private final String type;
    private double timeSpent;
    private String priority;
    //Deadline as an instance variable of a sub class, not super class
    private MyDate deadline;

    public ProjectRelated(String REQUIREMENTID, String description, double timeSpent, String priority, MyDate deadline)
    {
        super(REQUIREMENTID, description);
        this.type = "Project Related";
        this.priority = priority;
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
        return priority;
    }

    public MyDate getDeadline()
    {
        return deadline;
    }

    //Depending on implementation the parameter's data type might change to double
    public void updateTimeSpent(double timeSpent)
    {
        this.timeSpent = timeSpent;
    }

    //Do we want to have an enum for priority?
    public void changePriority(String priority)
    {
        this.priority = priority;
    }

    public void changeDeadline(MyDate deadline)
    {
        this.deadline = deadline;
    }

    public boolean isLegalDeadline(MyDate deadline)
    {

    }

    public boolean equals(Object banana)
    {

    }

    public String toString()
    {

    }

}
