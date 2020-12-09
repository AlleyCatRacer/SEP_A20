package ModelClasses;

public class TimeTest
{
    public static void main(String[] args)
    {
        TimeSpent log=new TimeSpent(0,"ID");
        double illegal = 0.9;
        double legal = 0.5;
        double lEgal= 2.0;
        int iLlegal = 3;
        double leGal = 3;

        log.logHours(illegal,"id");
        System.out.println("illegal: "+log.getHours());
    }
}
