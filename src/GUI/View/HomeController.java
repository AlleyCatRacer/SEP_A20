package GUI.View;

import ModelClasses.ProjectModel;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;

import java.awt.*;

public class HomeController {


  private Region root;
  private ProjectModel model;
  private ViewHandler viewHandler;

  public HomeController() {

  }
  public Region getRoot() {
    return root;
  }
  public void init(ViewHandler viewHandler, ProjectModel model, Region root) {
    this.root = root;
    this.viewHandler = viewHandler;
    this.model = model;
  }
  public void reset() {

  }
//  public void addProjectButtonPressed

  //model.

  @FXML private void createButtonPressed() {
    viewHandler.openView("addProject");

  }

}
