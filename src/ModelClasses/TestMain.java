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
    MyDate l2=new MyDate(12,12,2022);

    //Adding a project
    wick.addProject("Title","id","cid",l,"comment");
    //Adding requirements to the project
    wick.getProjectByTitle("Title").addUserStory("ID", "Description", l);
    wick.getProjectByTitle("Title").addUserStory("ID2", "Description", l2);
    //Removing a requirement
    wick.getProjectByTitle("Title").removeRequirement("ID2");
    //Adding tasks to the requirements and getting all the information about the tasks
    wick.getProjectByTitle("Title").getUserStoryRequirementByID("ID").createNewTask("taskID0", "Description", 100);
    wick.getProjectByTitle("Title").getUserStoryRequirementByID("ID").createNewTask("taskID1", "Description5", 10);
    //Removing task
    wick.getProjectByTitle("Title").getUserStoryRequirementByID("ID").removeTask("taskID0");
    //Adding a member to a team
//    wick.getProjectByTitle("Title").addProjectTeamMember("Bob", "TheBuilder123");
    //Logging hours
    wick.getProjectByTitle("Title").getUserStoryRequirementByID("ID").getTaskByID("taskID1").logHours(15);
    wick.getProjectByTitle("Title").getUserStoryRequirementByID("ID").createNewTask("taskID0", "Description", 100);
    wick.getProjectByTitle("Title").getUserStoryRequirementByID("ID").getTaskByID("taskID0").logHours(23);
    //Changing priority
    wick.getProjectByTitle("Title").getUserStoryRequirementByID("ID").changePriority(Priority.CRITICAL);
    //Changing designated methodology i.e. comment
    wick.getProjectByTitle("Title").editComment("From now on iterative approach will be applied in this Kingdom!");
    wick.getProjectByTitle("Title").editStatus(Status.ACCEPTED);
    //Changing team member's role
//    wick.getProjectByTitle("Title").getProjectTeamMemberByID("TheBuilder123").setRole(Role.SCRUM_MASTER);
    //Changing requirement's status
    wick.getProjectByTitle("Title").getUserStoryRequirementByID("ID").changeStatus(Status.STARTED);
    //Automatic change of requirement's status when all tasks are completed
    wick.getProjectByTitle("Title").getUserStoryRequirementByID("ID").getTaskByID("taskID1").changeStatus(Status.ENDED);
    //Automatic update of an estimate and timeSpent when the task is updated
    wick.getProjectByTitle("Title").getUserStoryRequirementByID("ID").getTaskByID("taskID1").changeEstimate(50);



    //Figuring out the Team situation
    Team.hire("John", "123");
    Team.hire("StevieTheTV", "124");
    Team.hire("Geralt", "125");
    wick.getProjectByTitle("Title").addTeamMemberToTheProject("124");
    wick.getProjectByTitle("Title").addTeamMemberToTheProject("125");
    wick.getProjectByTitle("Title").editProjectMemberRole("125", Role.SCRUM_MASTER);
    System.out.println(wick.getProjectByTitle("Title").getMembersOfTheProject());








  }
}