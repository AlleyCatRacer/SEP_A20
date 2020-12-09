package ModelClasses;

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

/*    public double getTimeSpentOnTask(String taskId)
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
*/
/*    public double getTimeSpentOnProject(String projectId)
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
*/
    public void logHours(double hours, String taskId) //throw an exception because you can't create a time spent without a task
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
}
