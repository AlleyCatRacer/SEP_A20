package GUI.View;

import ModelClasses.Project;
import ModelClasses.ProjectModel;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class EditProjectController {

  @FXML TextField changeTitle;



  private Region root;
  private ViewHandler viewHandler;
  private ProjectModel model;
  private ViewState state;

  public Region getRoot() {
    return root;
  }

  public void init(ViewHandler viewHandler, ProjectModel model, Region root, ViewState state) {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
    this.state = state;

    Project temp = model.getProjectList().getProjectByID(state.getSelectedProject());

    changeTitle.setText(temp.getTitle());


  }
  public void reset() {

  }
  @FXML private void saveButtonClicked() {
    Project temp = model.getProjectList().getProjectByID(state.getSelectedProject());

    temp.changeTitle(changeTitle.getText());

    viewHandler.openView("projectView");
  }
  @FXML private void cancelButtonClicked() {
    viewHandler.openView("projectView");
  }



}

