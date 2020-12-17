package ModelClasses;

import ModelClasses.Requirement.Requirement;

/**
 * A ProjectManager class that implements the ProjectModel interface.
 *
 * @author Allie, Lili, Luke & Yoana
 * @version 1.0 - 14.12.20
 */
public class ProjectManager implements ProjectModel
{
    private ProjectList projectList;

    /**
     * No-argument constructor calling to the ProjectList and Team class' constructors.
     */
    public ProjectManager()
    {
        this.projectList = new ProjectList();
    }

    /**
     * Implementing abstract interface method by calling the Project class' constructor.
     *
     * @param title
     *         Needs to consist of a combination of no more than 24 letters and/or numbers.
     * @param projectId
     *         Needs to be unique ID consisting of a combination of no less than 2 letters and/or numbers.
     * @param customerId
     *         Needs to consist of a combination of no more than 24 letters and/or numbers.
     * @param deadline
     *         The day needs to be greater than zero and does not exceeds the referenced month's number of days, the
     *         month needs to be greater than zero and less than 12 and the year needs to be greater than zero and
     *         lesser than the current year.
     * @param comment
     *         Needs to consist of less than 250 letters.
     */
    public void addProject(String title, String projectId, String customerId, MyDate deadline, String comment)
    {
        projectList.addProject(title, projectId, customerId, deadline, comment);
    }

    /**
     * Implementing abstract interface method by calling the UserStory constructor through various classes.
     *
     * @param projectID
     *         String of project's ID
     * @param requirementId
     *         String of requirement's ID
     * @param description
     *         String of the requirement's description
     * @param deadline
     *         MyDate object of the requirement's deadline
     * @throws IllegalArgumentException
     *         If no project is found with the given ID, the requirement ID has already been used, the description
     *         string consists of more than 249 letters, the deadline's day isn't greater than zero or exceeds the
     *         referenced month's number of days, the deadline's month isn't greater than zero or exceeds 12, if the
     *         deadline's year isn't greater than zero or is lesser than the current year
     */
    public void addUserStory(String projectID, String requirementId, String description, MyDate deadline)
    {
        //ProjectList.getProjectByID("123")
        boolean success = false;
        for (int i = 0; i < projectList.getAllProjects().size(); i++)
        {
            if (projectList.getAllProjects().get(i).getProjectId().equals(projectID))
            {
                projectList.getAllProjects().get(i).addUserStory(requirementId, description, deadline);
                success = true;
            }
            if (!success)
                throw new IllegalArgumentException("Project with such ID not found");
        }
    }

    /**
     * Getting a list of all projects.
     *
     * @return ProjectList object
     */
    public ProjectList getProjectList() {
        return projectList;
    }

    /**
     * Implementing abstract interface method by calling the ProjectRelated constructor through various classes.
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
    @Override
    public void addProjectRelated(String requirementId, String description, MyDate deadline)
    {

    }

    /**
     * Implementing abstract interface method by calling the NonFunctional constructor through various classes.
     *
     * @param requirementId
     *         String of requirement's ID
     * @param description
     *         String of the requirement's description
     * @throws IllegalArgumentException
     *         If the given requirement ID has already been used or the description string consists of more than 249
     *         letters
     */
    @Override
    public void addNonFunctional(String requirementId, String description)
    {

    }

    @Override
    public void addTask(String taskId, String description, double estimate)
    {

    }

    @Override
    public void addTeamMember(TeamMember teamMember)
    {

    }

    /**
     * Implementing abstract interface method by calling a method to change a project's title.
     *
     * @param title
     *         String of the new project title
     * @throws IllegalArgumentException
     *         If the given title is longer than 24 characters or consist of more than letters and/or numbers
     */
    @Override
    public void editProjectTitle(String title)
    {

    }

    /**
     * Implementing abstract interface method by calling a method to change the status of a project.
     *
     * @param status
     *         Status enum constant
     */
    @Override
    public void editProjectStatus(Status status)
    {

    }

    /**
     * Implementing abstract interface method by calling a method to change the deadline of a project.
     *
     * @param deadline
     *         MyDate object of the project's new deadline
     * @throws IllegalArgumentException
     *         If the object's day isn't greater than zero or exceeds the referenced month's number of days. If the
     *         object's month isn't greater than zero or exceeds 12. If the object's year isn't greater than zero or is
     *         lesser than the current year.
     */
    @Override
    public void editProjectDeadline(MyDate deadline)
    {

    }

    /**
     * Implementing abstract interface method by calling a method to change the comment on a project.
     *
     * @param comment
     *         String of the new project comment
     * @throws IllegalArgumentException
     *         If the given title is longer than 249 characters or consist of more than letters and/or numbers
     */
    @Override
    public void editProjectComment(String comment)
    {

    }


    @Override
    public void editRequirement(Requirement requirement)
    {

    }

    @Override
    public void editTask(Task task)
    {

    }

    @Override
    public void editRoleTeamMember(TeamMember teamMember)
    {

    }

    @Override
    public void removeRequirement(Requirement requirement)
    {

    }

    @Override
    public void removeTask(Task task)
    {

    }

    @Override
    public void removeTeamMember(TeamMember teamMember)
    {

    }

    @Override
    public void assignToRequirement(TeamMember teamMember)
    {

    }

    @Override
    public void assignToTask(TeamMember teamMember)
    {

    }
}