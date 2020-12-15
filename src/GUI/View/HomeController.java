package GUI.View;

import ModelClasses.MyDate;
import ModelClasses.ProjectModel;
import ModelClasses.Project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;

import java.awt.*;

public class HomeController
{

  @FXML private TableView<Project> tableView;
  @FXML private TableColumn <Project, String> idColumn;
  @FXML private TableColumn <Project, String> titleColumn;
  @FXML private TableColumn <Project, MyDate> deadlineColumn;
  private Region root;
  private ProjectModel model;
  private ViewHandler viewHandler;




  public HomeController() {

  }
  public Region getRoot() {
    return root;
  }
  public void init(ViewHandler viewHandler, ProjectModel model, Region root) {
    this.root = root;
    this.viewHandler = viewHandler;
    this.model = model;


    idColumn.setCellValueFactory(new PropertyValueFactory<Project, String>("projectId"));
    titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
    deadlineColumn.setCellValueFactory(new PropertyValueFactory<>("deadline"));

    tableView.setItems(getProjects());

  }
  private ObservableList<Project> getProjects() {
    ObservableList<Project> projects = FXCollections.observableArrayList();
      projects.addAll(model.getProjectList().getAllProjects());

    return projects;
  }
  public void reset() {

    tableView.setItems(getProjects());
  }
//  public void addProjectButtonPressed

  //model.

  @FXML private void createButtonPressed() {
    viewHandler.openView("addProject");
  }

}
