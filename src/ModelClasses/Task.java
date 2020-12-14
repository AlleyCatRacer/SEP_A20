package ModelClasses;

import ModelClasses.Requirement.UserStory;

import java.util.ArrayList;

public class Task
{
    private final String taskId;
    private String description;
    private double estimate;
    private double timeSpent;
    private String status;
    private String requirementId;

    public Task(String taskId, String description, double estimate,String requirementId)
    {
        this.taskId = taskId;
        this.description = description;
        this.estimate = estimate;
        timeSpent = 0;
        status = Status.WAITING.getStatusString();
        this.requirementId = requirementId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTimeSpent(double timeSpent) {
        this.timeSpent = timeSpent;
    }

    public void changeDescription(String description)
    {
        this.description = description;
    }

   /* public void changeStatus(Status status)
    {
        if(status.getStatusString().equals(Status.ENDED.getStatusString()) )
        {
            for (int i = 0; i< belongsToRequirement.size(); i++)
            {
                belongsToRequirement.get(i).completionCheck();
            }
        }
        this.status = status;
    }*/

    /*public void changeEstimate(double estimate)
    {
        this.estimate = estimate;
        for(int i = 0; i < belongsToRequirement.size(); i++) {
            belongsToRequirement.get(i).calculateEstimate();
        }

    }*/

    public boolean isValidTime(double hours)
    {
        return (hours%0.5==0 && hours > 0);
    }

    public void logHours(double timeSpent)
    {
        if (isValidTime(timeSpent))
        {
            this.timeSpent += timeSpent;
            /*for(int i = 0; i < belongsToRequirement.size(); i++) {
                belongsToRequirement.get(i).calculateTimeSpent();
            }*/
        }
        else
        throw new IllegalArgumentException("Invalid amount of hours");
    }

    public double getEstimate()
    {
        return estimate;
    }

    public String getStatus()
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

    public void assignToRequirement(String requirementId)
    {
        this.requirementId = requirementId;
    }
  /*  public String getRequirementsIDsToWhichTheTaskBelongs() {
        String ids = "";
        for(int i = 0; i < belongsToRequirement.size(); i++) {
            ids += belongsToRequirement.get(i).getRequirementId();
            if(belongsToRequirement.size() > 1)
                ids += ", ";
        }
        return ids;
    }*/

    public String toString()
    {
        return taskId + "-" + description + "-" + estimate + "-" + timeSpent;
       /* return "Task{" + "taskId='" + taskId + '\'' + ", description='"
            + description + '\'' + ", estimate=" + estimate + ", timeSpent="
            + timeSpent + ", status=" + getStatus() + ", belongs to these requirements: " + getRequirementsIDsToWhichTheTaskBelongs();*/
    }
}
