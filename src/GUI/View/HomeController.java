package GUI.View;

import ModelClasses.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

<<<<<<< HEAD
import java.awt.Button;
=======
import java.beans.EventHandler;
import java.util.Optional;
>>>>>>> bc41bc951d99db28dcf9bf949a5a86ba37eeb24c

public class HomeController
{

  @FXML private TableView<Project> tableViewActive;
  @FXML private TableColumn <Project, String> idColumnActive;
  @FXML private TableColumn <Project, String> titleColumnActive;
  @FXML private TableColumn <Project, MyDate> deadlineColumnActive;

  @FXML private TableView<Project> tableViewEnded;
  @FXML private TableColumn <Project, String> idColumnEnded;
  @FXML private TableColumn <Project, String> titleColumnEnded;
  @FXML private TableColumn <Project, MyDate> deadlineColumnEnded;

  @FXML private TextField searchProjectTitle;

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

    tableViewActive.setItems(getActiveProjects());

    idColumnActive.setCellValueFactory(new PropertyValueFactory<>("projectId"));
    titleColumnActive.setCellValueFactory(new PropertyValueFactory<>("title"));
    deadlineColumnActive.setCellValueFactory(new PropertyValueFactory<>("deadline"));

<<<<<<< HEAD
    tableViewEnded.setItems(getEndedProjects());

    idColumnEnded.setCellValueFactory(new PropertyValueFactory<>("projectId"));
    titleColumnEnded.setCellValueFactory(new PropertyValueFactory<>("title"));
    deadlineColumnEnded.setCellValueFactory(new PropertyValueFactory<>("deadline"));
=======
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

>>>>>>> bc41bc951d99db28dcf9bf949a5a86ba37eeb24c
  }

  private ObservableList<Project> getActiveProjects() {
    ObservableList<Project> activeProjects = FXCollections.observableArrayList();
    for(int i = 0; i < model.getProjectList().getAllProjects().size(); i++) {
      if(model.getProjectList().getAllProjects().get(i).getCurrentStatus().equalsIgnoreCase("WAITING") || model.getProjectList().getAllProjects().get(i).getCurrentStatus().equalsIgnoreCase("STARTED"))
        activeProjects.add(model.getProjectList().getAllProjects().get(i));
    }
    return activeProjects;
  }
  private ObservableList<Project> getEndedProjects() {
    ObservableList<Project> endedProjects = FXCollections.observableArrayList();
    for(int i = 0; i < model.getProjectList().getAllProjects().size(); i++) {
      if(model.getProjectList().getAllProjects().get(i).getCurrentStatus().equalsIgnoreCase("ENDED"))
        endedProjects.add(model.getProjectList().getAllProjects().get(i));
    }
    return endedProjects;
  }

  private ObservableList<TeamMember> getTeam()
  {
    ObservableList<TeamMember> team=FXCollections.observableArrayList();

    team.addAll();
    return team;
  }

  public void reset() {

    tableViewActive.setItems(getActiveProjects());
    tableViewActive.refresh();
    tableViewEnded.setItems(getEndedProjects());
    tableViewEnded.refresh();

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

  @FXML private void tableActiveProjects(MouseEvent event) {
    if(event.getClickCount() == 2) {
      Project project = tableViewActive.getSelectionModel().getSelectedItem();
      state.setSelectedProject(project.getProjectId());
      viewHandler.setState(state);
      viewHandler.openView("projectView");
    }
  }
  @FXML private void tableEndedProjects(MouseEvent event) {
    if(event.getClickCount() == 2) {
      Project project = tableViewEnded.getSelectionModel().getSelectedItem();
      state.setSelectedProject(project.getProjectId());
      viewHandler.setState(state);
      viewHandler.openView("projectView");
    }
  }
  @FXML private void searchProjectButtonClicked() {
    state.setSelectedProject(model.getProjectList().getProjectByTitle(searchProjectTitle.getText()).getProjectId());
    viewHandler.setState(state);
    viewHandler.openView("projectView");
  }



}
