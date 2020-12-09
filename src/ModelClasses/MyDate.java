package ModelClasses;

public class MyDate
{
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year)
    {
        setDeadline(day, month, year);
    }

    public MyDate(int day, String monthName, int year)
    {
        this.day = day;
        this.month = convertToMonthNumber(monthName);
        this.year = year;
    }

    public void setDeadline(int day, int month, int year)
    {
        if (year < 0)
        {
            year = -year;
        }
        if (month < 1)
        {
            month = 1;
        }
        else if (month > 12)
        {
            month = 12;
        }
        this.year = year;
        this.month = month;
        if (day < 1)
        {
            day = 1;
        }
        else if (day > numberOfDaysInMonth())
        {
            day = numberOfDaysInMonth();
        }
        this.day = day;
    }

    public boolean isLeapYear()
    {
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }

    public String getMonthName()
    {
        switch (month)
        {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "Error";
        }
    }

    public int numberOfDaysInMonth()
    {
        switch (month)
        {
            case 2:
                if (isLeapYear())
                {
                    return 29;
                }
                return 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    public int convertToMonthNumber(String monthName)
    {
        switch (monthName)
        {
            case "February":
                return 2;
            case "March":
                return 3;
            case "April":
                return 4;
            case "May":
                return 5;
            case "June":
                return 6;
            case "July":
                return 7;
            case "August":
                return 8;
            case "September":
                return 9;
            case "October":
                return 10;
            case "November":
                return 11;
            case "December":
                return 12;
            default:
                return 1;
        }
    }

    public boolean isBefore(MyDate other)
    {
        int theseDays = year * 365 + month * 31 + day;
        int otherDays = other.year * 365 + other.month * 31 + other.day;
        return theseDays < otherDays;
    }


    public String toString()
    {
        String s = "";
        if (day < 10)
        {
            s += "0";
        }
        s += day + "/";
        if (month < 10)
        {
            s += "0";
        }
        s += month + "/" + year;
        return s;
    }
}