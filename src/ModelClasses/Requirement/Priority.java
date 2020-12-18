package ModelClasses.Requirement;

/**
 * An enum of Priority constants.
 *
 * @author Group 1
 * @version 1.0 - 14.12.20
 */

public enum Priority
{
    UNDEFINED("Undefined"), LOW("Low"), MEDIUM("Medium"), HIGH("High"), CRITICAL("Critical");

    private String priorityString;

    /**
     * One-argument constructor.
     *
     * @param priorityString
     *         String value of enum constant
     */
    Priority(final String priorityString)
    {
        this.priorityString = priorityString;
    }

    /**
     * Getting String value of a Priority
     *
     * @return String of the enum constant's status
     */
    public String getPriorityString()
    {
        return priorityString;
    }
}
