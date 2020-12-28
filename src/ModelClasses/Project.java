package ModelClasses;

import ModelClasses.Requirement.NonFunctional;
import ModelClasses.Requirement.ProjectRelated;
import ModelClasses.Requirement.Requirement;
import ModelClasses.Requirement.UserStory;

import java.util.ArrayList;
import java.util.IllegalFormatWidthException;

/**
 * A class of Project objects.
 *
 * @author Group 1
 * @version 1.0 - 14.12.20
 */
public class Project
{
    private String title;
    private final String customerId;
    private final String projectId;
    private MyDate deadline;
    private String comment;
    private double timeSpent;
    private double estimate;
    private String currentStatus;
    private ArrayList<Requirement> requirements;
    private ArrayList<TeamMember> projectTeam;
    private String description;

    /**
     * Five-argument constructor. 'timeSpent' field is set to zero, 'status' is set to 'Waiting', a new ArrayList of
     * TeamMember objects and a new ArrayList of Requirement subclass objects is created for the project.
     *
     * @param title
     *         Needs to consist of a combination of no more than 24 letters and/or numbers
     * @param projectId
     *         Needs to be unique ID consisting of a combination of no less than 2 letters and/or numbers
     * @param customerId
     *         Needs to consist of a combination of no more than 24 letters and/or numbers
     * @param deadline
     *         The day needs to be greater than zero and does not exceeds the referenced month's number of days, the
     *         month needs to be greater than zero and less than 12 and the year needs to be greater than zero and
     *         lesser than the current year.
     * @param comment
     *         Needs to consist of less than 250 letters
     * @throws IllegalArgumentException
     *         If the given title consists of a combination of more than 24 characters or contains other characters
     *         than letters and/or numbers
     *         If the given project ID consists of a combination of less than 2 or more than 7 characters or contains
     *         other characters than letters and/or numbers
     *         If the given customer ID consists of a combination of more than 7 characters or contains other
     *         characters than letters and/or numbers
     *         If MyDate object's day field isn't greater than zero or exceeds the referenced month's number of days
     *         If MyDate object's month field isn't greater than zero or exceeds 12
     *         If MyDate object's year field isn't greater than zero or is lesser than the current year
     *         If the comment consist of more than 249 characters or contains other than letters and/or numbers
     */
    public Project(String title, String projectId, String customerId, MyDate deadline, String comment)
    {
        requirements = new ArrayList<>();
        isValidTitle(title);
        this.title = title;
        isValidProjectId(projectId);
        this.projectId = projectId;

        isValidCustomerId(customerId);
        this.customerId = customerId;

        this.deadline = deadline;

        isValidComment(comment);
        this.comment = comment;
        this.timeSpent = 0;
        this.estimate = 0;
        this.currentStatus = Status.WAITING.getStatusString();
        projectTeam = new ArrayList<>();
        this.description = "";
    }

    /**
     * Getting an ArrayList of Requirement subclass objects belonging to the project.
     *
     * @return ArrayList of project's requirements.
     */
    public ArrayList<Requirement> getRequirements()
    {
        return requirements;
    }

    /**
     * Getting project's title.
     *
     * @return String of the project's title.
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Getting project's ID.
     *
     * @return String of the project's ID.
     */
    public String getProjectId()
    {
        return projectId;
    }

    /**
     * Getting the ID assigned to the customer who commissioned the project.
     *
     * @return String of the customer's ID.
     */
    public String getCustomerId()
    {
        return customerId;
    }

    /**
     * Getting project's deadline.
     *
     * @return MyDate object of the project's deadline.
     */
    public MyDate getDeadline()
    {
        return deadline;
    }

    /**
     * Getting project's comment.
     *
     * @return String of the project's comment.
     */
    public String getComment()
    {
        return comment;
    }

    /**
     * Getting the time spent on the project.
     *
     * @return Double of the hours spent on the project.
     */
    public double getTimeSpent()
    {
        return timeSpent;
    }
    public double getEstimate() {
        return estimate;
    }

    /**
     * Getting project's status.
     *
     * @return Status enum of the project's status.
     */
    public String getCurrentStatus()
    {
        return currentStatus;
    }

    /**
     * Getting team members assigned to the project.
     *
     * @return ArrayList of the project's TeamMember objects.
     */
    public ArrayList<TeamMember> getMembersOfTheProject()
    {
        return projectTeam;
    }
    public String getDescription() {
        return description;
    }


