package GUI.View;

import ModelClasses.ProjectModel;
import javafx.scene.layout.Region;

public class TaskController
{

    private Region root;
    private ProjectModel model;
    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler, ProjectModel model, Region root)
    {
    }

    public void reset()
    {
    }

    public Region getRoot() {
        return root;
    }
}
