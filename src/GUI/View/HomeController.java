package GUI.View;

import ModelClasses.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;


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

  @FXML private Accordion teamAccordion;

  private Region root;
  private ProjectModel model;
  private ViewHandler viewHandler;
  private ViewState state;

  public Region getRoot() {
    return root;
  }

  public void init(ViewHandler viewHandler, ProjectModel model, Region root)
  {
    this.root = root;
    this.viewHandler = viewHandler;
    this.model = model;
    this.state = new ViewState();

    tableViewActive.setItems(getActiveProjects());

    idColumnActive.setCellValueFactory(new PropertyValueFactory<>("projectId"));
    titleColumnActive.setCellValueFactory(new PropertyValueFactory<>("title"));
    deadlineColumnActive.setCellValueFactory(new PropertyValueFactory<>("deadline"));


    tableViewEnded.setItems(getEndedProjects());

    idColumnEnded.setCellValueFactory(new PropertyValueFactory<>("projectId"));
    titleColumnEnded.setCellValueFactory(new PropertyValueFactory<>("title"));
    deadlineColumnEnded.setCellValueFactory(new PropertyValueFactory<>("deadline"));
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

  public void reset()
  {
    tableViewActive.setItems(getActiveProjects());
    tableViewActive.refresh();
    tableViewEnded.setItems(getEndedProjects());
    tableViewEnded.refresh();

    for (int i = 0; i < model.getTeam().size(); i++)
    {
      addTeamMember(Team.getRoster().get(i));
    }

    //if (!(model.getTeam().isEmpty()))
    //    {
    //      for (TeamMember teamMember : model.getTeam())
    //      {
    //        for (int i = 0; i < model.getTeam().size(); i++)
    //        {
    //          if (teamMember.getTeamMemberId().equals(model.getTeam().get(i)))
    //          {
    //            addTeamMember(teamMember);
    //          }
    //        }
    //      }
    //    }
  }

  @FXML private void createButtonPressed() {
    viewHandler.openView("addProject");
  }

  public void addTeamMember(TeamMember teamMember)
  {
    TitledPane tp=new TitledPane();
    GridPane grid =new GridPane();
    Insets five= new Insets(5,5,5,5);
    grid.setPadding(five);
    grid.setHgap(100);
    Button removeButton=new Button();
    removeButton.setText("Remove");
    removeButton.setOnAction(new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent actionEvent)
      {
        removeTeamMemberPressed();
      }
    });
    Label Name = new Label("Name:");
    Name.setPadding(five);
    Label name = new Label(teamMember.getName());
    name.setPadding(five);
    grid.add(new Label("Name:"),0,0);
    grid.add(new Label(teamMember.getName()),1,0);
    grid.add(new Label("ID:"),0,1);
    grid.add(new Label(teamMember.getTeamMemberId()),1,1);
    grid.add(removeButton,3,1);
    tp.setText(teamMember.getTeamMemberId());
    tp.setContent(grid);

    if (!(Team.isIdAvailable(teamMember.getTeamMemberId())))
    {
      for (int i = 0; i < model.getProjectList().getAllProjects().size(); i++)
      {
        if (model.getProjectList().getAllProjects().get(i).getMembersOfTheProject().equals(teamMember))
        {
          ObservableList<Project> tmProjects=FXCollections.observableArrayList();
          TableView projects = new TableView(tmProjects);
          TableColumn<Project,String> title=new TableColumn<>("Title");
          TableColumn<Project,String> id=new TableColumn<>("ID");
          TableColumn<Project,String> deadline=new TableColumn<>("Deadline");
          title.setCellValueFactory(new PropertyValueFactory<>(model.getProjectList().getAllProjects().get(i).getTitle()));
          id.setCellValueFactory(new PropertyValueFactory<>(model.getProjectList().getAllProjects().get(i).getProjectId()));
          deadline.setCellValueFactory(new PropertyValueFactory<>(model.getProjectList().getAllProjects().get(i).getDeadline().toString()));
          tp.setContent(projects);
        }
      }
    }

    teamAccordion.getPanes().add(tp);
  }

  @FXML private void addTeamMemberPressed()
  {
    viewHandler.openView("addTeamMember");
  }

  @FXML private void removeTeamMemberPressed()
  {
    Alert removeTeamMember= new Alert(Alert.AlertType.CONFIRMATION);
    removeTeamMember.setContentText("Are you sure you want to remove this team member?");

    Optional<ButtonType> result=removeTeamMember.showAndWait();
    ButtonType button =result.orElse(ButtonType.CANCEL);
    if (button==ButtonType.OK)
    {
      Team.fire(state.getSelectedTeamMember());
      model.removeTeamMember(state.getSelectedTeamMember());
    }
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
