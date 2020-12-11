<<<<<<< Updated upstream:Delimited/src/Delimited/TimeSpent.java
package Delimited;

=======
>>>>>>> Stashed changes:Dropped/TimeSpent.java
import java.util.ArrayList;

public class TimeSpent extends Time
{
    String id;
    ArrayList<TimeSpent> loggedHours;

    TimeSpent(double hours, String id)
    {
        super(hours);
        this.id=id;
        this.loggedHours = new ArrayList<>();
    }

<<<<<<< Updated upstream:Delimited/src/Delimited/TimeSpent.java
/*    public double getTimeSpentOnTask(String taskId)
=======
    public double getTimeSpentOnTask(String taskId)
>>>>>>> Stashed changes:Dropped/TimeSpent.java
    {
        double loggedTime = 0;
        for (int i=0;i<loggedHours.size();i++)
        {
            if (taskId.equalsIgnoreCase(loggedHours.get(i).getId()))
            {
                loggedTime += loggedHours.get(i).getHours();
                i++;
            }
        }
        return loggedTime;
    }
<<<<<<< Updated upstream:Delimited/src/Delimited/TimeSpent.java
*/
/*    public double getTimeSpentOnProject(String projectId)
=======

    public double getTimeSpentOnProject(String projectId)
>>>>>>> Stashed changes:Dropped/TimeSpent.java
    {
        double loggedTime = 0;
        for (int i=0;i<loggedHours.size();i++)
        {
            if (requirementId.equalsIgnoreCase(loggedHours.get(i).getId()))
            {
                loggedTime += loggedHours.get(i).getHours();
                i++;
            }
        }
        return loggedTime;
    }

<<<<<<< Updated upstream:Delimited/src/Delimited/TimeSpent.java
    public void logHours(double hours, String taskId) //throw an exception because you can't create a time spent without a task
=======
    public void logHours(double hours, String taskId)
>>>>>>> Stashed changes:Dropped/TimeSpent.java
    {
        for (int i=0;i<loggedHours.size();i++)
        {
            if (taskId.equalsIgnoreCase(loggedHours.get(i).getId()))
            {
                loggedHours.get(i).setHours(loggedHours.get(i).getHours()+hours);
                break;
            }
            else
            {
                TimeSpent log=new TimeSpent(hours, taskId);
                loggedHours.add(log);
            }
        }
    }
<<<<<<< Updated upstream:Delimited/src/Delimited/TimeSpent.java
*/
=======
>>>>>>> Stashed changes:Dropped/TimeSpent.java
}
