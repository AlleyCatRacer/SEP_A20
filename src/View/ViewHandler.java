package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.GradeListModel;
import ModelClasses.ProjectModel;

public class ViewHandler
{
    private Scene currentScene;
    private Stage primaryStage;
    private ProjectModel model;
  /*private GradeListViewController gradeListViewController;
  private AddGradeViewController addGradeViewController;
  private DetailsViewController detailsViewController;*/
    //add controllers when done

    //this is an example, change everything
    public ViewHandler(ProjectModel model)
    {
        this.model = model;
        currentScene = new Scene(new Region());
    }

    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        openView("list");
    }

    public void openView(String id)
    {
        Region root = null;
        switch (id)
        {
            case "list":
                root = loadGradeListView("GradeListView.fxml");
                break;
            case "add":
                root = loadAddGradeView("AddGradeView.fxml");
                break;
            case "details":
                root = loadDetailsView("DetailsView.fxml");
                break;
        }
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

    private Region loadGradeListView(String fxmlFile)
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
    }



}