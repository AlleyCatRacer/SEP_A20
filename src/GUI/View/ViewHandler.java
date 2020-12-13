package GUI.View;

import ModelClasses.ProjectModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewHandler
{
  private HomeController projectListController;
  private ProjectController projectController;
  private RequirementController requirementController;
  private TaskController taskController;
  private Scene currentScene;
  private Stage primaryStage;
  private ProjectModel model;

  public ViewHandler(ProjectModel model)
  {
    this.model = model;
    this.currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView();
  }

  public void openView()
  {
    Region root = loadProjectListView("ProjectListView.fxml");

    currentScene.setRoot(root);
    String title = "";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  public void closeView()
  {
    primaryStage.close();
  }

  private Region loadProjectListView(String fxmlFile) {
    if(projectListController == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        projectListController = loader.getController();
        projectListController.initiator(root, this, model);

      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }
    else
      projectListController.reset();

    return projectListController.getRoot();
  }

  /*private Region loadGradeListView(String fxmlFile)
  {
    if (gradeListViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        gradeListViewController = loader.getController();
        gradeListViewController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      gradeListViewController.reset();
    }
    return gradeListViewController.getRoot();
  }

  private Region loadAddGradeView(String fxmlFile)
  {
    if (addGradeViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        addGradeViewController = loader.getController();
        addGradeViewController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      addGradeViewController.reset();
    }
    return addGradeViewController.getRoot();
  }

  private Region loadDetailsView(String fxmlFile)
  {
    if (detailsViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        detailsViewController = loader.getController();
        detailsViewController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      detailsViewController.reset();
    }
    return detailsViewController.getRoot();
  }*/



}