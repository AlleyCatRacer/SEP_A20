import ModelClasses.*;

import java.util.ArrayList;

public interface ProjectPersistence {
    ProjectManager projectManager = new ProjectManager();

    public ProjectList loadAllProjects();

    public Team loadAllTeamMembers();

    public void saveAll();

    public void saveProject(Project project);

    public void saveTeamMember(TeamMember teamMember);

    public ArrayList<Task> getAllTasks();

    public ArrayList<Task> getAllTasksOfTeamMember(String[] ids);

}
