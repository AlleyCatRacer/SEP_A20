package ModelClasses;

import ModelClasses.Requirement.UserStory;

import java.util.ArrayList;
import java.util.IllegalFormatWidthException;

/**
 * A class of Task objects.
 *
 * @author Allie, Lili, Luke & Yoana
 * @version 1.0 - 14.12.20
 */
public class Task
{
    private final String taskId;
    private String description;
    private double estimate;
    private double timeSpent;
    private String status;
    private String requirementId;

    /**
     * Four-argument constructor. 'timeSpent' field is set to zero and 'status' is set to 'Waiting'.
     *
     * @param taskId
     *         Needs to be a unique a permutation of no more than 24 letters and/or numbers.
     * @param description
     *         Needs to be unique ID consisting of a combination of no less than 2 letters and/or numbers.
     * @param estimate
     *         Needs to consist of a combination of no more than 24 letters and/or numbers.
     * @param requirementId
     *         The day needs to be greater than zero and does not exceeds the referenced month's number of days, the
     *         month needs to be greater than zero and less than 12 and the year needs to be greater than zero and
     *         lesser than the current year.
     */
    public Task(String taskId, String description, double estimate, String requirementId)
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
        if (!taskId.matches("[a-zA-Z0-9]*"))
        {
            IllegalArgumentException e = new IllegalArgumentException("Please enter an ID containing 2 or more letters and/or numbers that is unique within the project");
            throw e;
        }
        else if (taskId.length() > 25)
        {
            throw new IllegalFormatWidthException(taskId.length());
        }
        else
        {
            return true;
        }
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