    //This piece of a joy will not see daylight unless it starts behaving
//     /**
//     * Getting a project's requirement by ID.
//     *
//     * @param requirementID
//     *        String of the requirement's ID
//     *
//     * @return Requirement subclass object.
//     */
  /*public Requirement getRequirementByID(String requirementID) {
    for(int i = 0; i < requirements.size(); i++) {
      if(requirements.get(i).getRequirementId().equals(requirementID)) {
        if(requirements.get(i) instanceof UserStory)
        {
         return (UserStory) requirements.get(i);
        }else if (requirements.get(i) instanceof ProjectRelated)
        {
          getProjectRelatedRequirement(i);
          return null;
        }else if (requirements.get(i) instanceof NonFunctional)
        {
          getNonFunctionalRequirement(i);
          return null;
        }
      }
    }
    return null;
  }

  public UserStory getUserStoryRequirement(int index) {
    return (UserStory) requirements.get(index);
  }
  public ProjectRelated getProjectRelatedRequirement(int index) {
    return (ProjectRelated) requirements.get(index);
  }
  public NonFunctional getNonFunctionalRequirement(int index) {
    return (NonFunctional) requirements.get(index);
  }
*/

    /**
     * Getting a project related requirement by ID.
     *
     * @param requirementID
     *         String of the requirement's ID
     * @return ProjectRelated object.
     * @throws IllegalArgumentException
     *         If no project related requirement with the given ID was found
     */
    public ProjectRelated getProjectRelatedRequirementByID(String requirementID)
    {
        for (Requirement requirement : requirements)
        {
            if (requirement.getRequirementId().equals(requirementID))
                return (ProjectRelated) requirement;
        }
        throw new IllegalArgumentException("The Project Related requirement with such ID was not found");
    }

    /**
     * Getting a user story requirement by ID.
     *
     * @param requirementID
     *         String of the requirement's ID
     * @return UserStory object.
     * @throws IllegalArgumentException
     *         If no user story requirement with the given ID was found
     */
    public UserStory getUserStoryRequirementByID(String requirementID)
    {
        for (Requirement requirement : requirements)
        {
            if (requirement.getRequirementId().equalsIgnoreCase(requirementID))
                return (UserStory) requirement;
        }
        throw new IllegalArgumentException("The User Story requirement with such ID was not found");
    }

    /**
     * Getting a non-functional requirement by ID.
     *
     * @param requirementID
     *         String of the requirement's ID
     * @return NonFunctional object.
     * @throws IllegalArgumentException
     *         If no non-functional requirement with the given ID was found.
     */
    public NonFunctional getNonFunctionalRequirementByID(String requirementID)
    {
        for (Requirement requirement : requirements)
        {
            if (requirement.getRequirementId().equals(requirementID))
                return (NonFunctional) requirement;
        }
        throw new IllegalArgumentException("The Non Functional requirement with such ID was not found");
    }

    /**
     * Adding a TeamMember object to the project's team by the team member's ID.
     *
     * @param memberID
     *         String of the team member's ID
     * @throws IllegalArgumentException
     *         If a team member with the given ID is already assigned to the project.
     */
    public void addTeamMemberToTheProject(String memberID)
    {
        for (int i = 0; i < Team.getTheRoster().size(); i++)
        {
            if (Team.getTheRoster().get(i).getTeamMemberId().equals(memberID))
            {
                if (!(isIDUniqueWithinTheProject(memberID)))
                {
                    throw new IllegalArgumentException(
                            "A team member with such ID already exists in the project");
                }
                else
                    projectTeam.add(Team.getTheRoster().get(i));
            }

        }
    }

    /**
     * Boolean check searching the project's team by ID.
     *
     * @param memberID
     *         String of the team member's ID
     * @return 'false' if a team member with the given ID is already assigned to the project, 'true' if not.
     */
    public boolean isIDUniqueWithinTheProject(String memberID)
    {
        for (int i = 0; i < projectTeam.size(); i++)
        {
            if (projectTeam.get(i).getTeamMemberId().equals(memberID))
                return false;
        }
        return true;
    }

