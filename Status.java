public enum Status
{WAITING("Waiting"),STARTED("Started"),ENDED("Ended"),REJECTED("Rejected"),TEST("Test");

  private Status(final String statusString) {
    this.statusString = statusString;
  }

  private String statusString;

  public String getStatusString()
  {
    return statusString;
  }
}
