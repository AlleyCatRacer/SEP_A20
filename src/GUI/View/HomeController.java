package GUI.View;

import ModelClasses.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

import java.beans.EventHandler;
import java.util.Optional;

public class HomeController
{

  @FXML private TableView<Project> tableView;
  @FXML private TableColumn <Project, String> idColumn;
  @FXML private TableColumn <Project, String> titleColumn;
  @FXML private TableColumn <Project, MyDate> deadlineColumn;
  @FXML private Button addTeamMember;
  @FXML private Accordion teamAccordion;
  @FXML private TitledPane teamMember;
  @FXML private Label teamMemberId;
  @FXML private Label teamMemberName;
  @FXML private TableView<Project> teamMemberProjects;
  @FXML private TableColumn <Project, String> tMPId;
  @FXML private TableColumn <Project, String> tMPTitle;
  @FXML private TableColumn <Project, MyDate> tMPDeadline;

  private Region root;
  private ProjectModel model;
  private ViewHandler viewHandler;
  private ViewState state;
  private Team roster;

  public Region getRoot() {
    return root;
  }

  public void init(ViewHandler viewHandler, ProjectModel model, Region root)
  {
    this.root = root;
    this.viewHandler = viewHandler;
    this.model = model;
    this.state = new ViewState();
    this.roster= new Team();

    tableView.setItems(getProjects());

    idColumn.setCellValueFactory(new PropertyValueFactory<>("projectId"));
    titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
    deadlineColumn.setCellValueFactory(new PropertyValueFactory<>("deadline"));

    for (int i = 0; i < getTeam().size(); i++)
    {
      this.teamMember=new TitledPane();
      teamMember.setText(model.getTeam().get(i).getTeamMemberId());
      teamMemberId.setText(model.getTeam().get(i).getTeamMemberId());
      teamMemberName.setText(model.getTeam().get(i).getName());
      Team projectTeam= new Team();
      projectTeam.addTeamMembers(model.getProjectList().getAllProjects().get(i).getMembersOfTheProject());
      if (projectTeam.get(i)) //TODO
      this.teamMemberProjects=new TableView<Project>();

    }

  }

  private ObservableList<Project> getProjects() {
    ObservableList<Project> projects = FXCollections.observableArrayList();
      projects.addAll(model.getProjectList().getAllProjects());
    return projects;
  }

  private ObservableList<TeamMember> getTeam()
  {
    ObservableList<TeamMember> team=FXCollections.observableArrayList();

    team.addAll();
    return team;
  }

  public void reset() {

    tableView.setItems(getProjects());
    tableView.refresh();

  }

  @FXML private void createButtonPressed() {
    viewHandler.openView("addProject");
  }

  @FXML private void addTeamMemberPressed()
  {
    viewHandler.openView("addTeamMember");
  }

  @FXML private void removeTeamMemberPressed()
  {
    Alert removeTeamMember= new Alert(Alert.AlertType.CONFIRMATION);
    removeTeamMember.setContentText("Are you sure you want to remove this team member?");
    removeTeamMember.showAndWait();

    Optional<ButtonType> result=removeTeamMember.showAndWait();
    ButtonType button =result.orElse(ButtonType.CANCEL);
    if (button==ButtonType.OK)
    {

    }
    //Optional<ButtonType> result = alert.showAndWait();
    //ButtonType button = result.orElse(ButtonType.CANCEL);
    //
    //if (button == ButtonType.OK) {
    //    System.out.println("Ok pressed");
    //} else {
    //    System.out.println("canceled");
    //}
  }

  @FXML public void tableHomeController(MouseEvent event) {
    if(event.getClickCount() == 2) {
      Project project = tableView.getSelectionModel().getSelectedItem();
      state.setSelectedProject(project.getProjectId());
      viewHandler.setState(state);
      viewHandler.openView("projectView");
    }
  }



}
