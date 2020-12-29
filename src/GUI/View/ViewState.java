package GUI.View;

public class ViewState {

  private String selectedProject;
  private String selectedRequirement;
  private String selectedTask;
  private String selectedTeamMember;

  public ViewState()
  {
    selectedProject = "";
    selectedRequirement = "";
    selectedTask = "";
    selectedTeamMember = "";
  }
  public String getSelectedProject() {
    return selectedProject;
  }

  public String getSelectedRequirement()
  {
    return selectedRequirement;
  }

  public String getSelectedTask()
  {
    return selectedTask;
  }

  public String getSelectedTeamMember()
  {
    return selectedTeamMember;
  }

  public void setSelectedProject(String selectedProject)
  {
    this.selectedProject = selectedProject;
  }

  public void setSelectedRequirement(String selectedRequirement)
  {
    this.selectedRequirement = selectedRequirement;
  }

  public void setSelectedTask(String selectedTask)
  {
    this.selectedTask = selectedTask;
  }

  public void setSelectedTeamMember(String selectedTeamMember)
  {
    this.selectedTeamMember = selectedTeamMember;
  }
}

//Select a listener
