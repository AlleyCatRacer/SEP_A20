package ModelClassess;

public class Time
{
    private double hours;

    public Time(double hours)
    {
        setHours(hours);
    }

    public void setHours(double hours)
    {
        if (isValidTime(hours))
        {
            this.hours=hours;
        }
    }

    public double getHours()
    {
        return this.hours;
    }

    public boolean isValidTime(double hours)
    {
        if (hours >= 0.5)
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
}
