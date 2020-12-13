package GUI.View;

import ModelClasses.ProjectModel;
import javafx.scene.layout.Region;

public class HomeController {


  private Region root;
  private ProjectModel model;
  private ViewHandler viewHandler;

  public HomeController() {

  }
  public Region getRoot() {
    return root;
  }
  public void initiator(Region root, ViewHandler viewHandler, ProjectModel model) {
    this.root = root;
    this.viewHandler = viewHandler;
    this.model = model;
  }
  public void reset() {

  }

}
