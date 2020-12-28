package GUI.View;

import ModelClasses.MyDate;
import ModelClasses.Project;
import ModelClasses.ProjectModel;
import ModelClasses.Status;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class EditProjectController {

  @FXML TextField changeTitle;
  @FXML Label projectId;
  @FXML Label customerId;
  @FXML ChoiceBox status;
  @FXML TextField day;
  @FXML TextField month;
  @FXML TextField year;
  @FXML Label estimate;
  @FXML Label timeSpent;
  @FXML TextArea editDescription;
  @FXML TextArea editComment;




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
    projectId.setText(temp.getProjectId());
    customerId.setText(temp.getCustomerId());

    ObservableList<String> statuses = FXCollections.observableArrayList(Status.WAITING.toString(), Status.STARTED.toString(), Status.ENDED.toString());
    status.setItems(statuses);
    status.setValue(temp.getCurrentStatus());

    day.setText(String.valueOf(temp.getDeadline().getDay()));
    month.setText(String.valueOf(temp.getDeadline().getMonth()));
    year.setText(String.valueOf(temp.getDeadline().getYear()));
    estimate.setText(String.valueOf(temp.getEstimate()));
    timeSpent.setText(String.valueOf(temp.getTimeSpent()));
    editComment.setText(temp.getComment());
  }
  public void reset(ViewState state) {
    this.state = state;
    init(viewHandler, model, root, state);
  }
  @FXML private void saveButtonClicked() {

    model.getProjectList().getProjectByID(state.getSelectedProject()).changeTitle(changeTitle.getText());
    model.getProjectList().getProjectByID(state.getSelectedProject()).editStatus((String)status.getValue());

    MyDate deadline = new MyDate(Integer.parseInt(day.getText()), Integer.parseInt(month.getText()), Integer.parseInt(year.getText()));
    model.getProjectList().getProjectByID(state.getSelectedProject()).setDeadline(deadline);

    model.getProjectList().getProjectByID(state.getSelectedProject()).setDescription(editDescription.getText());
    model.getProjectList().getProjectByID(state.getSelectedProject()).editComment(editComment.getText());


    viewHandler.openView("projectView");
  }
  @FXML private void cancelButtonClicked() {
    viewHandler.openView("projectView");
  }

  @FXML private void addRequirementClicked() {
    viewHandler.openView("addRequirement");
  }



}

