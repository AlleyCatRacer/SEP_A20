package ModelClasses;

import ModelClasses.Requirement.*;

public interface ProjectModel
{
    void addProject(String title, String projectId, String customerId, MyDate deadline, String comment);

    ProjectList getProjectList();

    void addUserStory(String projectID, String requirementId, String description, MyDate deadline);

    void addProjectRelated();

    void addNonFunctional();

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
