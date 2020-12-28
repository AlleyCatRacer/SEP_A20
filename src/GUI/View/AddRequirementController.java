package GUI.View;

import ModelClasses.ProjectModel;
import ModelClasses.Requirement.Priority;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class AddRequirementController {

  @FXML TextField requirementIdInput;
  @FXML ChoiceBox typeDropdown;
  @FXML ChoiceBox priorityDropdown;
  @FXML ChoiceBox assignResponsibleDropdown;
  @FXML TextArea reqDescription;
  @FXML TextField day;
  @FXML TextField month;
  @FXML TextField year;
  @FXML TextField estimate;


  private Region root;
  private ProjectModel model;
  private ViewHandler viewHandler;

  public Region getRoot() {
    return root;
  }

  public void init(ViewHandler viewHandler, ProjectModel model, Region root) {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;

    ObservableList<String> types = FXCollections.observableArrayList("User Story", "Project Related", "Non Functional");
    typeDropdown.setItems(types);
    ObservableList<Priority> priorities = FXCollections.observableArrayList(Priority.CRITICAL, Priority.HIGH, Priority.MEDIUM, Priority.LOW, Priority.UNDEFINED);
    priorityDropdown.setItems(priorities);
    assignResponsibleDropdown.setValue("None");
  }
  public void reset() {
    requirementIdInput.setText("");
    reqDescription.setText("");
    day.setText("");
    month.setText("");
    year.setText("");
    estimate.setText("");
  }

  @FXML private void cancelButtonClicked() {
    viewHandler.openView("editProject");
  }
}
