package GUI.View;

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

        projectTitle.setText(model.getProjectList().getProjectByID(state.getSelectedProject()).getTitle());

    }

    public void reset()
    {

    }


    @FXML private void homeButtonClicked() {
        viewHandler.openView("homeView");
    }


}
