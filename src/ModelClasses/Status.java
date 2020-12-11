package ModelClasses;

/**
 *
 *
 *
 *
 *
 * */

public enum Status
{
    WAITING("Waiting"), STARTED("Started"), ENDED("Ended"), REJECTED("Rejected"), ACCEPTED("Accepted"), TEST("Testing");

    private final String statusString;

    Status(final String statusString)
    {
        this.statusString = statusString;
    }

    public String getStatusString()
    {
        return statusString;
    }
}
