package GUI.View;


import GUI.Model.*;

import javafx.application.Application;
import javafx.stage.Stage;

public class MyApplication extends Application
{
    public void start(Stage primaryStage)
    {
        ProjectManager model = new ProjectManager();
        ViewHandler view = new ViewHandler(model);
        view.start(primaryStage);
    }

  public void start(Stage primaryStage)
  {
    ProjectManager model = new ProjectManager();
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);
  }
}
