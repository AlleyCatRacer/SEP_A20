package GUI.View;

import ModelClasses.ProjectModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewHandler
{
    private HomeController homeController;
    private ProjectController projectController;
    private RequirementController requirementController;
    private TaskController taskController;
    private Scene currentScene;
    private Stage stage;
    private ProjectModel model;

    public ViewHandler(ProjectModel model)
    {
        this.model = model;
        this.currentScene = new Scene(new Region());
    }

    public void start(Stage primaryStage)
    {
        this.stage = primaryStage;
        openView();
    }

    public void openView()
    {
        Region root = loadHomeView("HomeView.fxml");

        currentScene.setRoot(root);
        String title = "";
        if (root.getUserData() != null)
        {
            title += root.getUserData();
        }
        stage.setTitle(title);
        stage.setScene(currentScene);
        stage.setWidth(root.getPrefWidth());
        stage.setHeight(root.getPrefHeight());
        stage.show();
    }

    public void closeView()
    {
        stage.close();
    }

    private Region loadHomeView(String fxmlFile)
    {
        if (homeController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                homeController = loader.getController();
                homeController.initiator(root, this, model);

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
            homeController.reset();
        return homeController.getRoot();
    }

    private Region loadProjectView(String fxmlFile)
    {
        if (projectController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                projectController = loader.getController();
                projectController.init(this, model, root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            projectController.reset();
        }
        return projectController.getRoot();
    }

    /*private Region loadDetailsView(String fxmlFile)
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

    private Region loadRequirementView(String fxmlFile)
    {
        if (requirementController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                requirementController = loader.getController();
                requirementController.init(this, model, root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            requirementController.reset();
        }
        return requirementController.getRoot();
    }

    private Region loadTaskView(String fxmlFile)
    {
        if (taskController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                taskController = loader.getController();
                taskController.init(this, model, root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            taskController.reset();
        }
        return taskController.getRoot();
    }

    private Region loadEditProject(String fxmlFile)
    {
        if (editProjectController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                editProjectController = loader.getController();
                editProjectController.init(this, model, root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            editProjectController.reset();
        }
        return editProjectController.getRoot();
    }

    private Region loadAddTeamMember(String fxmlFile)
    {
        if (addTeamMemberController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                addTeamMemberController = loader.getController();
                addTeamMemberController.init(this, model, root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            addTeamMember.reset();
        }
        return addTeamMemberController.getRoot();
    }

    private Region loadRemoveTeamMember(String fxmlFile)
    {
        if (removeTeamMember == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();

                removeTeamMemberController = loader.getController();
                removeTeamMemberController.init(this, model, root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            removeTeamMemberController.reset();
        }
        return removeTeamMemberController.getRoot();
    }

    private Region loadEditRequirement(String fxmlFile)
    {
        if (editRequirementController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                editRequirementController = loader.load();
                editRequirementController.init(this, model, root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            editRequirementController.reset();
        }
        return editRequirementController.getRoot();
    }

    private Region loadAddTask(String fxmlFile)
    {
        if (addTaskController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                addTaskController = loader.getController();
                addTaskController.init(this, model, root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            addTaskController.reset();
        }
        return addTaskController.getRoot();
    }

    private Region loadEditTask(String fxmlFile)
    {
        if (editTaskController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                editTaskController = loader.getController();
                editTaskController.init(this, model, root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            editTaskController.reset();
        }
        return editTaskController.getRoot();

    }
    return editTaskController.getRoot();*/
}