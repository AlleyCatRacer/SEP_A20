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
    @FXML TitledPane requirementId;
    @FXML Label reqType;
    @FXML Label reqStatus;
    @FXML Label reqPriority;
    @FXML Label reqDeadline;

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
            for(int i = 0; i < temp.getRequirements().size(); i++) {
                requirementId = new TitledPane();
                requirementId.setText(temp.getRequirements().get(i).getRequirementId());
                reqType.setText(temp.getRequirements().get(i).getType());


                projectReqAccordion.getPanes().add(requirementId);
            }
            System.out.println(projectReqAccordion.getPanes().size());
            System.out.println(projectReqAccordion.getPanes());

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
