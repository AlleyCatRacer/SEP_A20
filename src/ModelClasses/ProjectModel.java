package ModelClasses;

import ModelClasses.Requirement.*;

import java.util.ArrayList;

public interface ProjectModel
{
    void addProject(String title, String projectId, String customerId, MyDate deadline, String comment);

    ProjectList getProjectList();

    void addUserStory(String projectID, String requirementId, String description, MyDate deadline, Priority priority);

    void addProjectRelated(String requirementId, String description, MyDate deadline);

    void addNonFunctional(String requirementId, String description);

    void addTask(String taskId, String description, double estimate);

    void addTeamMember(TeamMember teamMember);

    ArrayList<TeamMember> getTeam();

//    void editProject(Project project);

    void editProjectTitle(String title);

    void editProjectStatus(Status status);

    void editProjectDeadline(MyDate deadline);

    void editProjectComment(String comment);

    void editRequirement(Requirement requirement);

    void editTask(Task task);

    void editRoleTeamMember(TeamMember teamMember);

    void removeRequirement(Requirement requirement);

    void removeTask(Task task);

    void removeTeamMember(TeamMember teamMember);

    void assignToRequirement(TeamMember teamMember);

    void assignToTask(TeamMember teamMember);

}
