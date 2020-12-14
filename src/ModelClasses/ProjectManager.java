package ModelClasses;

import ModelClasses.Requirement.Requirement;

public class ProjectManager implements ProjectModel
{
    private Team team;
    private ProjectList projectList;

    public ProjectManager()
    {
        this.team = new Team();
        this.projectList = new ProjectList();
    }

    public void addProject(String title, String projectId, String customerId, MyDate deadline, String comment)
    {
        projectList.addProject(title, projectId, customerId, deadline, comment);
    }

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
    public ProjectList getProjectList() {
        return projectList;
    }

    @Override
    public void addProjectRelated()
    {

    }

    @Override
    public void addNonFunctional()
    {

    }

    @Override
    public void addTask(Task task)
    {

    }

    @Override
    public void addTeamMember(TeamMember teamMember)
    {

    }

    @Override
    public void editProject(Project project)
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
    public void assignToTask(Task task)
    {

    }
}