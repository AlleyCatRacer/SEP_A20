package GUI;


import GUI.View.ViewHandler;
import ModelClasses.ProjectManager;
import ModelClasses.ProjectModel;
import javafx.application.Application;
import javafx.stage.Stage;

public class MyApplication extends Application
{
    public void start(Stage primaryStage)
    {
        ProjectModel model = new ProjectManager();
        ViewHandler view = new ViewHandler(model);
        view.start(primaryStage);
    }
}
