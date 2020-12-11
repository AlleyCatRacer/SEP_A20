import javafx.application.Application;
import javafx.stage.Stage;
import model.ProjectManager;
import model.ProjectModel;
import model.Project;
import view.ViewHandler;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    ProjectManager model = new ProjectManager();
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);
  }
}
