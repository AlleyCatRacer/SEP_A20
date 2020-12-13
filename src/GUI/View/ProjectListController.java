package GUI.View;

import ModelClasses.ProjectModel;
import javafx.scene.layout.Region;

public class ProjectListController {


  private Region root;
  private ProjectModel model;
  private ViewHandler viewHandler;

  public ProjectListController() {

  }
  public Region getRoot() {
    return root;
  }
  public void init(Region root, ViewHandler viewHandler, ProjectModel model) {
    this.root = root;
    this.viewHandler = viewHandler;
    this.model = model;
  }
  public void reset() {

  }

}
