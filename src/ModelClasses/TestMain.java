package ModelClasses;

import ModelClasses.Requirement.*;

import java.util.Arrays;

public class TestMain {


  public static void main(String[] args)
  {
    System.out.println("Hello Darkness");
                      //my old friend
    //Creating a ProjectList
    ProjectList wick = new ProjectList();


    //MyDate check
    MyDate l=new MyDate(12,12,2021);

    //Adding a project
    wick.addProject("Title","id","cid",l,"comment");
    //Adding requirements to the project
    wick.getProjectByTitle("Title").addUserStory("ID", "Description", l);
    wick.getProjectByTitle("Title").addUserStory("ID2", "Description", l);
    //Adding tasks to the requirements and getting all the information about the tasks
    wick.getProjectByTitle("Title").getUserStoryRequirementByID("ID").createNewTask("taskID0", "Description", 100);
    wick.getProjectByTitle("Title").getUserStoryRequirementByID("ID").createNewTask("taskID1", "Description5", 10);
    System.out.println(wick.getProjectByTitle("Title").getUserStoryRequirementByID("ID").getRequirementTasks());





  }
}