package GUI.View;

import ModelClasses.ProjectModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import javax.swing.text.View;

public class ViewHandler
{
    private HomeController homeController;
    private AddProjectController addProjectController;
    private AddRequirementController addRequirementController;
    private EditProjectController editProjectController;
    private ProjectController projectController;
    private RequirementController requirementController;
    private TaskController taskController;
    private AddTeamMemberController addTeamMemberController;

    private Scene currentScene;
    private Stage stage;
    private ProjectModel model;
    private ViewState state;

    public ViewHandler(ProjectModel model)
    {
        this.model = model;
        this.currentScene = new Scene(new Region());
        this.state = new ViewState();
    }
    public void setState(ViewState state) {
        this.state = state;
    }

    public void start(Stage primaryStage)
    {
        this.stage = primaryStage;
        openView("homeView");
    }

    public void openView(String id)
    {
        Region root = null;

        switch(id) {

            case"homeView":
                root = loadHomeView("HomeView.fxml");
                break;
            case"addProject":
                root = loadAddProject("AddProject.fxml");
                break;
            case"projectView":
                root = loadProjectView("ProjectView.fxml");
                break;
            case"editProject":
                root = loadEditProject("EditProject.fxml");
                break;
            case"addRequirement":
                root = loadAddRequirement("AddRequirement.fxml");
                break;
            case"addTeamMember":
                root = loadAddTeamMember("AddTeamMember.fxml");
        }



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
                homeController.init(this, model, root);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            homeController.reset();
        }
        return homeController.getRoot();
    }

    private Region loadAddProject(String fxmlFile)
    {
        if (addProjectController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                addProjectController = loader.getController();
                addProjectController.init(this, model, root);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            addProjectController.reset();
        }
        return addProjectController.getRoot();
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
                projectController.init(this, model, root, state);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            projectController.reset(state);
        }
        return projectController.getRoot();
    }

    private Region loadEditProject(String fxmlFile) {
        if (editProjectController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                editProjectController = loader.getController();
                editProjectController.init(this, model, root, state);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            editProjectController.reset(state);
        }
        return editProjectController.getRoot();
    }
    private Region loadAddRequirement(String fxmlFile) {
        if (addRequirementController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                addRequirementController = loader.getController();
                addRequirementController.init(this, model, root, state);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            addRequirementController.reset();
        }
        return addRequirementController.getRoot();
    }

    /*

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
            } catch (Exception e)
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
            } catch (Exception e)
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

*/
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
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            addTeamMemberController.reset();
        }
        return addTeamMemberController.getRoot();
    }
/*

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
            } catch (Exception e)
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
            } catch (Exception e)
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
            } catch (Exception e)
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