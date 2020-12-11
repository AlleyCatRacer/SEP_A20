<<<<<<< Updated upstream:Delimited/src/Delimited/Time.java
package Delimited;

=======
>>>>>>> Stashed changes:Dropped/Time.java
public class Time
{
    private double hours;

    public Time(double hours)
    {
        setHours(hours);
    }

<<<<<<< Updated upstream:Delimited/src/Delimited/Time.java
    public void setHours(double hours) //throws whichever exception
=======
    public void setHours(double hours)
>>>>>>> Stashed changes:Dropped/Time.java
    {
        if (isValidTime(hours))
        {
            this.hours=hours;
        }
<<<<<<< Updated upstream:Delimited/src/Delimited/Time.java
        //add exception
=======
>>>>>>> Stashed changes:Dropped/Time.java
    }

    public double getHours()
    {
        return this.hours;
    }

    public boolean isValidTime(double hours)
    {
<<<<<<< Updated upstream:Delimited/src/Delimited/Time.java
        if (hours%0.5==0)
=======
        if (hours >= 0.5)
>>>>>>> Stashed changes:Dropped/Time.java
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override public String toString()
    {
        String s = "";
        s+= "Hours: "+getHours();
        return s;
    }
<<<<<<< Updated upstream:Delimited/src/Delimited/Time.java

=======
>>>>>>> Stashed changes:Dropped/Time.java
}
