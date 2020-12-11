package GUI.Model;

import ModelClasses.MyDate;
import ModelClasses.Project;
import ModelClasses.Requirement.Requirement;
import ModelClasses.Task;
import ModelClasses.TeamMember;

public interface ProjectModel
{
    void addProject(String title, String projectId, String customerId, MyDate deadline, String comment);

    void addRequirement(Requirement requirement);

    void addTask(Task task);

    void addTeamMember(TeamMember teamMember);

    void editProject(Project project);

    void editRequirement(Requirement requirement);

    void editTask(Task task);

    void editRoleTeamMember(TeamMember teamMember);

    void removeRequirement(Requirement requirement);

    void removeTask(Task task);

    void removeTeamMember(TeamMember teamMember);

    void assignToRequirement(TeamMember teamMember);

    void assignToTask(Task task);

}
