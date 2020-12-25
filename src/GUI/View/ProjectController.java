package GUI.View;

import ModelClasses.Project;
import ModelClasses.ProjectModel;
import javafx.scene.layout.Region;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;


public class ProjectController
{
    @FXML Label projectTitle;
    @FXML Label projectId;
    @FXML Label customerId;
    @FXML Label projectStatus;
    //Unused id - project does not have a description
    @FXML TextArea projectDescription;
    @FXML TextArea comment;
    @FXML Label projectDeadline;
    @FXML Label projectEstimate;
    @FXML Label projectTimeSpent;

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
        comment.setText(temp.getComment());
        projectDescription.setText(temp.getDescription());

        projectEstimate.setText(String.valueOf(temp.getEstimate()));
        projectTimeSpent.setText(String.valueOf(temp.getTimeSpent()));
        projectDeadline.setText(temp.getDeadline().toString());


    }

    public void reset()
    {

    }


    @FXML private void homeButtonClicked() {
        viewHandler.openView("homeView");
    }


}
