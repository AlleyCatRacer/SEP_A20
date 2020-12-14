package GUI.View;

public class ViewState {

  private int selectedProject;
  private int selectedRequirement;
  private int selectedTask;

  public ViewState() {
  selectedProject = -1;
  selectedRequirement = -1;
  selectedTask = -1;
  }
  public int getSelectedProject() {
    return selectedProject;
  }

  public int getSelectedRequirement()
  {
    return selectedRequirement;
  }

  public int getSelectedTask()
  {
    return selectedTask;
  }

  public void setSelectedProject(int selectedProject)
  {
    this.selectedProject = selectedProject;
  }

  public void setSelectedRequirement(int selectedRequirement)
  {
    this.selectedRequirement = selectedRequirement;
  }

  public void setSelectedTask(int selectedTask)
  {
    this.selectedTask = selectedTask;
  }
}