    /**
     * Finding a team member by ID and changing their role.
     *
     * @param teamMemberId
     *         String of the team member's ID
     * @param role
     *         Role enum constant
     * @throws IllegalArgumentException
     *         If a team member with the given ID is not assigned to the project or another team member in the project's
     *         team has already been assigned the team exclusive role given
     */
    public void editProjectMemberRole(String teamMemberId, Role role)
    {
        int count = 0;
        if (role.equals(Role.TEAM_MEMBER))
        {
            for (int i = 0; i < projectTeam.size(); i++)
            {
                if (projectTeam.get(i).getTeamMemberId().equals(teamMemberId))
                {
                    count++;
                    projectTeam.get(i).setRole(role.getRoleString());
                }
            }
            if (count == 0)
                throw new IllegalArgumentException("Person with such ID was not found within this project");
        }
        else
        {
            for (int i = 0; i < projectTeam.size(); i++)
            {
                if (projectTeam.get(i).getRole().equals(role.getRoleString()))
                    throw new IllegalArgumentException("There is a " + role + " already assigned to this project");
            }
            for (int i = 0; i < projectTeam.size(); i++)
            {
                if (projectTeam.get(i).getTeamMemberId().equals(teamMemberId))
                {
                    count++;
                    projectTeam.get(i).setRole(role.getRoleString());
                }
            }
            if (count == 0)
                throw new IllegalArgumentException("Person with such ID was not found within this project");
        }
    }

    /**
     * Removing a team member from the project's team by their ID.
     *
     * @param teamMemberId
     *         String of the team member's ID
     * @throws IllegalArgumentException
     *         If a team member with the given ID is not assigned to the project
     */
    public void removeProjectTeamMember(String teamMemberId)
    {
        boolean doesExist = false;
        for (int i = 0; i < projectTeam.size(); i++)
        {
            if (projectTeam.get(i).getTeamMemberId().equals(teamMemberId))
            {
                doesExist = true;
                projectTeam.remove(i);
            }
        }
        if (!doesExist) throw new IllegalArgumentException();
    }

    /**
     * Getting a team member from the project's team by their ID.
     *
     * @param memberID
     *         String of the team member's ID
     * @return TeamMember object
     * @throws IllegalArgumentException
     *         If a team member with the given ID is not assigned to the project
     */
    public TeamMember getProjectTeamMemberByID(String memberID)
    {
        for (TeamMember teamMember : projectTeam)
        {
            if (teamMember.getTeamMemberId().equalsIgnoreCase(memberID))
                return teamMember;
        }
        throw new IllegalArgumentException("A team member with such ID was not found in this project");
    }

    /**
     * Changing a project's title.
     *
     * @param title
     *         String of the new project title
     * @throws IllegalArgumentException
     *         If the given title is longer than 24 characters or consist of more than letters and/or numbers
     */
    public void changeTitle(String title)
    {
        this.title = title;
    }

    /**
     * Changing a project's deadline.
     *
     * @param deadline
     *         MyDate object of the project's new deadline
     * @throws IllegalArgumentException
     *         If the object's day isn't greater than zero or exceeds the referenced month's number of days. If the
     *         object's month isn't greater than zero or exceeds 12. If the object's year isn't greater than zero or is
     *         lesser than the current year.
     */
        public void setDeadline(MyDate deadline)
    {
        this.deadline = deadline;
    }

    /**
     * Changing a project's comment.
     *
     * @param comment
     *         String of the new project comment
     * @throws IllegalArgumentException
     *         If the given title is longer than 249 characters or consist of more than letters and/or numbers
     */
    public void editComment(String comment)
    {
        this.comment = comment;
    }

