package ModelClasses.Requirement;

public enum Priority
{
    UNDEFINED("Undefined"), LOW("Low"), MEDIUM("Medium"), HIGH("High"), CRITICAL("Critical");

    private String priorityString;

    Priority(final String priorityString)
    {
        this.priorityString = priorityString;
    }

    public String getPriorityString()
    {
        return priorityString;
    }
}
