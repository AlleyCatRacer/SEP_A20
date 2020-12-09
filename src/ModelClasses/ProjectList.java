package ModelClasses;

import java.util.ArrayList;

public class ProjectList
{    //sorry haven't started this yet
  private ArrayList<Project> projects;
  public ProjectList(){
    projects = new ArrayList<>();
  }
  public Project getProjectByTitle(String title){
    return null;
  }
  public Project getEndedProjectByTitle(String title){
    return null;
  }
  public void addProject(Project project){
      projects.add(project);
  }
  public void removeProject(String title){

  }
  public ArrayList<Project> getAllProjects(Status status){

    return null;
}

  @Override public String toString()
  {
    String s ="Current Projects:\n";:

    return s;
  }
}
