package ModelClasses;

/**
 * An enum of Status constants.
 *
 * @author Group 1
 * @version 1.0 - 14.12.20
 */
public enum Status
{
    WAITING("Waiting"), STARTED("Started"), ENDED("Ended"), REJECTED("Rejected"), ACCEPTED("Accepted"), TEST("Testing");

    private final String statusString;

    /**
     * One-argument constructor.
     *
     * @param statusString
     *         String value of enum constant
     */
    Status(String statusString)
    {
        this.statusString = statusString;
    }

    /**
     * Getting String value of a Status
     *
     * @return String of the enum constant's status
     */
    public String getStatusString()
    {
        return statusString;
    }
}
