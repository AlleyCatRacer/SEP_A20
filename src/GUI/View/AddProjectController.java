package GUI.View;

import ModelClasses.MyDate;
import ModelClasses.ProjectModel;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;



public class AddProjectController {

  @FXML TextField ChangeTitle;
  @FXML TextField ProjectID;
  @FXML TextField CustomerID;
  @FXML TextField Day;
  @FXML TextField Month;
  @FXML TextField Year;
  @FXML TextArea Comment;
  private Region root;
  private ProjectModel model;
  private ViewHandler viewHandler;

  public AddProjectController() {

  }
  public Region getRoot() {
    return root;
  }
  public void init(ViewHandler viewHandler, ProjectModel model, Region root) {
    this.root = root;
    this.viewHandler = viewHandler;
    this.model = model;
  }
  public void reset() {

  }
  @FXML private void cancelProjectButtonPressed() {
    viewHandler.openView("homeView");
  }
  @FXML private void createProjectButtonPressed() {
    MyDate deadline = new MyDate(Integer.parseInt(Day.getText()), Integer.parseInt(Month.getText()), Integer.parseInt(Year.getText()));
    model.addProject(ChangeTitle.getText(), ProjectID.getText(), CustomerID.getText(), deadline, Comment.getText());
    viewHandler.openView("homeView");
  }
}
