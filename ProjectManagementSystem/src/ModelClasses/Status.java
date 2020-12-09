package ModelClasses;

public enum Status
{WAITING("Waiting"),STARTED("Started"),ENDED("Ended"),REJECTED("Rejected"),TEST("Testing");

  private Status(final String statusString) {
    this.statusString = statusString;
  }

  private String statusString;

  public String getStatusString()
  {
    return statusString;
  }
}
