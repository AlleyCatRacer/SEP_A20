package ModelClasses;

public class ProjectManager implements ProjectModel
{
    private Team team;
    private ProjectList projectList;

    public ProjectManager()
    {
        this.team = new Team();
        this.projectList = new ProjectList();
    }

    public void addProject(String title, String projectId, String customerId, MyDate deadline, String comment) {
        projectList.addProject(title, projectId, customerId, deadline, comment);
    }
    public void addUserStory(String projectID, String REQUIREMENTID, String description, MyDate deadline) {
        boolean success = false;
        for(int i = 0; i < projectList.getAllProjects().size(); i++) {
            if(projectList.getAllProjects().get(i).getProjectId().equals(projectID)) {
                projectList.getAllProjects().get(i).addUserStory(REQUIREMENTID, description, deadline);
                success = true;
            }
            if(!success)
                throw new IllegalArgumentException("Project with such ID not found");


        }
    }
}