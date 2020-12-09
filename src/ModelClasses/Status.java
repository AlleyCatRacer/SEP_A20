package ModelClasses;

public enum Status
{
    WAITING("Waiting"), STARTED("Started"), ENDED("Ended"), REJECTED("Rejected"), TEST("Testing");

    private String statusString;

    private Status(final String statusString)
    {
        this.statusString = statusString;
    }

    public String getStatusString()
    {
        return statusString;
    }
}
