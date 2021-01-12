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
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

import java.util.Collection;
import java.util.Optional;



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
  @FXML private TableView<Project> teamMemberProjects;
  @FXML private TableColumn<Project,String> tMPId;
  @FXML private TableColumn<Project,String> tMPTitle;
  @FXML private TableColumn<Project,MyDate> tMPDeadline;
  @FXML private TitledPane titlePane;
  @FXML private Label teamMemberId;
  @FXML private Label id;
  @FXML private Label teamMemberName;
  @FXML private Label name;
  @FXML private ListView tMReqResponsible;
  @FXML private ListView tMTaskResponsible;
  @FXML private Button removeTeamMember;

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

    teamAccordion.getPanes().get(0).setVisible(false);

    /*TableView projects = new TableView(tmProjects);
    TableColumn<Project,String> title=new TableColumn<>("Title");
    TableColumn<Project,String> id=new TableColumn<>("ID");
    TableColumn<Project,String> deadline=new TableColumn<>("Deadline");
    title.setCellValueFactory(new PropertyValueFactory<>(model.getProjectList().getAllProjects().get(i).getTitle()));
    id.setCellValueFactory(new PropertyValueFactory<>(model.getProjectList().getAllProjects().get(i).getProjectId()));
    deadline.setCellValueFactory(new PropertyValueFactory<>(model.getProjectList().getAllProjects().get(i).getDeadline().toString()));
    tp.setContent(projects);
    tMPId.setCellValueFactory(new PropertyValueFactory<>("projectId"));
    tMPTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
    tMPDeadline.setCellValueFactory(new PropertyValueFactory<>("deadline"));*/
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

  private ObservableList<TitledPane> getTitlePanes()
  {
    ObservableList<TitledPane> titlePanes = FXCollections.observableArrayList();
    titlePanes.addAll(teamAccordion.getPanes());
    return titlePanes;
  }

  public void reset()
  {
    tableViewActive.setItems(getActiveProjects());
    tableViewActive.refresh();
    tableViewEnded.setItems(getEndedProjects());
    tableViewEnded.refresh();

//    for (int i = 0; i < (model.getTeam().size()-teamAccordion.getPanes().size()); i++)
//    {
//      if (!(teamAccordion.getPanes().get(i).getText().equals(getTitlePanes().get(i).getText())))
//      {
//        teamAccordion.getPanes().add(getTitlePanes().get(i));
//      }
//    }
  }

  @FXML private void createButtonPressed()
  {
    viewHandler.openView("addProject");
  }

//    if (!(Team.isIdAvailable(teamMember.getTeamMemberId())))
//    {
//      for (int i = 0; i < model.getProjectList().getAllProjects().size(); i++)
//      {
//        if (model.getProjectList().getAllProjects().get(i).getMembersOfTheProject().equals(teamMember))
//        {
//          ObservableList<Project> tmProjects=FXCollections.observableArrayList();
//          TableView projects = new TableView(tmProjects);
//          TableColumn<Project,String> title=new TableColumn<>("Title");
//          TableColumn<Project,String> id=new TableColumn<>("ID");
//          TableColumn<Project,String> deadline=new TableColumn<>("Deadline");
//          title.setCellValueFactory(new PropertyValueFactory<>(model.getProjectList().getAllProjects().get(i).getTitle()));
//          id.setCellValueFactory(new PropertyValueFactory<>(model.getProjectList().getAllProjects().get(i).getProjectId()));
//          deadline.setCellValueFactory(new PropertyValueFactory<>(model.getProjectList().getAllProjects().get(i).getDeadline().toString()));
//          tp.setContent(projects);
//        }
//      }
//    }

  public void addTitlePane(TeamMember teamMember)
  {
    TitledPane tp= new TitledPane(teamMember.getTeamMemberId(), teamAccordion.getPanes().get(0).getContent());
    teamMemberId.setText(teamMember.getTeamMemberId());
    teamMemberName.setText(teamMember.getName());
    teamAccordion.getPanes().add(tp);
  }

  @FXML private void addTeamMemberPressed()
  {
    viewHandler.openView("addTeamMember");
    model.createRoster();
  }

  @FXML private void removeTeamMemberPressed()
  {
    Alert removeTeamMember= new Alert(Alert.AlertType.CONFIRMATION);
    removeTeamMember.setContentText("Are you sure you want to remove this team member?");

    Optional<ButtonType> result=removeTeamMember.showAndWait();
    ButtonType button = result.orElse(ButtonType.CANCEL);
    if (button == ButtonType.OK)
    {
      for (int i = 0; i < teamAccordion.getPanes().size(); i++)
      {
        if (teamAccordion.getPanes().get(i).isExpanded())
        {
          Team.fire(teamAccordion.getPanes().get(i).getText());
          teamAccordion.getPanes().remove(i);
          break;
        }
      }
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