    /**
     * Changing a project's status to the given Status enum's String value.
     *
     * @param status
     *         Status enum constant
     */
    public void editStatus(String status)
    {
        this.currentStatus = status;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void calculateEstimate() {
        double sum = 0;
        for(Requirement requirement : requirements) {
            if(requirement instanceof UserStory)
                sum += ((UserStory) requirement).calculateEstimate();
            if(requirement instanceof ProjectRelated)
                sum += ((ProjectRelated) requirement).getEstimate();
        }
        this.estimate = sum;
    }
    public void calculateTimeSpent() {
        double sum = 0;
        for(Requirement requirement : requirements) {
            if(requirement instanceof UserStory)
                sum += ((UserStory) requirement).calculateTimeSpent();
            if(requirement instanceof ProjectRelated)
                sum += ((ProjectRelated) requirement).getTimeSpent();
        }
        this.timeSpent = sum;
    }

    /**
     * Removing a requirement by it's ID.
     *
     * @param requirementId
     *         String of requirement's ID
     * @throws IllegalArgumentException
     *         If no requirement with the given title was found within the project
     */
    public void removeRequirement(String requirementId)
    {
        for (int i = 0; i < requirements.size(); i++)
        {
            if (requirements.get(i).getRequirementId().equals(requirementId))
            {
                requirements.remove(i);
            }
            else
            {
                throw new IllegalArgumentException("No requirement with the given ID was found");
            }
        }
    }

    /**
     * Boolean checking if the given task ID has already been used within the project
     *
     * @param taskID
     *         String of task's ID
     * @return 'true' if the task ID is not already assigned in the project, 'false' if it has.
     */
    public boolean isUniqueTaskIdWithinTheProject(String taskID)
    {
        for (int i = 0; i < requirements.size(); i++)
        {
            if (requirements.get(i) instanceof UserStory)
                for (int k = 0; k < ((UserStory) requirements.get(i)).getRequirementTasks().size(); k++)
                {
                    if (((UserStory) requirements.get(i)).getRequirementTasks().get(k).getTaskId().equalsIgnoreCase(taskID))
                        return false;
                }
        }
        return true;
    }

    //Checks whether the input taskID is valid across the entire project. But I am not sure does it have use because I can't find a way to pass the taskID to it

    /**
     * Adding a non-functional requirement to the project.
     *
     * @param requirementId
     *         String of requirement's ID
     * @param description
     *         String of the requirement's description
     * @throws IllegalArgumentException
     *         If the given requirement ID has already been used or the description string consists of more than 249
     *         letters
     */
    public void addNonFunctional(String requirementId, String description)
    {
        NonFunctional n = new NonFunctional(requirementId, description);
        String id = n.getRequirementId();
        isValidRequirementID(id);
        isValidComment(description);
        requirements.forEach((e) ->
        {
            if (e.getRequirementId().equals(id))
            {
                throw new IllegalArgumentException("The given ID is taken");
            }
        });
        requirements.add(n);
    }

    /**
     * Adding a user story requirement to the project.
     *
     * @param requirementId
     *         String of requirement's ID
     * @param description
     *         String of the requirement's description
     * @param deadline
     *         MyDate object of the requirement's deadline
     * @throws IllegalArgumentException
     *         If the given requirement ID has already been used, the description string consists of more than 249
     *         letters, the deadline's day isn't greater than zero or exceeds the referenced month's number of days, the
     *         deadline's month isn't greater than zero or exceeds 12, if the deadline's year isn't greater than zero or
     *         is lesser than the current year.
     */
    public void addUserStory(String requirementId, String description, MyDate deadline)
    {
        UserStory u = new UserStory(requirementId, description, deadline);
        String id = u.getRequirementId();
        isValidRequirementID(id);
        setDeadline(deadline);
        isValidComment(description);
        requirements.forEach((e) ->
        {
            if (e.getRequirementId().equals(id))
            {
                throw new IllegalArgumentException();
            }
        });
        requirements.add(u);
    }

    /**
     * Adding a project related requirement to the project.
     *
     * @param requirementId
     *         String of requirement's ID
     * @param description
     *         String of the requirement's description
     * @param deadline
     *         MyDate object of the requirement's deadline
     * @throws IllegalArgumentException
     *         If the given requirement ID has already been used, the description string consists of more than 249
     *         letters, the deadline's day isn't greater than zero or exceeds the referenced month's number of days, the
     *         deadline's month isn't greater than zero or exceeds 12, if the deadline's year isn't greater than zero or
     *         is lesser than the current year.
     */
    public void addProjectRelatedRequirement(String requirementId, String description, MyDate deadline)
    {
        ProjectRelated r = new ProjectRelated(requirementId, description, deadline);
        String id = r.getRequirementId();
        isValidRequirementID(id);
        r.getDeadline().isValidDate(r.getDeadline());
        isValidTime(timeSpent);
        isValidComment(description);
        requirements.forEach((e) ->
        {
            if (e.getRequirementId().equals(id))
            {
                throw new IllegalArgumentException("Please enter a requirement ID containing 2 or more letters and/or numbers that is unique withing the project");
            }
        });
        requirements.add(r);
    }

    /**
     * Boolean validity check.
     *
     * @param projectId
     *         Needs to be unique ID consisting of a combination of no less than 2 letters and/or numbers
     * @return 'true' if the string is over 2 characters and no more than 7 characters long and contains only
     * letters and/or numbers
     * @throws IllegalArgumentException
     *         If the given ID consists of a combination of less than 2 or more than 7 characters or contains other
     *         than letters and/or numbers
     */
    public boolean isValidProjectId(String projectId)
    {
        if (!projectId.matches("[a-zA-Z0-9]*"))
        {
            IllegalArgumentException e = new IllegalArgumentException("Please enter a unique project ID containing 2 or more letters and/or numbers");
            throw e;
        }
        else if (projectId.length() > 8 || projectId.length() < 2)
        {
            throw new IllegalFormatWidthException(projectId.length());
        }
        else
        {
            return true;
        }
    }

    /**
     * Boolean validity check.
     *
     * @param title
     *         Needs to consist of a combination of no more than 24 letters and/or numbers
     * @return 'true' if the string is less than 25 characters long and contains only letters and/or numbers
     * @throws IllegalArgumentException
     *         If the given title consists of a combination of more than 24 characters or contains other than letters
     *         and/or numbers
     */
    public boolean isValidTitle(String title)
    {
        if (!title.matches("[a-zA-Z0-9]*"))
        {
            throw new IllegalArgumentException("The title can contain only letters of English alphabet and numbers from 0 to 9. Please try again.");
        }
        else if (title.length() > 25)
        {
            throw new IllegalFormatWidthException(title.length());
        }
        else
        {
            return true;

        }
    }

    /**
     * Boolean validity check.
     *
     * @param customerId
     *         Needs to consist of a combination of no more than 24 letters and/or numbers
     * @return 'true' if the string is over 8 characters and no more than 24 characters long and contains only
     * letters and/or numbers
     * @throws IllegalArgumentException
     *         If the given ID consists of a combination of more than 7 characters or contains other than letters
     *         and/or numbers
     */
    public boolean isValidCustomerId(String customerId)
    {
        if (!customerId.matches("[a-zA-Z0-9]*"))
        {
            throw new IllegalArgumentException();
        }
        else if (customerId.length() > 8)
        {
            throw new IllegalFormatWidthException(customerId.length());
        }
        else
        {
            return true;
        }
    }

    /**
     * Boolean validity check.
     *
     * @param comment
     *         Needs to consist of less than 250 letters
     * @return 'true' if the string is under 250 characters in length and contains only letters, otherwise 'false'
     * @throws IllegalArgumentException
     *         If the string consist of more than 249 characters or contains other than letters and/or numbers
     */
    public boolean isValidComment(String comment)
    {
        if (!comment.matches("[a-zA-Z_ ]*"))
        {
            throw new IllegalArgumentException();
        }
        else if (comment.length() > 250)
        {
            throw new IllegalFormatWidthException(comment.length());
        }
        else
        {
            return true;
        }
    }

    /**
     * Boolean validity check.
     *
     * @param requirementId
     *         Needs to consist of a combination of 2 or more letters and/or numbers
     * @return 'true' if the string is at least 2 characters long, is unique within the project and contains only
     * letters and/or numbers, otherwise 'false'
     * @throws IllegalArgumentException
     *         If the string consist of less than 2 characters or contains other than letters and/or numbers
     */
    public boolean isValidRequirementID(String requirementId)
    {
        if (!requirementId.matches("[a-zA-Z0-9]*"))
        {
            IllegalArgumentException e = new IllegalArgumentException("Please enter a requirement ID containing 2 or more letters and/or numbers that is unique within the project");
            throw e;
        }
        else if (requirementId.length() < 2)
        {
            throw new IllegalFormatWidthException(requirementId.length());
        }
        else
        {
            return true;
        }
    }

    /**
     * Boolean validity check.
     *
     * @param hours
     *         Double of whole or half hours
     * @return 'true' if the inputs remainder is zero (mod 0.5), otherwise 'false'
     * @throws IllegalArgumentException
     *         If the double does not have a remainder of 0 (mod 0.5)
     */
    public boolean isValidTime(double hours)
    {
        if (hours % 0.5 == 0)
        {
            return true;
        }
        else
        {
            IllegalArgumentException e = new IllegalArgumentException("Please enter only whole and/or half hours");
            throw e;
        }
    }

    /**
     * Converting a Project object into a string.
     *
     * @return Project object's instance variables in a custom String format
     */
    @Override
    public String toString()
    {
        return "{title='" + title + '\'' + ", customerId='" + customerId
                       + '\'' + ", projectId='" + projectId + '\'' + ", deadline=" + deadline
                       + ", comment='" + comment + '\'' + ", timeSpent=" + timeSpent
                       + ", currentStatus='" + currentStatus + '}' + "\n";
    }
}