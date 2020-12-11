package ModelClasses;

import java.util.Arrays;

public class TestMain {


  public static void main(String[] args)
  {
    System.out.println("Hello Darkness");

    ProjectList wick = new ProjectList();


    //MyDate check
    MyDate l=new MyDate(12,12,2020);
    Project p=new Project("Title","id","cid",l,"comment");

    //Wouldn't it be better to pass all the parameters required for creation of the project instead of an object?
    //Where are all the checks called when a project is created?
    wick.addProject(p);
    p.addUserStory("ID", "Description", l);
    System.out.println(p.getRequirementByID("ID").getType());


  }
}