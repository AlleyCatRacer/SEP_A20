package ModelClasses.Requirement;

import ModelClasses.MyDate;

public class ProjectRelated extends Requirement
{

    //Should type be final?
    private final String type;
    private double timeSpent;
    private double estimate;
    private Priority priority;
    //Deadline as an instance variable of a sub class, not super class
    private MyDate deadline;

    public ProjectRelated(String requirementId, String description, MyDate deadline)
    {
        super(requirementId, description);
        this.type = "Project Related";
        this.priority = Priority.UNDEFINED;
        this.deadline = deadline;
        this.timeSpent = 0;
        this.estimate = 0;
    }

    public String getType()
    {
        return type;
    }

    public double getTimeSpent()
    {
        return timeSpent;
    }
    public double getEstimate() {
        return estimate;
    }
    //May be used later to access super class instance variables for equals method
//    public String getRequirementID() {
//        return super.getRequirementId();
//    }

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
    public void setEstimate(double estimate) {
        if(estimate < 0)
            throw new IllegalArgumentException("Estimate has to be greater than 0 hours");
        this.estimate = estimate;
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

    public boolean equals(Object banana) {
        if(!(banana instanceof ProjectRelated))
            return false;
        ProjectRelated temp = (ProjectRelated) banana;
        return(temp.deadline.equals(deadline) && temp.priority.equals(priority) && temp.timeSpent == timeSpent && temp.type.equals(type) && temp.getStatus().equals(getStatus()) && temp.getRequirementId().equals(getRequirementId()) && temp.getDescription().equals(getDescription()) && temp.getResponsibleTeamMember().equals(getResponsibleTeamMember()));
    }

    @Override public String toString()
    {
        return "ProjectRelated{" + "type='" + type + '\'' + ", timeSpent="
            + timeSpent + ", priority=" + priority + ", deadline=" + deadline
            + '}';
    }
}
