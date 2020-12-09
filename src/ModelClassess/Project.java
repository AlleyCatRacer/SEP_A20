package ModelClassess;

import java.util.IllegalFormatWidthException;

public class Project
{
  String title;
  String customerId;
  String projectId;
  MyDate deadline;
  String comment;
  TimeSpent timeSpent;
  String currentStatus;

  public Project(String title,String projectId,String customerId,MyDate deadline, String comment){
    this.title=title;
    this.projectId=projectId;
    this.customerId=customerId;
    this.deadline=deadline;
    this.comment=comment;
  }
//constructor for Project class sets title, projectId, customerId, deadline and comment
//i need to add a way to add project to project list on creation
  public void editStatus(Status status ){
   this.currentStatus =status.getStatusString();
  }
//sets the currentStatus to the String value of Status status
  public void editComment(String comment)
  {
    this.comment = comment;
  }
//Basically a setter for comment
  public void setDeadline(MyDate deadline)
  {
    this.deadline = deadline;
  }
//Basically a setter for Deadline
  public void changeTitle(String title)
  {
    this.title = title;
  }
//Basically a setter for Title
  public void addTeamMember(String teamMemberId){
//404
  }
  public void removeTeamMember(String teamMemberId){
//404
  }
  public void removeRequirement(String requirementId){
//404
  }
  public void editRequirement(String requirementId){
//404
  }
  public void addNonFunctional(String requirementId, String description,String status){
//404
  }
  public void addUserStory(String requirementId, String description,String status,MyDate deadline){
//404
  }
  public void addProjectRelatedRequirement(String requirementId, String description,String status,MyDate deadline){
//404
  }
  public double getTimeSpentOnProject(String projectId)
  {
//404
    return 0;
  }
  public boolean isValidProjectId(){
    if (this.projectId.matches("[a-zA-Z0-9]*")){
     return false;
    }else if (this.projectId.length()>8){
      return false;
    }else{
      return true;
    }
  }
  //project id must not contain anything else then numbers and letters/capital letters and should be 8 digits/chars for now
  public boolean isValidTitle(){
    if (this.title.matches("[a-zA-Z]*")){
      throw new IllegalArgumentException();
    }else if (this.title.length()>25){
     throw new IllegalFormatWidthException(this.projectId.length());
    }else{
      return true;
    }
  }
  //can only contain letters and max 25 chars for now
  public boolean isValidCustomerId(){
    if (this.customerId.matches("[a-zA-Z0-9]*")){
      throw new IllegalArgumentException();
    }else if (this.customerId.length()>8){
      throw new IllegalFormatWidthException(this.projectId.length());
    }else{
      return true;
    }
  }
  //same as projectID for now
  public boolean isValidComment(){
    if (this.comment.matches("[a-zA-Z]*")){
      throw new IllegalArgumentException();
    }else if (this.comment.length()>250){
      throw new IllegalFormatWidthException(this.projectId.length());
    }else{
      return true;
    }
  }
  //can only contain letters and max 250 chars for now







}