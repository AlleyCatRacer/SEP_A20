public class Estimate extends Time
{
    private String id;


    Estimate(double hours, String id)
    {
        super( hours);
        this.id=id;
    }

    public void changeEstimate(double hours)
    {
        if (isValidTime(hours))
        {
            setHours(hours);
        }
    }

    public double getEstimate()
    {
        return getHours();
    }

    @Override public String toString()
    {
        String s= "";
        s+= "ID: "+this.id+", completion estimate: "+getHours();
        return s;
    }
}
