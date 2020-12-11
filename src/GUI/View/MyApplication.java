package GUI.View;

<<<<<<< Updated upstream:src/MyApplication.java
=======
import GUI.Model.ProjectManager;
>>>>>>> Stashed changes:MyApplication.java
import javafx.application.Application;
import javafx.stage.Stage;
import model.ProjectManager;
import model.ProjectModel;
import model.Project;
import view.ViewHandler;

public class MyApplication extends Application
{
<<<<<<< Updated upstream:src/MyApplication.java
    public void start(Stage primaryStage)
    {
        ProjectManager model = new ProjectManager();
        ViewHandler view = new ViewHandler(model);
        view.start(primaryStage);
    }
=======
  public void start(Stage primaryStage)
  {
    ProjectManager model = new ProjectManager();
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);
  }
>>>>>>> Stashed changes:MyApplication.java
}
