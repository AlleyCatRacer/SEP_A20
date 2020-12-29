package GUI.View;

import ModelClasses.Project;
import ModelClasses.ProjectModel;
import ModelClasses.Requirement.UserStory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;

import java.util.ArrayList;

public class ProjectController
{
    @FXML Label projectTitle;
    @FXML Label projectId;
    @FXML Label customerId;
    @FXML Label projectStatus;
    @FXML TextArea projectDescription;
    @FXML TextArea comment;
    @FXML Label projectDeadline;
    @FXML Label projectEstimate;
    @FXML Label projectTimeSpent;

    @FXML Accordion projectReqAccordion;
    @FXML TitledPane requirementId1;
    @FXML Label reqType1;
    @FXML Label reqStatus1;
    @FXML Label reqPriority1;
    @FXML Label reqDeadline1;

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

        projectTitle.setText(temp.getTitle());
        projectId.setText(temp.getProjectId());
        customerId.setText(temp.getCustomerId());
        projectStatus.setText(temp.getCurrentStatus());
        comment.setText(temp.getComment());
        projectDescription.setText(temp.getDescription());

        projectEstimate.setText(String.valueOf(temp.getEstimate()));
        projectTimeSpent.setText(String.valueOf(temp.getTimeSpent()));
        projectDeadline.setText(temp.getDeadline().toString());


        if(temp.getRequirements().size() != 0) {
            ArrayList<TitledPane> panes = new ArrayList<>();
            for(int i = 0; i < temp.getRequirements().size(); i++) {
                TitledPane t1 = new TitledPane(temp.getRequirements().get(i).getRequirementId(), requirementId1.getContent());
                panes.add(t1);
            }
            ObservableList<TitledPane> obs = FXCollections.observableArrayList(panes);
            projectReqAccordion.getPanes().addAll(obs);
        }


    }

    public void reset(ViewState state) {
        this.state = state;
        init(viewHandler, model, root, state);
    }


    @FXML private void homeButtonClicked() {
        viewHandler.openView("homeView");
    }
    @FXML private void editButtonClicked() {
        viewHandler.openView("editProject");
    }


}
