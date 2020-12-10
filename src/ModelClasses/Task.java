package ModelClasses;

import ModelClasses.Requirement.UserStory;

import java.util.ArrayList;

public class Task
{
    private final String taskId;
    private String description;
    private double estimate;
    private double timeSpent;
    private Status status;
    private ArrayList<UserStory> belongsToRequirement;

    public Task(String taskId, String description, double estimate,UserStory requirement)
    {
        this.taskId = taskId;
        this.description = description;
        this.estimate = estimate;
        timeSpent = 0;
        status = Status.WAITING;
        this.belongsToRequirement = new ArrayList<>();
        this.assignToRequirement(requirement);
    }

    public void changeDescription(String description)
    {
        this.description = description;
    }

    public void changeStatus(Status status)
    {
        if(status.getStatusString().equals(Status.ENDED.getStatusString()) )
        {
            for (int i = 0; i< belongsToRequirement.size(); i++)
            {
                belongsToRequirement.get(i).completionCheck();
            }
        }
        this.status = status;
    }

    public void changeEstimate(double estimate)
    {
        this.estimate = estimate;
    }

    public boolean isValidTime(double hours)
    {
        return (hours%0.5==0);
    }

    public void logHours(double timeSpent)
    {
        if (isValidTime(timeSpent))
        {
            this.timeSpent += timeSpent;
        }
        //exception
    }

    public double getEstimate()
    {
        return estimate;
    }

    public String getStatus()
    {
        return status.getStatusString();
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

    public boolean isValidTaskId(String taskId, UserStory requirement)
    {
        int bin=0;
        for(int i=0; i<requirement.getRequirementTasks().size();i++)
        {
            if (requirement.getRequirementTasks().get(i).getTaskId().equalsIgnoreCase(taskId))
            {
                bin+=1;
                break;
            }
        }
        return (bin==0);
    }

    public void assignTaskToTeamMember(TeamMember teamMember)
    {
        teamMember.assignTaskToTeamMember(this);
    }

    public void assignToRequirement(UserStory requirement)
    {
        belongsToRequirement.add(requirement);
    }
}
