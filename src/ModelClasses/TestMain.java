package ModelClasses;

import ModelClasses.Requirement.*;

import java.util.Arrays;

public class TestMain {


  public static void main(String[] args)
  {
    System.out.println("Hello Darkness");
                      //my old friend
    ProjectList wick = new ProjectList();


    //MyDate check
    MyDate l=new MyDate(12,12,2021);


    //Wouldn't it be better to pass all the parameters required for creation of the project instead of an object?
    //Where are all the checks called when a project is created?
    wick.addProject("Title","id","cid",l,"comment");
    wick.getProjectByTitle("Title").addUserStory("ID", "Description", l);
    wick.getProjectByTitle("Title").getUserStoryRequirementByID("ID").createNewTask("taskID0", "Description", 100);
    wick.getProjectByTitle("Title").getUserStoryRequirementByID("ID").createNewTask("taskID1", "Description5", 10);
    System.out.println(wick.getProjectByTitle("Title").getUserStoryRequirementByID("ID").getRequirementTasks());



  }
}