package ModelClasses;

import ModelClasses.Requirement.*;
import java.util.ArrayList;
import java.util.IllegalFormatWidthException;

public class Project
{
  private String title;
  private final String customerId;
  private final String projectId;
  private MyDate deadline;
  private String comment;
  private double timeSpent;
  private String currentStatus;
  private ArrayList<Requirement> requirements;
  private ArrayList<TeamMember> projectTeam;

  public Project(String title,String projectId,String customerId, MyDate deadline, String comment){
    requirements = new ArrayList<>();
    isValidTitle(title);
    this.title=title;
    isValidProjectId(projectId);
    this.projectId=projectId;
    isValidCustomerId(customerId);
    this.customerId=customerId;
    setDeadline(deadline);
    this.deadline=deadline;
    isValidComment(comment);
    this.comment=comment;
    this.timeSpent=0;
    this.currentStatus=Status.WAITING.getStatusString();
    projectTeam = new ArrayList<>();
  }

  //constructor for Project class sets title, projectId, customerId, deadline and comment and checks each argument

  public ArrayList<Requirement> getRequirements() {
    return requirements;
  }

  public String getTitle()
  {
    return title;
  }

  public String getProjectId() {
    return projectId;
  }
  public String getCustomerId() {
    return customerId;
  }

  public MyDate getDeadline() {
    return deadline;
  }
  public String getComment() {
    return comment;
  }
  public double getTimeSpent() {
    return timeSpent;
  }

  public String getCurrentStatus() {
    return currentStatus;
  }


  //This piece of a joy will not see daylight unless it starts behaving

  /*public Requirement getRequirementByID(String requirementID) {
    for(int i = 0; i < requirements.size(); i++) {
      if(requirements.get(i).getRequirementId().equals(requirementID)) {
        if(requirements.get(i) instanceof UserStory)
        {
         return (UserStory) requirements.get(i);
        }else if (requirements.get(i) instanceof ProjectRelated)
        {
          getProjectRelatedRequirement(i);
          return null;
        }else if (requirements.get(i) instanceof NonFunctional)
        {
          getNonFunctionalRequirement(i);
          return null;
        }
      }
    }
    return null;
  }

  public UserStory getUserStoryRequirement(int index) {
    return (UserStory) requirements.get(index);
  }
  public ProjectRelated getProjectRelatedRequirement(int index) {
    return (ProjectRelated) requirements.get(index);
  }
  public NonFunctional getNonFunctionalRequirement(int index) {
    return (NonFunctional) requirements.get(index);
  }
*/

  public ProjectRelated getProjectRelatedRequirementByID(String requirementID) {
    for (Requirement requirement : requirements)
    {
      if (requirement.getRequirementId().equals(requirementID))
        return (ProjectRelated) requirement;
    }
    throw new IllegalArgumentException("The Project Related requirement with such ID was not found");
  }
  public UserStory getUserStoryRequirementByID(String requirementID) {
    for (Requirement requirement : requirements)
    {
      if (requirement.getRequirementId().equals(requirementID))
        return (UserStory) requirement;
    }
    throw new IllegalArgumentException("The User Story requirement with such ID was not found");
  }
  public NonFunctional getNonFunctionalRequirementByID(String requirementID) {
    for (Requirement requirement : requirements)
    {
      if (requirement.getRequirementId().equals(requirementID))
        return (NonFunctional) requirement;
    }
    throw new IllegalArgumentException("The Non Functional requirement with such ID was not found");
  }

  public String getProjectTeam(){
    String s="";
    for (TeamMember e : projectTeam)
    {
      s += " " +e.getName()+"~"+e.getTeamMemberId()+",";
    }
    return s;
  }

  public void addProjectTeamMember(String name, String teamMemberId){
    TeamMember teamMember= new TeamMember(name,teamMemberId);
    projectTeam.add(teamMember);
  }

  public void removeProjectTeamMember(String teamMemberId){
    boolean doesExist = false;
    for (int i = 0; i < projectTeam.size(); i++)
    {
      if (projectTeam.get(i).getTeamMemberId().equals(teamMemberId))
      {
        doesExist = true;
        TeamMember member = projectTeam.get(i);
        projectTeam.remove(member);
      }
    }
    if (!doesExist) throw new IllegalArgumentException();
  }

  public void changeTitle(String title)
  {
    this.title = title;
  }

  //Basically a setter for Title

  public void setDeadline(MyDate deadline)
  {
    this.deadline = deadline;
  }

  //Basically a setter for Deadline

  public void editComment(String comment)
  {
    this.comment = comment;
  }

  //Basically a setter for comment

  public void editTimeSpent(double timeSpent) {
    this.timeSpent = timeSpent;
  }

  public void editStatus(Status status ){
    this.currentStatus =status.getStatusString();
  }

//sets the currentStatus to the String value of Status status


