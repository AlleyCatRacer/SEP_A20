package GUI.View;

import javafx.scene.control.TitledPane;

public class ViewState {

  private String selectedProject;
  private String selectedRequirement;
  private String selectedTask;

  public ViewState()
  {
    selectedProject = "";
    selectedRequirement = "";
    selectedTask = "";
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
}

//Select a listener
