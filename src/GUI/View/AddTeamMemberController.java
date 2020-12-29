package GUI.View;

import ModelClasses.ProjectModel;
import ModelClasses.TeamMember;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class AddTeamMemberController
{
    @FXML TextField nameField;
    @FXML TextField idField;

    private ViewHandler viewHandler;
    private Region root;
    private ProjectModel model;

    public Region getRoot()
    {
        return root;
    }

    public void init(ViewHandler viewHandler, ProjectModel model, Region root)
    {
        this.viewHandler=viewHandler;
        this.root=root;
        this.model=model;
    }

    public void reset()
    {
        nameField.setText("");
        idField.setText("");
    }

    @FXML
    private void cancelButtonClicked()
    {
        reset();
        viewHandler.openView("homeView");
    }

    @FXML
    private void saveButtonClicked()
    {
        model.addTeamMember(new TeamMember(nameField.getText(), idField.getText()));
        viewHandler.openView("homeView");
    }
}