  public void removeRequirement(String requirementId){
    requirements.forEach((e) -> {
      if (e.getRequirementId().equals(requirementId)){
        requirements.remove(e);
      }
    });
  }

  //removes project by the given Id

  public boolean isUniqueTaskIdWithinTheProject(String taskID) {
    for(int i = 0; i < requirements.size(); i++) {
      if(requirements.get(i) instanceof UserStory)
        for(int k = 0; k < ((UserStory) requirements.get(i)).getRequirementTasks().size(); k++) {
          if(((UserStory) requirements.get(i)).getRequirementTasks().get(k).getTaskId().equalsIgnoreCase(taskID))
            return false;
        }
    }
    return true;
  }

  //Checks whether the input taskID is valid across the entire project. But I am not sure does it have use because I can't find a way to pass the taskID to it

  public void addNonFunctional(String requirementId, String description){
    NonFunctional n=new NonFunctional(requirementId,description);
    String id = n.getRequirementId();
    isValidRequirementID(id);
    isValidComment(description);
    requirements.forEach((e) -> {
      if(e.getRequirementId().equals(id))
      {
        throw new IllegalArgumentException();
      }
    });
    requirements.add(n);
  }

  public void addUserStory(String REQUIREMENTID, String description, MyDate deadline){
    UserStory u=new UserStory(REQUIREMENTID,description,deadline);
    String id = u.getRequirementId();
    isValidRequirementID(id);
    setDeadline(deadline);
    isValidComment(description);
    requirements.forEach((e) -> {
      if(e.getRequirementId().equals(id))
      {
        throw new IllegalArgumentException();
      }
    });
    requirements.add(u);
  }


  public void addProjectRelatedRequirement(String requirementId, String description, MyDate deadline){
    ProjectRelated r = new ProjectRelated(requirementId,description,deadline);
    String id = r.getRequirementId();
    isValidRequirementID(id);
    r.getDeadline().isValidDate(r.getDeadline());
    isValidTime(timeSpent);
    isValidComment(description);
    requirements.forEach((e) -> {
      if(e.getRequirementId().equals(id))
      {
        throw new IllegalArgumentException("Please enter a requirement ID containing 2 or more letters and/or numbers that is unique withing the project");
      }
    });
    requirements.add(r);
  }

  public boolean isValidProjectId(String projectId){
    if (!projectId.matches("[a-zA-Z0-9]*")){
      IllegalArgumentException e=new IllegalArgumentException("Please enter a unique project ID containing 2 or more letters and/or numbers");
      throw e;
    }else if (projectId.length()>8){
      throw new IllegalFormatWidthException(projectId.length());
    }else{
      return true;
    }
  }

  //project id must not contain anything else then numbers and letters/capital letters and should be 8 digits/chars for now

  public boolean isValidTitle(String title){
    if (!title.matches("[a-zA-Z0-9]*")){
      throw new IllegalArgumentException();
    }else if (title.length()>25){
      throw new IllegalFormatWidthException(title.length());
    }else{
      return true;

    }
  }

  //can only contain letters and max 25 chars for now

  public boolean isValidCustomerId(String customerId){
    if (!customerId.matches("[a-zA-Z0-9]*")){
      throw new IllegalArgumentException();
    }else if (customerId.length()>8){
      throw new IllegalFormatWidthException(customerId.length());
    }else{
      return true;
    }
  }

  //same as projectID for now

  public boolean isValidComment(String comment){
    if (!comment.matches("[a-zA-Z]*")){
      throw new IllegalArgumentException();
    }else if (comment.length()>250){
      throw new IllegalFormatWidthException(comment.length());
    }else{
      return true;
    }
  }

  //can only contain letters and max 250 chars for now

  public boolean isValidRequirementID(String requirementId) {
    if (!requirementId.matches("[a-zA-Z0-9]*")){
      IllegalArgumentException e=new IllegalArgumentException("Please enter a requirement ID containing 2 or more letters and/or numbers that is unique within the project");
      throw e;
    }else if (requirementId.length()<2){
      throw new IllegalFormatWidthException(requirementId.length());
    }else{
      return true;
    }
  }

  public boolean isValidTime(double hours)
  {
    if (hours%0.5==0)
    {
      return true;
    }
    else
    {
      IllegalArgumentException e=new IllegalArgumentException("Please enter only whole and/or half hours");
      throw e;
    }
  }




  @Override public String toString()
  {
    return "{title='" + title + '\'' + ", customerId='" + customerId
                   + '\'' + ", projectId='" + projectId + '\'' + ", deadline=" + deadline
                   + ", comment='" + comment + '\'' + ", timeSpent=" + timeSpent
                   + ", currentStatus='" + currentStatus + '}'+"\n";
  }
}