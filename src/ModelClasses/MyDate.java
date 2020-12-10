package ModelClasses;

import java.time.LocalDate;

/**
 * A class of MyDate objects, extending Object class.
 *
 * @author Allie
 * @version 4.0 - 10.12.20
 */
public class MyDate
{
    private int day;
    private int month;
    private int year;
    private LocalDate today;

    /**
     * Three-argument constructor. 'today' field is set to today's date by calling to a method in the LocalDate java
     * class.
     *
     * @param day
     *         Needs to be greater than zero, cannot exceed the referenced month's number of days.
     * @param month
     *         Needs to be greater than zero, cannot exceed 12.
     * @param year
     *         Needs to be greater than zero, cannot be less than the current year.
     */
    public MyDate(int day, int month, int year)
    {
        setDeadline(day,month,year);
        this.today = LocalDate.now();
    }

    /**
     * Getting today's date
     *
     * @return MyLocalDate today object instance variable.
     */
    public LocalDate getToday()
    {
        return today;
    }

    public int getYearToday()
    {
        return LocalDate.now().getYear();
    }

    /**
     * Setter for the int instance variables that calls to a validity check method and if it does not meet the check's
     * standard the setter throws an exception.
     *
     * @param day
     *         Needs to be greater than zero, cannot exceed the referenced month's number of days.
     * @param month
     *         Needs to be greater than zero, cannot exceed 12.
     * @param year
     *         Needs to be greater than zero, cannot be less than the current year.
     * @throws IllegalArgumentException
     *         If day isn't greater than zero or exceeds the referenced month's number of days.
     *         If month isn't greater than zero or exceeds 12.
     *         If year isn't greater than zero or is lesser than the current year.
     */
    public void setDeadline(int day, int month, int year)
    {
        if (isValidDate(day,month,year))
        {
            this.day = day;
            this.month = month;
            this.year = year;
        }
        else
        {
            throw new IllegalArgumentException("Please enter a valid date");
        }
    }

    /**
     * Showing the year.
     *
     * @return the year instance variable.
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Showing the month.
     *
     * @return the month instance variable.
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * Showing the day.
     *
     * @return the day instance variable.
     */
    public int getDay()
    {
        return day;
    }


    public boolean isValidDate(MyDate deadline)
    {
        MyDate today=new MyDate(getToday().getDayOfMonth(), getToday().getMonthValue(), getToday().getYear());
        return (!(deadline.isBefore(today)) || deadline.getDay()>0 || deadline.getMonth()>0 || deadline.getMonth()<12 || deadline.getDay()<=numberOfDaysInMonth(deadline.getMonth()) || deadline.getYear()>0);
    }
    /**
     * Boolean validity check.
     *
     * @param day
     * int value of day
     * @param month
     * int value of month
     * @param year
     *         int value of year
     *
     * @return 'true' if day is greater than zero or exceeds the referenced month's number of days, if month is greater
     *         than zero or exceeds 12 and if year is greater than zero or is lesser than the current year, otherwise
     *         it returns 'false'.
     */

    public boolean isValidDate(int day, int month, int year)
    {
        if (!(day < 0 || month < 0 || month > 12 || day > numberOfDaysInMonth(month) || year < 0 || year < getYearToday()))
        {
            MyDate m=new MyDate(day,month,year);
            MyDate n=new MyDate(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(),LocalDate.now().getYear());
            if (m.isBefore(n))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Boolean method to see if a year was/is a leap year or not.
     *
     * @return 'true' if it is a leap year, 'false' if not.
     */
    public boolean isLeapYear()
    {
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }

    /**
     * Converting a month's int to a String of the month's Gregorian name.
     *
     * @return String containing the corresponding month integer's name.
     */
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

    /**
     * Getting how many days are in a given month.
     *
     * @param month
     *          Integer value.
     * @return Integer for number of days in the month. Default of '31', for months 4, 6, 9 and 11 it returns '30'. If
     *          it's a leap year then it returns month 2 as '29', if not then it returns '28'.
     */
    public int numberOfDaysInMonth(int month)
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

    /**
     * Converting a month's Gregorian name into an int value.
     *
     * @return Integer ranging from '1' to '12' with a default of '1'.
     */
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

    /**
     * Boolean method to see if one MyDate object is the same as another.
     *
     * @return 'true' if it is a leap year, 'false' if not.
     */
    public boolean isBefore(MyDate other)
    {
        int theseDays = year * 365 + month * 31 + day;
        int otherDays = other.year * 365 + other.month * 31 + other.day;
        return theseDays < otherDays;
    }

    public boolean isBefore(int day, int month, int year)
    {
        if (isValidDate(day,month,year))
        {
            MyDate other = new MyDate(day, month, year);
            int theseDays = year * 365 + month * 31 + day;
            int otherDays = other.year * 365 + other.month * 31 + other.day;
            return theseDays < otherDays;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof MyDate))
        {
            return false;
        }
        else
        {
            MyDate other = (MyDate) obj;
            return this.day == other.getDay() || this.month == other.getMonth() || this.year == other.getYear();
        }
    }

    @Override
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